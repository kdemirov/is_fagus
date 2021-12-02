import React from "react";
import OrderRepository from "../../../repository/OrderRepository";
import OrderItem from "../items/OrderItem";
import AuthService from "../../../repository/authService";
import {toast} from "react-toastify";
import "../assets/products.css"
interface ClientsOrdersPageProps {
    orders:Array<any>
    user:any
}

interface ClientsOrdersPageState {
    user: any
    orders:Array<any>
}
toast.configure()
class ClientsOrdersPage extends React.Component<ClientsOrdersPageProps, ClientsOrdersPageState> {
    constructor(props: ClientsOrdersPageProps) {
        super(props);
        this.state = {
            user: {},
            orders:[]
        }
    }

    componentDidMount() {
        this.fetchOrders();
    }

    render() {
        let orders = this.getOrdersCard()
        return (
            <div className="productGrid">
                {orders}
            </div>
        )
    }

    fetchOrders = () => {
        OrderRepository.fetchAllByClientId(this.state.user.id)
            .then((response:any) => {
                this.setState({
                    orders: response.data
                })
            })
    }

    getCurrentUser=()=>{
        AuthService.getCurrentUser()
            .then(response=>{
                console.log("user",response.data)
                this.setState({
                    user:response.data
                })
            })
    }

    getOrdersCard = () => {
        return this.state?.orders?.map(o =>
            <OrderItem key={o.orderId} item={o} user={this.state.user}
                       orderShipped={this.orderShipped}
                       orderExtraParts={this.orderExtraParts}/>)
    }

    orderExtraParts=(orderId:number,partId:number,quantity:number)=>{
        OrderRepository.orderExtraPart(orderId,partId,quantity)
            .then(response=>{
                this.fetchOrders()
            })
    }
    orderShipped = (orderId: number) => {
        OrderRepository.orderShipped(orderId)
            .then(response => {
               this.fetchOrders();
            })
    }
}

export default ClientsOrdersPage;
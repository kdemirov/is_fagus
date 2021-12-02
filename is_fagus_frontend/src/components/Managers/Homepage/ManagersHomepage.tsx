import React from "react"
import OrderItem from "../items/OrderItem";
import WarrantRepository from "../../../repository/WarrantRepository";
import OrderRepository from "../../../repository/OrderRepository";
import "../assets/orders.css"
interface ManagersHomepageProps{

}
interface ManagersHomepageState{
    orders:Array<any>
}
class ManagersHomepage extends React.Component<ManagersHomepageProps,ManagersHomepageState>{

    constructor(props:ManagersHomepageProps) {
        super(props);
        this.state={
            orders:[]
        }
    }

    componentDidMount() {
        this.fetchOrders()
    }
    render() {
        let orders=this.renderCards()
        return (
            <div className="productGrid">
                {orders}
            </div>
        )
    }
    renderCards=()=>{
       return this.state.orders.map(o=>
       <OrderItem key={o.orderId} item={o} createWarrant={this.createWarrant}/>
       )
    }
    createWarrant=(orderId:number)=>{
        WarrantRepository.createWarrant(orderId)
            .then(response=>{

            })
    }

    fetchOrders=()=>{
        OrderRepository.fetchOrdersForManager()
            .then(response=>{
                this.setState({
                    orders:response.data
                })
            })
    }
}
export default ManagersHomepage
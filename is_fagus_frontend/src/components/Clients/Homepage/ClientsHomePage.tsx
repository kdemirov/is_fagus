import React from "react"
import OrderRepository from "../../../repository/OrderRepository";
import OrderPercentItem from "../items/OrderPercentItem";

interface ClientsHomePageProps {
    currentUser: any;
}

interface ClientsHomePageState {
    ordersPercent: Array<any>
    myOrdersPercent: Array<any>
}

class ClientsHomePage extends React.Component<ClientsHomePageProps, ClientsHomePageState> {
    constructor(props: ClientsHomePageProps) {
        super(props);
        this.state = {
            ordersPercent: [],
            myOrdersPercent: []
        }
    }

    componentDidMount() {
        this.fetchOrdersPercent()
        this.fetchMyOrdersPercent();
    }

    render() {
        let info = this.state.myOrdersPercent.length === 0? <span className="alert-info">
            Vo momentot se raboti na drugi naracki vo prilog se narackite na koi se raboti.
            Nasiot tim kje zapocne so vasata naracka vo najskoro vreme.
            Vi blagodarime za trpenieto.
        </span>:this.renderCards(false);
        let ordersPercent= this.state.myOrdersPercent.length !== 0 ? null : this.renderCards(true);
        return (
            <div className="recordBody">
                {info}
                {ordersPercent}
            </div>
        )
    }

    renderCards = (flag:boolean) => {
        if(flag){
           return this.state.ordersPercent.map(o=>
            <OrderPercentItem item={o}/>)
        }else{
            return this.state.myOrdersPercent.map(o=>
            <OrderPercentItem item={o}/>)
        }
    }
    fetchOrdersPercent = () => {
        OrderRepository.fetchOrderPercent()
            .then(response => {
                this.setState({
                    ordersPercent: response.data
                })
            })
    }
    fetchMyOrdersPercent = () => {
        OrderRepository.fetchMyOrderPercent()
            .then(response => {
                this.setState({
                    myOrdersPercent: response.data
                })
            })
    }
}

export default ClientsHomePage;
import React from "react"
import WarrantRepository from "../../../repository/WarrantRepository";
import OrderRepository from "../../../repository/OrderRepository";
import ProgressBar from "@ramonak/react-progress-bar";
import {Create} from "@mui/icons-material";
import {Tooltip} from "@mui/material";

interface OrderItemProps {
    item: any
    createWarrant: (orderId: number) => void
}

interface OrderItemState {
    percentDone:any | undefined
}

class OrderItem extends React.Component<OrderItemProps, OrderItemState> {

    constructor(props: OrderItemProps) {
        super(props);
        this.state={
            percentDone:undefined
        }
    }
    componentDidMount() {
        OrderRepository.fetchOrderPercentDoneById(this.props.item.orderId)
            .then((response)=>{
                this.setState({
                    percentDone:response.data
                })
            })
    }

    render() {
            let percentDone=this.renderPercentDone();
        return (
            <section className="root">
                <figure>
                    <img src="https://s-media-cache-ak0.pinimg.com/736x/49/80/6f/49806f3f1c7483093855ebca1b8ae2c4.jpg" alt=""/>
                    <figcaption>
                        <h4>Tracking Details</h4>
                        <h6>Order Number</h6>
                        <h2>{this.props.item.orderId}</h2>
                    </figcaption>
                </figure>
                <div className="order-track">
                    <div className="order-track-step">
                        <div className="order-track-text">
                            <p className="order-track-text-stat">Title</p>
                            <span className="order-track-text-sub">{this.props.item.title}</span>
                            <span className={"order-track-text-sub"}>
                                <form>
                                    <Tooltip title={"Kreiraj Nalog"}>
                                    <Create onClick={this.handleSubmit}/>
                                    </Tooltip>
                                </form>
                            </span>
                        </div>
                    </div>
                    {percentDone}
                    {/*record Track*/}

                </div>
            </section>
        )
    }
    renderPercentDone=()=>{
        let percentDone=this.state.percentDone!==undefined?this.state.percentDone.percentDone:0
            return   <div className="order-track-step">
                <ProgressBar completed={percentDone}/>
            </div>


    }
    handleSubmit = (e: any) => {
        e.preventDefault()
        this.props.createWarrant(this.props.item.orderId)
    }
}

export default OrderItem
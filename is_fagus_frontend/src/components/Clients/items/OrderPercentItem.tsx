import React from "react";
import "../assets/homepage.css"
import ProgressBar from "@ramonak/react-progress-bar"
interface OrderPercentItemProps {
    item: any
}

interface OrderPercentItemState {

}

class OrderPercentItem extends React.Component<OrderPercentItemProps, OrderPercentItemState> {

    constructor(props: OrderPercentItemProps) {
        super(props);
    }

    renderPercentDone=()=>{
     return   <div className="order-track-step">
                <ProgressBar completed={this.props.item.percent}/>
        </div>

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
                        </div>
                    </div>
                    {percentDone}
                    {/*record Track*/}

                </div>
            </section>
        )
    }

}

export default OrderPercentItem;
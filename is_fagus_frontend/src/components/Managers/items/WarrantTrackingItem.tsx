import React from "react"
import {Tooltip} from "@mui/material";
interface WarrantTrackingItemProps{
    item:any
}
interface WarrantTrackingItemState{

}

class WarrantTrackingItem extends React.Component<WarrantTrackingItemProps, WarrantTrackingItemState>{
    constructor(props:WarrantTrackingItemProps) {
        super(props);

    }

    render() {
        let dateN=new Date(this.props.item.id.date)
        return (
            <div key={`trackingView${this.props.item.id.warrantId}${this.props.item.id.surname}
            ${this.props.item.id.date}`} className="order-track-step">
                <div className="order-track-status">
                    <Tooltip title={"broj na izraboteni delovi"}>
                    <span className="order-track-status-dot">{this.props.item.id.quantity}</span>
                    </Tooltip>
                    <span className="order-track-status-line"></span>


                </div>
                <div className="order-track-text">
                    <p className="order-track-text-stat">{this.props.item.id.name} {this.props.item.id.surname}</p>
                    <span className="order-track-text-sub">{dateN.toString()}</span>
                </div>
            </div>
        )
    }
}
export default WarrantTrackingItem;
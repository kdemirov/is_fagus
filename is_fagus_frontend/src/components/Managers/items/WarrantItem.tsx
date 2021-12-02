import React from "react";
import {Info} from "@mui/icons-material";
import "../../Clients/assets/homepage.css"
import WarrantRepository from "../../../repository/WarrantRepository";
import WarrantTrackingItem from "./WarrantTrackingItem";
import {Tooltip} from "@mui/material";
interface WarrantItemProps{
    item:any
    finishWarrant:(warrantId:number)=>void
}

interface WarrantItemState{
    trackingItems:Array<any>
}
class WarrantItem extends React.Component<WarrantItemProps,WarrantItemState>{

    constructor(props:WarrantItemProps) {
        super(props);
        this.state={
            trackingItems:[]
        }
    }
    componentDidMount() {
        WarrantRepository.fetchTrackingViewById(this.props.item.warrantId)
            .then(response=>{
                console.log(response.data)
                this.setState({
                    trackingItems:response.data
                })
            })
    }

    renderOrderRecordTrack=()=>{
        return this.state.trackingItems.map(t=>
        <WarrantTrackingItem item={t}/>
        )

    }
    render() {
        let date= new Date(this.props.item.startDate)
        return( <section className="root">
            <figure>
                <Info/>
                <figcaption>
                    <h4>Tracking Details</h4>
                    <h6>Warrant Number</h6>
                    <h2>{this.props.item.warrantId}</h2>
                    <div className="order-track-text">
                        <span className="order-track-text-sub">{date.toString()}</span>
                    </div>
                    <div className="order-track-text">
                        <Tooltip title={"Kraj na nalog"}>
                        <input type={"checkbox"} onChange={this.handleClick}/>
                        </Tooltip>
                    </div>
                </figcaption>
            </figure>
            <div className="order-track">
                {this.renderOrderRecordTrack()}
            </div>
        </section>)
    }
    handleClick=(e:any)=>{
        e.preventDefault();
        this.props.finishWarrant(this.props.item.warrantId)
    }
}

export default WarrantItem;
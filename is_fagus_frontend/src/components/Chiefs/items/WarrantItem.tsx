import React from "react";
import ChiefsRecords from "../Progresspage/ChiefsRecords";
import WarrantRepository from "../../../repository/WarrantRepository";
import "../chiefs.css"
interface WarrantItemProps {
    item: any
}

interface WarrantItemState {
    warrant: any | undefined
    activeIndex: number

}

class WarrantItem extends React.Component<WarrantItemProps, WarrantItemState> {

    constructor(props: WarrantItemProps) {
        super(props);
        this.state = {
            warrant: undefined,
            activeIndex:1
        }
    }

    componentDidMount() {
        this.getWarrant();
    }

    getWarrant = () => {
        WarrantRepository.getWarrant(this.props.item.warrantId)
            .then(response => {
                this.setState({
                    warrant: response.data
                })
            })

    }


    render() {
        let date = new Date(this.props.item.startDate)
        let progress = this.state.warrant!== undefined?this.renderProgress():null;
        return (

                <div className="container">
                    <div className="wrapper">
                        <ul className="steps">
                            <li className={this.state.activeIndex===1?"is-active":""}>Step 1</li>
                            <li className={this.state.activeIndex===2?"is-active":""}>Step 2</li>
                            <li className={this.state.activeIndex===3?"is-active":""}>Step 3</li>
                            <li className={this.state.activeIndex===4?"is-active":""}>Step 4</li>
                            <li className={this.state.activeIndex===5?"is-active":""}>Step 5</li>
                        </ul>
                        <h4>Vnesi Evidencija za nalog {this.props.item.warrantId}</h4>
                        <form className="form-wrapper">
                            {progress}
                        </form>
                    </div>
                </div>

        )
    }

    renderProgress = () => {
        return (
                <ChiefsRecords sendActiveIndex={this.sendActiveIndex} warrant={this.state?.warrant}/>
        )
    }
    sendActiveIndex=(index:number)=>{
        this.setState({
            activeIndex:(this.state.activeIndex+1)%5
        })
    }
}

export default WarrantItem;
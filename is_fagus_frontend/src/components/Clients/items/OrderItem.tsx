import React from "react";
import FurnitureService from "../../../repository/FurnitureService";
import OrderRepository from "../../../repository/OrderRepository";
import {AddShoppingCart, Clear, Done, InfoOutlined} from "@mui/icons-material";
import "../assets/products.css"
import "../assets/furnitureItem.scss"
interface OrderItemProps {
    item: any;
    user: any;
    orderShipped: (orderId: number) => void;
    orderExtraParts: (orderId: number, partId: number, quantity: number) => void
}

interface OrderItemState {
    parts: Array<any>
    part: number | undefined
    quantity: number | undefined
    orderedExtraParts: Array<any>
    style:string
}

class OrderItem extends React.Component<OrderItemProps, OrderItemState> {

    constructor(props: OrderItemProps) {
        super(props);
        this.state = {
            parts: [],
            part: undefined,
            quantity: undefined,
            orderedExtraParts: [],
            style:""
        }
    }

    componentDidMount() {
        this.fetchParts();
        this.fetchOrderedExtraParts();
    }

    fetchOrderedExtraParts = () => {
        OrderRepository.getExtraParts(this.props.item.orderId)
            .then(response => {
                this.setState({
                    orderedExtraParts: response.data
                })
            })
    }
    fetchParts = () => {
        FurnitureService.fetchFurnitureParts(this.props.item.orderId)
            .then(response => {
                console.log(response.data);
                this.setState({
                    parts: response.data
                })
            })
    }
    renderExtraOrderedParts=()=>{
       return  this.state.parts?.map(p=>
            <tr>
                <td>{p.partType}</td>
                <td>{p.price}</td>
            </tr>
    )
    }

    render() {
        let checked = !!this.props.item.shippedDate;
        let extraParts=this.orderExtraParts();
        let render=this.renderExtraOrderedParts();
        return (
            <div className="wrapper">
                <div className="container">
                    <div className="top"></div>
                    <div className={`bottom${this.state.style}`}>
                        <div className="left">
                            <div className="details">
                                {extraParts}
                                <p>£{this.props.item.price}</p>
                            </div>
                            <div className="buy" onClick={this.handleSubmit}>
                                <i className="material-icons">
                                    <AddShoppingCart/>
                                </i>
                            </div>
                        </div>
                        <div className="right">
                            <div className="done"><i className="material-icons"><Done/></i></div>
                            <div className="details">
                                <h1>Part</h1>
                                <p>Added to your cart</p>
                            </div>
                            <div className="remove" onClick={this.handleChange}><i className="material-icons"><Clear/></i></div>
                        </div>
                        <div className="inside">
                            <div className="icon"><i className="material-icons">Parts</i></div>
                            <div className="contents">
                                <table>
                                    <tr>
                                        <th>Width</th>
                                        <th>Height</th>
                                    </tr>
                                    <tr>
                                        <td>3000mm</td>
                                        <td>4000mm</td>
                                    </tr>
                                    <tr>
                                        <th>Part Name</th>
                                        <th>Part Price</th>
                                    </tr>
                                    {render}
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    getOrderedExtraParts = () => {
        return this.state.orderedExtraParts.map(p =>
            <li className="list-group-item">{p.partType} {p.quantity}</li>
        )
    }
    orderExtraParts = () => {
        if (this.state.parts.length !== 0) {
            return <form>
                        <select onChange={this.handleChange} className="form-control-sm" name={"part"}
                                key={this.props.item.orderId}
                                required>
                            <option value="" disabled selected>Odberi</option>
                            {this.state.parts.map(p =>
                                <option className="form-control" value={p.furniturePartsViewId.partId}>{p.partType}
                                    {p.price}</option>
                            )}
                        </select>
                        <input type={"number"} className="form-control-sm"
                               id={"quantity"} name={"quantity"} required onChange={this.handleChange}/>
            </form>
        }
    }
    handleSubmit = (e: any) => {
        e.preventDefault()
        this.props.orderExtraParts(this.props.item.orderId,
            this.state.part as number, this.state.quantity as number)
        this.fetchOrderedExtraParts()
    }
    handleChange = (e: any) => {
        e.preventDefault()
        this.setState({
            [e.target.name]: e.target.value
        } as Pick<OrderItemState, keyof OrderItemState>)
    }
}

export default OrderItem;
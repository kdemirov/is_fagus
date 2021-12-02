import React from "react"
import FurnitureService from "../../../repository/FurnitureService";
import "../assets/shopping-cart.scss"
import {Add} from "@mui/icons-material";

interface ShoppingCartItemProps {
    item: any
    order:(idMebel:number,quantity:number)=> void
}

interface ShoppingCartItemState {
    description: string
    parts: Array<any>
    quantity: number,
    quantityExtraPart: number
}

class ShoppingCartItem extends React.Component<ShoppingCartItemProps, ShoppingCartItemState> {

    constructor(props: ShoppingCartItemProps) {
        super(props);
        this.state = {
            description: "",
            parts: [],
            quantity: 1,
            quantityExtraPart: 1
        }
    }

    componentDidMount() {
        this.fetchParts();
    }

    fetchParts = () => {
        FurnitureService.fetchFurnitureParts(this.props.item.idMebel)
            .then((response: any) => {
                this.setState({
                    parts: response.data
                })
            })
    }

    render() {
        let cena = this.props.item.furniturePrice * this.state.quantity
        return (
            <div className="product">
                <div className="product-image">
                    <img src="https://s-media-cache-ak0.pinimg.com/736x/49/80/6f/49806f3f1c7483093855ebca1b8ae2c4.jpg"/>
                </div>
                <div className="product-details">
                    <div className="product-title">{this.props.item.furnitureTitle}</div>
                    <textarea className="product-description" defaultValue={this.state.description}
                              name={"description"}
                              onChange={this.handleChange}/>
                </div>
                <div className="product-price">{this.props.item.furniturePrice}</div>
                <div className="product-quantity">
                    <form>
                    <input type="number" min="1" name={"quantity"}
                           onChange={this.handleChange}/>
                    </form>
                </div>
                <div className={"product-removal"}>
                    <form onSubmit={this.handleOrder}>
                        <button><Add/></button>
                    </form>
                </div>
                <div className="product-line-price">{cena}</div>

            </div>
        )
    }
    handleOrder=(e:any)=>{
        e.preventDefault();
        localStorage.setItem("furnitureId",JSON.stringify(this.props.item.id.furnitureId))
        localStorage.setItem("quantity",JSON.stringify(this.state.quantity))
        this.props.order(this.props.item.id.furnitureId,this.state.quantity)
        this.setState({
            quantity:1
        })
    }



    handleChange = (e: any) => {
        this.setState({
            [e.target.name]: e.target.value
        } as Pick<ShoppingCartItemState, keyof ShoppingCartItemState>)
    }
}

export default ShoppingCartItem;
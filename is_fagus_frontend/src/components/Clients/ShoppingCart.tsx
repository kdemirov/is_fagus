import React from "react"
import ShoppingCartRepository from "../../repository/ShoppingCartRepository";
import ShoppingCartItem from "./items/ShoppingCartItem";
import OrderRepository from "../../repository/OrderRepository";
import {OrderDto} from "../../shared/shared";
import "../Clients/assets/shopping-cart.scss"
interface ShoppingCartProps {

}

interface ShoppingCartState {
    shoppingCart:Array<any>
    orderParts:Array<number>
    orderQuan:Array<number>
}

class ShoppingCart extends React.Component<ShoppingCartProps, ShoppingCartState> {
    constructor(props: ShoppingCartProps) {
        super(props);
        this.state={
            shoppingCart:[],
            orderParts:[],
            orderQuan:[]
        }
    }

    componentDidMount() {
        this.fetchShoppingCart()
        this.setState({
            orderParts:[]
        })
    }
    fetchShoppingCart=()=>{
        ShoppingCartRepository.getActiveShoppingCart()
            .then((response:any)=>{
                this.setState({
                    shoppingCart:response.data
                })
            })
    }
    render() {
        let items=this.renderItems();
        return (
            <div>
                <h1>Shopping Cart</h1>
                <div className="shopping-cart">
                    <div className="column-labels">
                        <label className="product-image">Image</label>
                        <label className="product-details">Product</label>
                        <label className="product-price">Price</label>
                        <label className="product-quantity">Quantity</label>
                        <label className="product-line-price">Total</label>
                    </div>
                    {items}
                    <form onSubmit={this.handleSubmit}>
                        <button className="checkout">Checkout</button>
                    </form>
                </div>
            </div>)


    }
    handleSubmit=(e:any)=>{
        e.preventDefault()
        OrderRepository.order(this.state.orderParts,this.state.orderQuan)
            .then((response:any)=>{
                ShoppingCartRepository.deleteById(this.state.shoppingCart[0].id)
                    .then((response:any)=>{
                        window.location.href="/clients/products"
                    })


            })
    }

    order=(idMebel:number,quantity:number)=> {
        let orderDto = new OrderDto(idMebel, quantity)
        this.state.orderParts.push(idMebel)
        this.state.orderQuan.push(quantity)
    }


    renderItems=()=>{
       return  this.state.shoppingCart.map((f:any)=><ShoppingCartItem item={f}
                                                                          order={this.order}/>)
    }
}

export default ShoppingCart;
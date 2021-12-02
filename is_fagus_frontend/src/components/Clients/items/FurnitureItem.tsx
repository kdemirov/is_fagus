import React from "react";
import "../assets/furnitureItem.scss"
import {AddShoppingCart, Clear, Done, InfoOutlined} from "@mui/icons-material";
import ShoppingCartRepository from "../../../repository/ShoppingCartRepository";

interface FurnitureItemProps {
    item: any,
    user: any

}


interface FurnitureItemState {
    style:string
}

class FurnitureItem extends React.PureComponent<FurnitureItemProps, FurnitureItemState> {

    constructor(props: FurnitureItemProps) {
        super(props);
        this.state = {
            style:""
        }
    }


    render() {
        return (
            <div className="wrapper">
                <div className="container">
                    <div className="top"></div>
                    <div className={`bottom${this.state.style}`}>
                        <div className="left">
                            <div className="details">
                                <h1>Chair</h1>
                                <p>£{this.props.item.cena}</p>
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
                                <h1>Chair</h1>
                                <p>Added to your cart</p>
                            </div>
                            <div className="remove" onClick={this.handleChange}><i className="material-icons"><Clear/></i></div>
                        </div>
                        <div className="inside">
                            <div className="icon"><i className="material-icons"><InfoOutlined style={{position:"absolute"}}/></i></div>
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
                                        <th>Something</th>
                                        <th>Something</th>
                                    </tr>
                                    <tr>
                                        <td>200mm</td>
                                        <td>200mm</td>
                                    </tr>
                                    <tr>
                                        <th>Something</th>
                                        <th>Something</th>
                                    </tr>
                                    <tr>
                                        <td>200mm</td>
                                        <td>200mm</td>
                                    </tr>
                                    <tr>
                                        <th>Something</th>
                                        <th>Something</th>
                                    </tr>
                                    <tr>
                                        <td>200mm</td>
                                        <td>200mm</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )

    }

    handleSubmit = (e: any) => {
        e.preventDefault()
        ShoppingCartRepository.addToShoppingCard(this.props.item.idMebel)
            .then((response)=>{
                this.setState({
                    style:" clicked"
                })
            })
    }
    handleChange=()=>{
        this.setState({
            style:""
        })
    }

}

export default FurnitureItem;
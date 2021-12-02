import React from "react";
import FurnitureService from "../../../repository/FurnitureService";
import FurnitureItem from "../items/FurnitureItem";
import {toast} from "react-toastify";
import "../assets/products.css"

interface ClientProps {
    currentUser: any
}

interface ClientsState {
    furniture: Array<any>

}
toast.configure()
class ClientsProductsPage extends React.Component<ClientProps, ClientsState> {
    constructor(props: ClientProps) {
        super(props);
        this.state = {
            furniture: []
        }
    }

    componentDidMount() {
        this.fetchFurniture();
    }

    fetchFurniture = () => {
        FurnitureService.fetchFurniture()
            .then((response: any) => {
                this.setState({
                    furniture: response.data
                })
            })

    }

    render() {
        let furniture = this.renderFurniture();
        return(
            <div className="productGrid">
            {furniture}
            </div>
        )
    }

    renderFurniture = () => {
        return this.state?.furniture?.map(f => <FurnitureItem
            key={f.idMebel}
            item={f}
            user={this.props.currentUser}/>)
    }

}

export default ClientsProductsPage;
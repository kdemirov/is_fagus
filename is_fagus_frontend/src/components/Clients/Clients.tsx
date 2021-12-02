import React from "react";
import {Route, BrowserRouter as Router} from "react-router-dom";
import ClientsProductsPage from "./Products/ClientsProductsPage";
import ClientsOrdersPage from "./Orders/ClientsOrdersPage";
import ClientsHomePage from "./Homepage/ClientsHomePage";
import AuthService from "../../repository/authService";
import {toast} from "react-toastify";
import ShoppingCart from "./ShoppingCart";


interface ClientsProps {
    getCurrentUser: () => void
    user: any

}

interface ClientsState {
    orders: Array<any>
    order:any|undefined
}

toast.configure();

class Clients extends React.Component<ClientsProps, ClientsState> {

    constructor(props: ClientsProps) {
        super(props);
        this.state = {
            orders: [],
            order:undefined
        }
    }

    componentDidMount() {
        AuthService.checkCurrentUser();
        this.props.getCurrentUser();

    }


    render() {
        return (
            <Router>
                <Route path={"/clients/shopping-cart"} exact={true}>
                    <ShoppingCart />
                </Route>
                <Route path={"/clients/orders"} exact={true}>
                    <ClientsOrdersPage
                        orders={this.state.orders}
                        user={this.props.user}
                    />
                </Route>
                <Route path={"/clients/products"} exact={true}>
                    <ClientsProductsPage
                        currentUser={this.props.user}
                        />
                </Route>
                <Route path={"/clients"} exact={true}>
                    <ClientsHomePage currentUser={this.props.user}/>
                </Route>
            </Router>

        )
    }


}

export default Clients;
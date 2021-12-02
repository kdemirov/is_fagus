import React from "react";
import AuthService from "../../repository/authService";
import {BrowserRouter as Router,Route} from "react-router-dom";
import WarehousemanHomepage from "./Homepage/WarehousemanHomepage";
import {toast} from "react-toastify";

interface WarehousemanProps{
    currentUser: any
    getCurrentUser:()=>void
}
interface WarehousemanState{

}
toast.configure();
class Warehouseman extends React.Component<WarehousemanProps, WarehousemanState>{

    constructor(props:WarehousemanProps) {
        super(props);

    }

    componentDidMount() {
        AuthService.checkCurrentUser();
        this.props.getCurrentUser()
    }

    render() {
        return (
            <Router>
                <Route path={"/warehouseman"}>
                    <WarehousemanHomepage/>
                </Route>
            </Router>
        )
    }
}
export default Warehouseman;
import React from "react";
import {BrowserRouter as Router,Route} from "react-router-dom";
import AuthService from "../../repository/authService";
import ManagersHomepage from "./Homepage/ManagersHomepage";
import ManagerWarrantsPage from "./Warrants/ManagerWarrantsPage";
import {toast} from "react-toastify";
interface ManagersProps{
    currentUser:any
    getCurrentUser:()=>void
}
interface ManagersState{

}
toast.configure();
class Managers extends React.Component<ManagersProps,ManagersState>{
    constructor(props:ManagersProps) {
        super(props);
    }
    componentDidMount() {
        AuthService.checkCurrentUser()
        this.props.getCurrentUser()
    }

    render() {
        return (
            <Router>

                <Route path={"/managers"} exact={true}>
                    <ManagersHomepage/>
                </Route>
                <Route path={"/managers/warrants"} exact={true}>
                    <ManagerWarrantsPage/>
                </Route>
            </Router>
        )
    }
}
export default Managers;
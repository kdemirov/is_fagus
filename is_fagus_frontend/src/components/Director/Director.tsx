import React from "react"
import AuthService from "../../repository/authService";
import {BrowserRouter as Router,Route} from "react-router-dom";
import DirectorHomepage from "./Homepage/DirectorHomepage";
import {toast} from "react-toastify";

interface DirectorState{

}
interface DirectorProps{
    currentUser:any
    getCurrentUser:()=>void
}
toast.configure();
class Director extends React.Component<DirectorProps, DirectorState>{

    constructor(props:DirectorProps) {
        super(props);
    }

    componentDidMount() {
        AuthService.checkCurrentUser()
        this.props.getCurrentUser()
    }

    render() {
        return (
            <Router>
                <Route path={"/director"} exact={true}>
                    <DirectorHomepage/>
                </Route>
            </Router>
        )
    }
}
export default Director;
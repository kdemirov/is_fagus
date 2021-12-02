import React from "react";
import AuthService from "../../repository/authService";
import {BrowserRouter as Router, Route} from "react-router-dom";

import ChiefsHomepage from "./Homepage/ChiefsHomepage";


import {toast} from "react-toastify";

interface ChiefsProps {
    currentUser: any
    getCurrentUser: () => void

}

interface ChiefsState {

}
toast.configure();
class Chiefs extends React.Component<ChiefsProps, ChiefsState> {
    constructor(props: ChiefsProps) {
        super(props);
        this.state = {
            warrant: undefined

        }
    }

    componentDidMount() {
        AuthService.checkCurrentUser();
        this.props.getCurrentUser();
    }

    render() {
        return (
            <Router>
                <Route path={"/chiefs"}>
                    <ChiefsHomepage/>
                </Route>
            </Router>
        )
    }



}

export default Chiefs
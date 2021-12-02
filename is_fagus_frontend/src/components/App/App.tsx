import React from 'react';
import './App.css';
import {toast} from "react-toastify";
import { Route, BrowserRouter as Router, Switch} from "react-router-dom";
import Header from "../Header/Header";
import Login from "../Login/Login";
import LocalStorageRepository from "../../repository/LocalStorageRepository";
import AuthService from "../../repository/authService";
import Register from "../Register/Register";
import {Role} from "../../shared/shared";
import Clients from "../Clients/Clients";
import Managers from "../Managers/Managers";
import Chiefs from "../Chiefs/Chiefs";
import Warehouseman from "../Warehouseman/Warehouseman";
import Director from "../Director/Director";
import "../Header/assets/header.scss"
toast.configure();

interface AppState {
    currentUser: any | undefined
    warrant:any | undefined
}

class App extends React.Component<any, AppState> {

    constructor(props: any) {
        super(props);
        this.state = {
            currentUser: undefined,
            warrant: undefined
        }

    }

    render() {
        return (
            <main>
                <Router>
                    <Header currentUser={this.state.currentUser} currentUserLoggedOut={this.currentUserLoggedOut}/>
                    <Switch>
                        <Route path={"/login"}>
                            <Login getCurrentUser={this.getCurrentUser} handleLoginPage={this.handleLoginPage} currentUser={this.state.currentUser} />
                        </Route>
                        <Route path={"/register"}>
                            <Register/>
                        </Route>
                        <Route path={"/clients"} >
                            <Clients  getCurrentUser={this.getCurrentUser}
                                      user={this.state.currentUser}/>
                        </Route>
                        <Route path={"/managers"} >
                            <Managers currentUser={this.state.currentUser}
                                      getCurrentUser={this.getCurrentUser}/>
                        </Route>
                        <Route path={"/chiefs"} >
                            <Chiefs currentUser={this.state.currentUser}
                                    getCurrentUser={this.getCurrentUser}

                            />

                        </Route>
                        <Route path={"/warehouseman"} exact={true}>
                            <Warehouseman currentUser={this.state.currentUser} getCurrentUser={this.getCurrentUser}/>
                        </Route>
                        <Route path={"/director"} exact={true}>
                            <Director currentUser={this.state.currentUser}
                                      getCurrentUser={this.getCurrentUser}/>
                        </Route>
                    </Switch>
                </Router>
            </main>
        )
    }


    componentDidMount() {
        this.getCurrentUser();
        if(this.state.currentUser) {
            this.handleLoginPage();
        }
    }

    getCurrentUser = () => {
        if (LocalStorageRepository.getUser()!==null) {
            AuthService.getCurrentUser()
                .then((data: any) => {
                    this.setState({
                        currentUser: data.data
                    })
                })
        }
    }
    currentUserLoggedOut = () => {
        this.setState({
            currentUser: undefined
        })
    }
    handleLoginPage = () => {
        if(this.state.currentUser.role === Role.ROLE_CLIENT) {
            window.location.href="/clients"
        }else if(this.state.currentUser.role === Role.ROLE_MANAGER){
            window.location.href="/managers"
        }else if(this.state.currentUser.role===Role.ROLE_CHIEF){
            window.location.href="/chiefs"
        }
    }

}

export default App;

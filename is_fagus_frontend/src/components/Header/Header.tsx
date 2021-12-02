import React from "react";
import LocalStorageRepository from "../../repository/LocalStorageRepository";
import {Role} from "../../shared/shared";
import {Link} from "react-router-dom";
import {Article, BookmarkAdded, Create, Home, Login, Logout, ShoppingCart} from "@mui/icons-material";
import {Tooltip} from "@mui/material";


interface HeaderProps{
    currentUser: any | undefined,
    currentUserLoggedOut: () => void
}
interface HeaderState{

}
class Header extends React.PureComponent<HeaderProps,HeaderState>{

    constructor(props:HeaderProps) {
        super(props);
    }

    render() {
        let shouldShow = this.props.currentUser !== undefined
        return(

            <header>
                <div className="curve">
                    <h1>IsFagus</h1>
                    <h2>Joy for your home</h2>
                </div>
                <nav className="more">

                        {shouldShow && this.getLoggedUser()}

                </nav>
            </header>

        )
    }

    getChiefHeader=() =>{
        return (
                <div>
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link active" href="/chiefs">
                            <Tooltip title={"Homepage"}>
                            <Home/>
                            </Tooltip>
                        </a>
                    </li>
                </ul>
                {this.getRightSide()}
                </div>
        )

    }
    getClientHeader=() =>{
        return (
            <div>
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-fill" href="/clients">
                        <Tooltip title={"Homepage"}>
                            <Home/>
                        </Tooltip>
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-fill " href="/clients/products">
                            <Tooltip title={"Products"}>
                            <Article/>
                            </Tooltip>
                        </a>
                    </li>
                    <li className={"nav-item"}>
                        <a className={"nav-fill"} href="/clients/shopping-cart">
                          <Tooltip title={"Shopping Cart"}>
                            <ShoppingCart/>
                          </Tooltip>
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-fill " href="/clients/orders"><BookmarkAdded/></a>
                    </li>
                </ul>
                {this.getRightSide()}
            </div>
        )

    }
    getRightSide=()=>{
        return (

            <ul className={"nav navbar-nav navbar-right"}>
                <li className={"nav-item"}>
                    <p style={{color: "#FFF"}}>{this.props.currentUser.username}</p>
                </li>
                <li className={"nav-item"}>
                    <form className="form-inline mt-2 mt-md-0 ml-3">
                        <Link className="btn btn-outline-info my-2 my-md-0" to={"/logout"}
                              onClick={this.handleLogOut}><Logout/></Link>
                    </form>
                </li>


            </ul>
        )
    }
    getDirectorHeader=()=>{
        return (
            <div >
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link active" href="/director">
                           <Tooltip title={"Homepage"}>
                               <Home/>
                           </Tooltip>
                        </a>
                    </li>

                </ul>

                {this.getRightSide()}
            </div>
        )
    }
    getManagerHeader=()=>{
        return (
            <div >
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link active" href="/managers">
                        <Tooltip title={"Homepage"}>
                            <Home/>
                        </Tooltip>
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link active" href="/managers/warrants">
                            <Tooltip title={"Warrants"}>
                            <Article/>
                            </Tooltip>
                        </a>
                    </li>
                </ul>

                {this.getRightSide()}
            </div>
        )
    }
    getWarehousemanHeader=()=>{
        return (
            <div >
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link active" href="/warehouseman">
                        <Tooltip title={"Homepage"}>
                            <Home/>
                        </Tooltip>
                        </a>
                    </li>
                </ul>

                {this.getRightSide()}
            </div>
        )
    }
    getLoggedUser = () =>{
        switch (this.props.currentUser.role){
            case Role.ROLE_CHIEF:
                return this.getChiefHeader();
            case Role.ROLE_CLIENT:
                return this.getClientHeader();
            case Role.ROLE_DIRECTOR:
                return this.getDirectorHeader();
            case Role.ROLE_MANAGER:
                return this.getManagerHeader();
            case Role.ROLE_WAREHOUSEMAN:
                return this.getWarehousemanHeader();
        }
    }
    handleLogOut=()=>{
        LocalStorageRepository.removeUser();
        this.props.currentUserLoggedOut()
        window.location.href = "/login"
    }
}

export default Header;
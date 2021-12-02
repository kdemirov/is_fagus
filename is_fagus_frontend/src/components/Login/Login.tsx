import React from "react";
import AuthService from "../../repository/authService";
import {Role} from "../../shared/shared";
import "../Login/assets/login.scss"


interface LoginProps{
    currentUser:any | undefined;
    handleLoginPage:()=>void
    getCurrentUser:()=>void
}

interface LoginState{
    username: string,
    password: string,


}

class Login extends React.PureComponent<LoginProps,LoginState>{
    constructor(props:LoginProps) {
        super(props);
        this.state={
            username:"",
            password:"",


        }
    }

    render(){
        return (
            <div className={"loginBody"}>
            <form className="login-form" onSubmit={this.handleSubmit}>
                <h1>Login</h1>
                <div className="form-input-material">
                    <input type="text" name="username" id="username" placeholder=" "
                           className="form-control-material" required onChange={this.handleChange}/>
                    <label htmlFor="username">Username</label>
                </div>
                <div className="form-input-material">
                    <input type="password" name="password" id="password" placeholder=" "
                           className="form-control-material" required
                    onChange={this.handleChange}/>
                    <label htmlFor="password">Password</label>
                </div>
                <button type="submit" className="btn btn-primary btn-ghost">Login</button>
                <a className={"btn btn-primary btn-ghost"} href={"/register"}>Register</a>
            </form>

            </div>

        )
    }
    componentDidMount() {

    }

    handleChange = (event: any) => {
        this.setState({
            [event.target.name]: event.target.value
        } as Pick<LoginState, keyof LoginState>)
    }
    handleSubmit = (event: any) => {
        event.preventDefault()
        AuthService.login(this.state.username, this.state.password)
            .then((response:any)=>{
                this.props.getCurrentUser()
                AuthService.getCurrentUser()
                    .then((response)=>{
                        if(response.data.role===Role.ROLE_CLIENT){
                            window.location.href="/clients"
                        }else if(response.data.role === Role.ROLE_MANAGER){
                            window.location.href="/managers"
                        }else if(response.data.role === Role.ROLE_CHIEF){
                            window.location.href="/chiefs"
                        }else if(response.data.role === Role.ROLE_WAREHOUSEMAN){
                            window.location.href="/warehouseman"
                        }else if(response.data.role === Role.ROLE_DIRECTOR){
                            window.location.href="/director"
                        }
                    })
            })
    }



}
export default Login;
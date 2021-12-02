import React from "react";
import LocalStorageRepository from "../../repository/LocalStorageRepository";
import AuthService from "../../repository/authService";



interface RegisterState {
    name: string,
    surname: string,
    username: string,
    password: string,
    email: string,
}

class Register extends React.PureComponent<any, RegisterState> {

    constructor(props: any) {
        super(props);
        this.state = {
            name: "",
            surname: "",
            username: "",
            password: "",
            email:""
        }

    }


    render() {
        return (

            <div className={"loginBody"}>
                <form className="login-form" onSubmit={this.handleSubmit}>
                    <h1>Register</h1>

                    <div className="form-input-material">
                        <input type="text" name="name" id="name" placeholder=" "
                               className="form-control-material" required onChange={this.handleChange}/>
                        <label htmlFor="Name">Name</label>
                    </div>
                    <div className="form-input-material">
                        <input type="text" name="surname" id="surname" placeholder=" "
                               className="form-control-material" required onChange={this.handleChange}/>
                        <label htmlFor="surname">Surname</label>
                    </div>
                    <div className="form-input-material">
                        <input type="text" name="username" id="username" placeholder=" "
                               className="form-control-material" required onChange={this.handleChange}/>
                        <label htmlFor="username">Username</label>
                    </div>
                    <div className="form-input-material">
                        <input type="text" name="email" id="email" placeholder=" "
                               className="form-control-material" required onChange={this.handleChange}/>
                        <label htmlFor="email">Email</label>
                    </div>
                    <div className="form-input-material">
                        <input type="password" name="password" id="password" placeholder=" "
                               className="form-control-material" required
                               onChange={this.handleChange}/>
                        <label htmlFor="password">Password</label>
                    </div>
                    <button type="submit" className="btn btn-primary btn-ghost">Register</button>

                </form>

            </div>
        )
    }

    getTemplateProps = () => {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <input
                        type="text"
                        name="name"
                        required
                        onChange={this.handleChange}
                        id="name"
                        className="form-control"
                        placeholder="Name:"
                    />
                </div>
                <div className="form-group">
                    <input
                        type="text"
                        name="surname"
                        required
                        onChange={this.handleChange}
                        id="surname"
                        className="form-control"
                        placeholder="Surname:"
                    />
                </div>
                <div className="form-group">
                    <input
                        type="text"
                        name="username"
                        id="username"
                        required
                        onChange={this.handleChange}
                        className="form-control"
                        placeholder="Username:"
                    />
                </div>
                <div className="form-group">
                    <input
                        type="text"
                        name="email"
                        required
                        onChange={this.handleChange}
                        id="email"
                        className="form-control"
                        placeholder="Email:john.doe@example.com"
                    />
                </div>
                <div className="form-group">
                    <input
                        type="password"
                        name="password"
                        required
                        id="password"
                        onChange={this.handleChange}
                        className="form-control"
                        placeholder="Password:"
                    />
                </div>

                <button type="submit" className="btn btn-primary">Register</button>
            </form>
        )
    }
    handleChange = (event: any) => {
        this.setState({
            [event.target.name]: event.target.value
        } as Pick<RegisterState, keyof RegisterState>)
    }

    componentDidMount() {
        if (LocalStorageRepository.getUser()) {
            this.redirect("/client-home")
        }
    }

    redirect = (path: string) => {
        window.location.href = path
    }
    handleSubmit = (event: any) => {
        event.preventDefault()
        AuthService.register(this.state.name, this.state.surname, this.state.username, this.state.password,this.state.email)
            .then(() => {
                this.redirect("/login");
            })


    }
}

export default Register;

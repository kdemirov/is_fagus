import instance from "../custom-axios/axios";
import LocalStorageRepository from "./LocalStorageRepository";
import NotificationService from "./NotificationService";

const AuthService = {

    login: (username: string, password: string) => {
        return instance.post("/login", {
            "username": username,
            "password": password
        }).then((response: any) => {
            LocalStorageRepository.saveUser(response.data)
        }).catch((err: any) => {
            NotificationService.error(err.message)
        })
    },
    getCurrentUser: () => {
        return instance.get("/login")

    },
    register: (username: string, password: string, name: string, surname: string, email: string) => {
        return instance.post("/register/client", {
            "username": username,
            "password": password,
            "name": name,
            "surname": surname,
            "email": email
        }).then(() => {
            NotificationService.success("Uspesna registracija")
        }).catch((err: any) => {
            console.log(err.message);
            NotificationService.error(err.message);
        })
    },
    checkCurrentUser: () => {
        if (LocalStorageRepository.getUser() === null) {
            window.location.href = "/login";
        }
    }

}
export default AuthService;
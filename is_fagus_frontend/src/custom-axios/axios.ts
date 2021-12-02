import axios from "axios";
import LocalStorageRepository from "../repository/LocalStorageRepository";
import NotificationService from "../repository/NotificationService";

const instance = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Access-Control-Allow-Origin': '*'
    }
});
instance.interceptors.request.use(
    config => {
        const token = LocalStorageRepository.getUser();
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        } else {
            console.log("Error setting header")
        }
        return config;

    }
)
instance.interceptors.response.use(
    (response: any) => {
        if (response.headers.Authorization) {
            LocalStorageRepository.saveUser(response.headers.Authorization)
        }
        return response
    }, (error: any) => {

        // LocalStorageRepository.removeUser();
        // window.location.href = "/login";
        return Promise.reject(error)
    }
)
export default instance;
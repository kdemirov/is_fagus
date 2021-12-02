import instance from "../custom-axios/axios";

class ClientsService {

    getProducts = () => {
        instance.get("/furniture")
    }
}

export default ClientsService;
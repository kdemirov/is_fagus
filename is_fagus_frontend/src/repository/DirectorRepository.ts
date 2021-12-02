import instance from "../custom-axios/axios";

class DirectorRepository {
    fetchBestClient = () => {
        return instance.get("/director/clients")
    }
    fetchBestEmployees = () => {
        return instance.get("/director/employees")
    }
}

export default new DirectorRepository();
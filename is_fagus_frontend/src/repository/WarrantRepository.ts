import instance from "../custom-axios/axios";
import NotificationService from "./NotificationService";

class WarrantRepository{
    createWarrant=(orderId:number)=>{
        return instance.post("/warrant",{
            orderId:orderId
        }).then(()=>{
            NotificationService.success("Uspesno kreiran nalog")
        }).catch(()=>{
            NotificationService.error("Nastana greska")
        })
    }
    fetchAll=()=>{
        return instance.get("/warrant")
    }
    endWarrant=(warrantId:number)=>{
        return instance.put(`/warrant/${warrantId}`)
            .then(()=>{
                NotificationService.success("Uspesno izvrsena komanda")
            }).catch((err)=>{
                NotificationService.error("Nastana greska")
            })
    }
    getWarrant=(warrantId:number)=>{
        return instance.get(`/warrant/${warrantId}`)
    }
    fetchChiefsOrders=(orderId:number)=>{
        return instance.get(`/warrant/orders/${orderId}`)
    }
    fetchChiefsParts=()=>{
        return instance.get(`/warrant/parts`)
    }
    fetchChiefsMachine=()=>{
        return instance.get("/warrant/machines")
    }
    fetchChiefsEmployees=()=>{
        return instance.get(`/warrant/employees`)
    }
    fetchTrackingViewById=(id:number)=>{
        return instance.get(`/warrant/tracking/${id}`)
    }
}
export default new WarrantRepository();
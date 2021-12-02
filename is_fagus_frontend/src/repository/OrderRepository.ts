import instance from "../custom-axios/axios";
import NotificationService from "./NotificationService";
import {OrderDto} from "../shared/shared";

class OrderRepository {

    fetchAllByClientId = (id: number) => {
        return instance.get("/order")
            .catch((err => {
                NotificationService.error(err.message);
            }))
    }

    orderShipped = (orderId: number) => {
        return instance.put(`/order/${orderId}`)
            .then(() => {
                NotificationService.success("Uspesna komanda")
            }).catch((err) => {
                NotificationService.error("Nastana greska")
            })
    }
    orderExtraPart = (orderId: number, partId: number, quantity: number) => {
        return instance.post("/order/parts", {
            orderId: orderId,
            partId: partId,
            quantity: quantity
        }).then(() => {
            NotificationService.success("Uspesno dodadeni dopolnilte delovi")
        }).catch((err) => {
            NotificationService.error("Nastana greska")
        })
    }
    getExtraParts = (id: number) => {
        return instance.get(`/order/parts/${id}`)
    }
    fetchOrderPercent = () => {
        return instance.get("/order/percent")
    }
    fetchMyOrderPercent = () => {
        return instance.get("/order/percent/my")
    }
    fetchOrdersForManager = () => {
        return instance.get("/order/all")
    }
    order=(array:Array<number>,quantity:Array<number>)=>{
        return instance.post("/order/array",{
            idS:JSON.stringify(Buffer.from(array)),
            quantity:JSON.stringify(Buffer.from(quantity))
        }).then(()=>{
            NotificationService.success("Order created successfully")
        }).catch((err)=>{
            NotificationService.error("There has been an error creating an order")
        })
    }
    fetchOrderPercentDoneById=(id:number)=>{
        return instance.get(`/order/percent/${id}`)
    }
}

export default new OrderRepository();
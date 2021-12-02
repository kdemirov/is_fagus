import instance from "../custom-axios/axios";
import NotificationService from "./NotificationService";

class RecordRepository {
    createRecord=(orderId:number,furnitureId:number,partId:number,machineId:number,employeeId:number,
                  quantity:number)=>{
        return instance.post("/record",{
            orderId:orderId,
            furnitureId:furnitureId,
            partId:partId,
            machineId:machineId,
            employeeId:employeeId,
            quantity:quantity

        }).then(()=>{
            NotificationService.success("Evidencija uspesno vnesena")
        }).catch((err)=>{
            NotificationService.error("Nastana problem pri vnesuvanje na evidencija")
        })

    }
}
export default new RecordRepository();
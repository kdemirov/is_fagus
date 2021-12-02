import instance from "../custom-axios/axios";
import NotificationService from "./NotificationService";

class MaterialRepository{
    fetchAll=()=>{
       return instance.get("/material")
    }
    editMaterial=(id:number,quantity:number)=>{
        return instance.put(`/material/${id}`,{
            quantity:quantity
        }).then(()=>{
            NotificationService.success("Material updated successfully")
        })
    }
    addMaterial=(name:string,size:number,quantity:number)=>{
        return instance.post("/material",{
            name:name,
            size:size,
            quantity:quantity
        }).then(()=>{
            NotificationService.success("Material Added successfully")
        })
    }

}
export default new MaterialRepository();
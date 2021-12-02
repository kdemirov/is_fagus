import instance from "../custom-axios/axios";

class ShoppingCartRepository{
    addToShoppingCard=(furnitureId:number)=>{
        return instance.post("/shopping-cart",{
            furnitureId:furnitureId
        })
    }

    getActiveShoppingCart=()=>{
        return instance.get("/shopping-cart")
    }

    deleteById=(id:number)=>{
        return instance.delete(`/shopping-cart/${id}`)
    }
}
export default new ShoppingCartRepository();
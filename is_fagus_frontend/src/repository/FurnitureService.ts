import instance from "../custom-axios/axios";

const FurnitureService = {
    fetchFurniture: () => {
        return instance.get("/furniture")
    },
    fetchFurnitureParts: (id: number) => {
        return instance.get(`/furniture/parts/${id}`)
    }
}
export default FurnitureService;
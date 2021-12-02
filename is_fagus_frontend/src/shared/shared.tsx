export  enum Role{
    ROLE_USER="ROLE_USER",
    ROLE_CLIENT="ROLE_CLIENT",
    ROLE_DIRECTOR="ROLE_DIRECTOR",
    ROLE_MANAGER="ROLE_MANAGER",
    ROLE_WAREHOUSEMAN="ROLE_WAREHOUSEMAN",
    ROLE_CHIEF="ROLE_CHIEF"
}
export class OrderDto{
    idMebel:number
    quantity:number
    constructor(idMebel:number,quantity:number) {
        this.idMebel=idMebel
        this.quantity=quantity
    }
}
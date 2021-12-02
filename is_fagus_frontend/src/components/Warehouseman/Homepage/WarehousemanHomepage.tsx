import React from "react";
import MaterialRepository from "../../../repository/MaterialRepository";

interface WarehousemanHomepageProps{

}
interface WarehousemanHomepageState{
    materials: Array<any>
    quantity: number
    name: string
    size: number
}
class WarehousemanHomepage extends React.Component<WarehousemanHomepageProps, WarehousemanHomepageState>{

    constructor(props:WarehousemanHomepageProps) {
        super(props);
        this.state={
            materials:[],
            quantity: 0,
            name:"",
            size:0
        }
    }

    componentDidMount() {
        this.fetchAll()
    }
    render() {
        let materials=this.renderMaterial()
        return (
            <div className="container">
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>Naziv</td>
                        <td>Velicina</td>
                        <td>Kolicina</td>
                        <td>Zacuvaj</td>
                    </tr>
                    </thead>
                    <tbody>
                    {materials}
                    <tr>
                        <td></td>
                        <td>
                            <input type={"text"} name={"name"} onChange={this.handleChange}/>
                        </td>
                        <td>
                            <input type={"number"}  name={"size"} onChange={this.handleChange}/>
                        </td>
                        <td>
                            <input type={"number"}  name={"quantity"} onChange={this.handleChange}/>
                        </td>
                        <td>
                            <button className={"btn btn-primary"} onClick={this.addMaterial}>Zacuvaj</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
    addMaterial=()=>{
        MaterialRepository.addMaterial(this.state.name,this.state.size,this.state.quantity)
            .then(()=>{
                this.fetchAll()
            })
    }
    renderMaterial=()=>{
        return this.state.materials?.map(m=>
            <tr>
                <td>{m.materialId}</td>
                <td>{m.name}</td>
                <td>{m.size}</td>
                <td>
                    <input type={"number"} defaultValue={m.quantity} name={"quantity"} onChange={this.handleChange}/>
                </td>
                <td>
                    <button className={"btn btn-primary"} onClick={()=>this.editMaterial(m.materialId)}>
                        Zacuvaj
                    </button>
                </td>
            </tr>
        )
    }
    editMaterial=(materialId:number)=>{
        MaterialRepository.editMaterial(materialId,this.state.quantity)
            .then(response=>{
                this.fetchAll();
            })
    }
    handleChange=(e:any)=>{
        this.setState({
            [e.target.name]:e.target.value
        }as Pick<WarehousemanHomepageState,keyof WarehousemanHomepageState>)
    }
    fetchAll=()=>{
        MaterialRepository.fetchAll()
            .then(response=>{
                this.setState(
                    {
                        materials:response.data
                    }
                )
            })
    }


}
export default WarehousemanHomepage;
import React from "react";
import WarrantRepository from "../../../repository/WarrantRepository";
import RecordRepository from "../../../repository/RecordRepository";

interface ChiefsRecordsProps {
    warrant: any
    sendActiveIndex:(activeIndex:number)=>void
}

interface ChiefsRecordsState {
    orders: Array<any>
    parts: Array<any>
    machines: Array<any>
    employees: Array<any>
    selectedFurnitureId: number | undefined
    selectedPartId: number | undefined
    selectedMachineId: number | undefined
    selectedEmployeeId: number | undefined
    quantity: number | undefined
    activeIndex:number

}

class ChiefsRecords extends React.Component<ChiefsRecordsProps, ChiefsRecordsState> {


    constructor(props: ChiefsRecordsProps) {
        super(props);
        this.state = {
            orders: [],
            parts: [],
            machines: [],
            employees: [],
            selectedFurnitureId: undefined,
            selectedPartId: undefined,
            selectedMachineId: undefined,
            selectedEmployeeId: undefined,
            quantity: 0,
            activeIndex:1
        }

    }

    componentDidMount() {
        this.fetchOrders()
        this.fetchEmployees()
        this.fetchParts()
        this.fetchMachines()
    }

    render() {
        let orders = this.renderOrders()
        let parts =  this.renderParts()
        let machines =  this.renderMachines()
        let employees = this.renderEmployees()
        let quantity = this.renderQuantity();
        return (
            <>
            {orders}
            {parts}
                {machines}
                {employees}
                {quantity}
        </>
        )
    }

    submit = (e: any) => {
        e.preventDefault()
        RecordRepository.createRecord(this.props.warrant.orderId, this.state.selectedFurnitureId as number,
            this.state.selectedPartId as number, this.state.selectedMachineId as number,
            this.state.selectedEmployeeId as number, this.state.quantity as number)
            .then(response => {
                this.setState({
                    selectedMachineId: undefined,
                    selectedPartId: undefined,
                    selectedFurnitureId: undefined,
                    selectedEmployeeId: undefined,
                    quantity: undefined,
                    activeIndex:1
                })
                this.fetchOrders()
            })
    }
    renderRadioButtonsEmployees=()=>{
       return this.state.employees.map(e=>
       <div className={"four col"}>
           <input type={"radio"} name={"selectedEmployeeId"}
           value={e.employeeId}
                  id={e.employeeId}
           onChange={this.handleChange}/>
           <label htmlFor={e.employeeId}>{e.name} {e.surname}</label>
       </div>
       )
    }
    renderQuantity=()=>{
        let className=this.state.activeIndex===5?"section is-active":"section"
        return <fieldset className={className}>
            <h3>Select quantity</h3>
            <input type="number" name="quantity" id="quantity"
                   min={1} required
            onChange={this.handleChange}/>
            <div className="button" onClick={this.submit}>Next</div>
        </fieldset>

    }
    renderEmployees = () => {
        let className=this.state.activeIndex===4?"section is-active":"section"
        return <fieldset className={className}>
            <h3>Select employees</h3>
            {this.renderRadioButtonsEmployees()}
            <div className="button" onClick={this.next}>Next</div>
        </fieldset>
    }
    renderMachinesRadioButton=()=>{

        return this.state.machines.map(m=>
            <div className={"four col"}>
                <input type={"radio"}
                value={m.machineId}
                name={"selectedMachineId"}
                id={m.machineId}
                onChange={this.handleChange}/>
                <label htmlFor={m.machineId}>
                    {m.machineName}
                </label>

            </div>
        )
    }
    renderMachines = () => {
        let className=this.state.activeIndex===3?"section is-active":"section"
        return <fieldset className={className}>
            <h3>Select Machine</h3>
            {this.renderMachinesRadioButton()}
            <div className={"button"}
            onClick={this.next}>Next</div>
        </fieldset>
    }
    renderPartsRadioButton=()=>{
       return  this.state.parts.map(p=>
       <div className={"four col"}>
           <input type={"radio"}
           name={"selectedPartId"}
           value={p.partId}
           id={p.partId}
           onChange={this.handleChange}/>
           <label htmlFor={p.partId}>
               {p.type}
           </label>

       </div>
       )
    }
    renderParts = () => {
        let className=this.state.activeIndex===2?"section is-active":"section"
        return (
            <fieldset className={className}>
                <h3>Select Part</h3>
                {this.renderPartsRadioButton()}
                <div className={"button"}
                onClick={this.next}>
                    Next
                </div>
            </fieldset>
        )


    }
    renderOrdersRadioButtons=()=>{
     return  this.state.orders.map(o=>
          <div className={"four col"}>
            <input type={"radio"}
            name={"selectedFurnitureId"}
            value={o.furnitureId}
            id={o.furnitureId}
            onChange={this.handleChange}/>
            <label htmlFor={o.furnitureId}>
                {o.name} {o.type}
            </label>

          </div>)
    }
    renderOrders = () => {
        let className=this.state.activeIndex===1?"section is-active":"section"
        return <fieldset className={className}>
            <h3>Chose furniture</h3>
            {this.renderOrdersRadioButtons()}
            <div className="button" onClick={this.next}>Next</div>
        </fieldset>

    }
    next=()=>{
        this.setState({
            activeIndex:this.state.activeIndex+1
        })
        this.props.sendActiveIndex(this.state.activeIndex)
    }
    handleChange = (e: any) => {
        e.preventDefault();
        this.setState({
            [e.target.name]: e.target.value
        }as Pick<ChiefsRecordsState,keyof ChiefsRecordsState>)
    }
    fetchOrders = () => {
        console.log(this.props.warrant)
        WarrantRepository.fetchChiefsOrders(this.props.warrant.orderId)
            .then(response => {
                this.setState({
                    orders: response.data
                })
            })

    }
    fetchParts = () => {
        WarrantRepository.fetchChiefsParts()
            .then((response: any) => {
                this.setState({
                    parts: response.data
                })
            })
    }
    fetchMachines = () => {
        WarrantRepository.fetchChiefsMachine()
            .then(response => {
                this.setState({
                    machines: response.data
                })
            })
    }
    fetchEmployees = () => {
        WarrantRepository.fetchChiefsEmployees()
            .then(response => {
                this.setState({
                    employees: response.data
                })
            })
    }

}

export default ChiefsRecords;
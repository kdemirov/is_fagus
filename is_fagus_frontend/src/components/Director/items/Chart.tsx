import React from "react";
import { Bar } from "react-chartjs-2";
import { MDBContainer } from "mdbreact";
import "../chart.css"
interface ChartPageProps{
    items:Array<any>
    label:string
    title:string
    percentage?:number
    clients:boolean
}
interface ChartPageState{
    dataBar:any
    barChartOptions:any
}
class ChartsPage extends React.Component<ChartPageProps,ChartPageState> {
    constructor(props:ChartPageProps) {
        super(props);
        this.state = {
            dataBar: {
                labels:this.props.clients?this.props.items.map(i=>i.id.valueOf().name+i.id.valueOf().surname) :
                    this.props.items.map(i=>i.bestEmployeePerOrderId.valueOf().name +
                        i.bestEmployeePerOrderId.valueOf().surname),
                datasets: [
                    {
                        label: this.props.label,
                        data:this.props.clients?this.props.items.map(i=>i.id.valueOf().value):
                            this.props.items.map(i=>i.bestEmployeePerOrderId.valueOf().value),
                        backgroundColor:[ "rgba(255, 134,159,0.4)",
                            "rgba(98,  182, 239,0.4)",
                            "rgba(255, 218, 128,0.4)",
                            "rgba(113, 205, 205,0.4)",
                            "rgba(170, 128, 252,0.4)",
                            "rgba(255, 177, 101,0.4)",
                        ],
                        borderWidth: 2,
                        borderColor:[   "rgba(255, 134, 159, 1)",
                            "rgba(98,  182, 239, 1)",
                            "rgba(255, 218, 128, 1)",
                            "rgba(113, 205, 205, 1)",
                            "rgba(170, 128, 252, 1)",
                            "rgba(255, 177, 101, 1)"],
                        barPercentage:1


                    }
                ]
            },
            barChartOptions: {
                responsive: true,
                maintainAspectRatio: true,
                aspectRatio:2,
                onResize:null,
                resizeDelay:0,
                scales: {
                    xAxes: [
                        {
                            gridLines: {
                                display: true,
                                color: "rgba(0, 0, 0, 0.1)"
                            }
                        }
                    ],
                    yAxes: [
                        {
                            gridLines: {
                                display: true,
                                color: "rgba(0, 0, 0, 0.1)"
                            },
                            ticks: {
                                beginAtZero: false
                            }
                        }
                    ]
                }
            }

        }

    }
    render() {
        return (
            <div>
                <h3 className="mt-5">{this.props.title}</h3>
                <Bar  data={this.state.dataBar} options={this.state.barChartOptions} />
            </div>
        );
    }
}

export default ChartsPage;

import React from "react";
import ChartsPage from "../items/Chart";
import DirectorRepository from "../../../repository/DirectorRepository";

interface DirectorHomepageProps{

}
interface DirectorHomepageState{
    bestClients:Array<any>
    bestWorkers:Array<any>
}

class DirectorHomepage extends React.Component<DirectorHomepageProps, DirectorHomepageState>{

    constructor(props:DirectorHomepageProps) {
        super(props);
        this.state={
            bestClients:[],
            bestWorkers:[]
        }
    }

    componentDidMount() {
        this.fetchBestClients();
        this.fetchBestWorkers();
    }
    render() {
        return (
                <div className="chartSize">
                        <ChartsPage items={this.state.bestClients}
                        title={"Klienti sto nosat najmnogu profit"}
                        label={"Vkupno potroseno pari"}
                        clients={true}/>


                        <ChartsPage items={this.state.bestWorkers}
                        title={"Najdobri rabotnici vo proizvodstvo po naracka"}
                        label={"Vkupno izraboteni delovi"}
                        clients={false}
                        />

                </div>
        )
    }

    fetchBestClients=()=>{
        DirectorRepository.fetchBestClient()
            .then((response:any)=>{
                console.log(response.data)
                this.setState({
                    bestClients:response.data
                })
            })
    }
    fetchBestWorkers=()=>{
        DirectorRepository.fetchBestEmployees()
            .then((response:any)=>{
                console.log(response.data)
                this.setState({
                    bestWorkers:response.data
                })
            })
    }

}
export default DirectorHomepage
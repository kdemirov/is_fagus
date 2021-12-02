import React from "react";
import WarrantRepository from "../../../repository/WarrantRepository";
import WarrantItem from "../items/WarrantItem";

interface ManagerWarrantsPageProps {

}

interface ManagerWarrantsPageState {
    warrants: Array<any>
}

class ManagerWarrantsPage extends React.Component<ManagerWarrantsPageProps, ManagerWarrantsPageState> {

    constructor(props: ManagerWarrantsPageProps) {
        super(props);
        this.state = {
            warrants: []
        }
    }

    componentDidMount() {
        this.fetchAll()
    }

    render() {
        let warrants = this.renderCards()
        return (
            <div className="productGrid">
                {warrants}
            </div>

        )
    }

    renderCards = () => {
        return this.state.warrants.map(w =>
            <WarrantItem key={w.warrantId} item={w} finishWarrant={this.endWarrant}/>)
    }

    fetchAll = () => {
        WarrantRepository.fetchAll()
            .then(response => {
                this.setState({
                    warrants: response.data
                })
            })
    }
    endWarrant = (warrantId: number) => {
        WarrantRepository.endWarrant(warrantId)
            .then(response => {
                this.fetchAll();
            })
    }
}

export default ManagerWarrantsPage
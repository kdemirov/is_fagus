import React from "react";
import WarrantRepository from "../../../repository/WarrantRepository";
import WarrantItem from "../items/WarrantItem";


interface ChiefsHomepageProps {

}

interface ChiefsHomepageState {
    warrants: Array<any>
}

class ChiefsHomepage extends React.Component<ChiefsHomepageProps, ChiefsHomepageState> {

    constructor(props: ChiefsHomepageProps) {
        super(props);
        this.state = {
            warrants: [],
        }
    }

    componentDidMount() {
        this.fetchWarrants()
    }

    render() {
        let warrants = this.renderCards()
        return (
            <div className="chiefBody">
            <div className="productGrid">
                {warrants}
            </div>
            </div>

        )
    }

    renderCards = () => {
        return this.state.warrants?.map(w =>
            <WarrantItem item={w}/>)
    }

    fetchWarrants = () => {
        WarrantRepository.fetchAll()
            .then(response => {
                this.setState({
                    warrants: response.data
                })
            })
    }
}

export default ChiefsHomepage
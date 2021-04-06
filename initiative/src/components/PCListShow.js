import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class PCListShow extends Component {

    constructor(props) {
        super(props);
        this.state = {pcs: [], isLoading: true, id: 1};
    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('api/pcs/')
            .then(response => response.json())
            .then(data => this.setState({pcs: Array.from(data), isLoading: false}))
    }

    render() {
        const {pcs, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>
        }

        const pcList = pcs.map(pc => {
            return <tr key={pc.id} id="pc-row">
                <td style={{whiteSpace: 'nowrap'}}>{pc.name}</td>
                <td>{pc.race}</td>
                <td>{pc.className}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Player Characters</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="10%">Name</th>
                                <th width="10%">Race</th>
                                <th width="10%">Class</th>
                            </tr>
                        </thead>
                        <tbody>
                            {pcList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default PCListShow
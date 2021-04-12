// For Transparency:
// Retrofitted code from https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot#call-your-spring-boot-api-and-display-the-results
// This seems to be a very general way of structuring a React Component

import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class PCList extends Component {

    constructor(props) {
        super(props);
        this.state = {pcs: [], isLoading: true, id: 1};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('api/pcs/')
            .then(response => response.json())
            .then(data => this.setState({pcs: Array.from(data), isLoading: false}))
    }

    async remove(id) {
        await fetch(`/api/pc/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedpcs = [...this.state.pcs].filter(i => i.id !== id);
            this.setState({pcs: updatedpcs});
        });
    }

    render() {
        const {pcs, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>
        }

        const pcList = pcs.map(pc => {
            return <tr key={pc.id}>
                <td style={{whiteSpace: 'nowrap'}}>{pc.name}</td>
                <td>{pc.race}</td>
                <td>{pc.className}</td>
                <td>{pc.strength}</td>
                <td>{pc.constitution}</td>
                <td>{pc.dexterity}</td>
                <td>{pc.intelligence}</td>
                <td>{pc.wisdom}</td>
                <td>{pc.charisma}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/pc/" + pc.id}>Edit</Button>
                        {/* <Button size="sm" color="danger" onClick={() => this.remove(pc.id)}>Delete</Button> */}
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to={"pc/add"}>Add New Character</Button>
                    </div>
                    <h3>Player Characters</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="10%">Name</th>
                                <th width="10%">Race</th>
                                <th width="10%">Class</th>
                                <th width="5%">STR</th>
                                <th width="5%">CON</th>
                                <th width="5%">DEX</th>
                                <th width="5%">INT</th>
                                <th width="5%">WIS</th>
                                <th width="5%">CHA</th>
                                <th width="10%">Actions</th>
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

export default PCList;
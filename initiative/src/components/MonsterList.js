// For Transparency:
// Retrofitted code from https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot#call-your-spring-boot-api-and-display-the-results
// This seems to be a very general way of structuring a React Component

import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class MonsterList extends Component {

    constructor(props) {
        super(props);
        this.state = {monsters: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('api/monsters/')
            .then(response => response.json())
            .then(data => this.setState({monsters: Array.from(data), isLoading: false}))
    }

    async remove(id) {
        await fetch(`api/monster/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedMonsters = [...this.state.monsters].filter(i => i.id !== id);
            this.setState({monsters: updatedMonsters});
        });
    }

    render() {
        const {monsters, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>
        }

        const monsterList = monsters.map(monster => {
            return <tr key={monster.id} id="monster-row">
                <td style={{whiteSpace: 'nowrap'}}>{monster.name}</td>
                <td>{monster.hitPoints}</td>
                <td>{monster.strength}</td>
                <td>{monster.constitution}</td>
                <td>{monster.dexterity}</td>
                <td>{monster.intelligence}</td>
                <td>{monster.wisdom}</td>
                <td>{monster.charisma}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/monster/" + monster.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(monster.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="monster/add">Add New Monster</Button>
                    </div>
                    <h3>Monsters</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="10%">Name</th>
                                <th width="10%">Hit Points</th>
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
                            {monsterList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default MonsterList;
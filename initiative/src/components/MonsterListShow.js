import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class MonsterListShow extends Component {

    constructor(props) {
        super(props);
        this.state = {monsters: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('api/monsters/')
            .then(response => response.json())
            .then(data => this.setState({monsters: Array.from(data), isLoading: false}))
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
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Monsters</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="10%">Name</th>
                                <th width="10%">Hit Points</th>
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
export default MonsterListShow
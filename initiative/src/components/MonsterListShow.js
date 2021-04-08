import React, { Component } from 'react';
import { Container, Table } from 'reactstrap';

class MonsterListShow extends Component {

    constructor(props) {
        super(props);
        this.state = {monsters: [], isLoading: true};
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('api/monsters/')
            .then(response => response.json())
            .then(data => this.setState({monsters: Array.from(data), isLoading: false}))
    }

    handleChange(e) {
        this.props.onCombatantSelect(e);
    }

    render() {
        const {monsters, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>
        }

        const monsterList = monsters.map(monster => {
            return <tr key={monster.id} onClick={() => this.handleChange(monster)} id="monster-row">
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
                                <th width="10%">HP</th>
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
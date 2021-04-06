import React, { Component } from 'react';
import { Container, Row, Col, Table} from 'reactstrap';
import PCListShow from './PCListShow';
import MonsterListShow from './MonsterListShow';

class Tracker extends Component{

    constructor(props) {
        super(props);
        this.state = {
            combatants: [],
        }
        this.onCombatantChange = this.onCombatantChange.bind(this);
    }

    onCombatantChange(combatant) {
        this.state.combatants.push(combatant);
        console.log(this.state.combatants)
        this.forceUpdateHandler();
    }

    forceUpdateHandler(){
        this.forceUpdate();
    };

    render() {
        const combatants = this.state.combatants;

        const combatantList = combatants.map(combatant => {
            return <tr key={combatant.id} id="combatant-row">
                <td style={{whiteSpace: 'nowrap'}}>{combatant.name}</td>
                <td>{combatant.hitPoints}</td>
            </tr>
        });

        return(
            <div>
                <Container fluid>
                    <Row>
                        <Col><PCListShow onCombatantSelect={this.onCombatantChange}/></Col>
                        <Col><MonsterListShow onCombatantSelect={this.onCombatantChange}/></Col>
                        <Col> 
                            <Container fluid>
                                <h3>Encounter</h3>
                                <Table className="mt-4">
                                    <thead>
                                        <tr>
                                            <th width="10%">Name</th>
                                            <th width="10%">HP</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {combatantList}
                                    </tbody>
                                </Table>
                            </Container>
                            
                        </Col>
                    </Row>
                </Container>
            </div>
        )
    }
}

export default Tracker
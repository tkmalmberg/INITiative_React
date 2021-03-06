// For Transparency:
// Retrofitted code from https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot#call-your-spring-boot-api-and-display-the-results
// This seems to be a very general way of structuring a React Component

import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../AppNavbar';

class PCEdit extends Component {
    emptyItem = {
        id: '',
        name: '',
        hitPoints: '',
        race: '',
        className: '',
        level: '',
        strength: 10,
        constitution: 10,
        dexterity: 10,
        intelligence: 10,
        wisdom: 10,
        charisma: 10
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const pc = await (await fetch(`/api/pc/${this.props.match.params.id}`)).json();
            this.setState({item: pc});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/api/pc' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/pcs');
    }

    async remove(id) {
        await fetch(`/api/pc/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        this.props.history.push('/pcs');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.name ? 'Edit Character' : 'Add Character'}</h2>

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <div className="row">
                        <FormGroup className="col-md-4 mb-3">
                            <Label for="name">Name</Label>
                            <Input type="text" name="name" id="name" 
                                    value={item.name || ''} onChange={this.handleChange} 
                                    autoComplete="name"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="hitPoints">Hit Points</Label>
                            <Input type="number" name="hitPoints" id="hitPoints" value={item.hitPoints || ''}
                                    onChange={this.handleChange} autoComplete="hitPoints"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="race">Race</Label>
                            <Input type="text" name="race" id="race" value={item.race || ''}
                                    onChange={this.handleChange} autoComplete="race"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="className">Class</Label>
                            <Input type="text" name="className" id="className" value={item.className || ''}
                                    onChange={this.handleChange} autoComplete="className"/>
                        </FormGroup>
                    </div>
                    <div className="row">
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="strength">STR</Label>
                            <Input type="number" name="strength" id="strength" value={item.strength || ''}
                                    onChange={this.handleChange} autoComplete="strength"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="constitution">CON</Label>
                            <Input type="number" name="constitution" id="constitution" value={item.constitution || ''}
                                    onChange={this.handleChange} autoComplete="constitution"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="dexterity">DEX</Label>
                            <Input type="number" name="dexterity" id="dexterity" value={item.dexterity || ''}
                                    onChange={this.handleChange} autoComplete="dexterity"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="intelligence">INT</Label>
                            <Input type="number" name="intelligence" id="intelligence" value={item.intelligence || ''}
                                    onChange={this.handleChange} autoComplete="intelligence"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="wisdom">WIS</Label>
                            <Input type="number" name="wisdom" id="wisdom" value={item.wisdom || ''}
                                    onChange={this.handleChange} autoComplete="wisdom"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="charisma">CHA</Label>
                            <Input type="number" name="charisma" id="charisma" value={item.charisma || ''}
                                    onChange={this.handleChange} autoComplete="charisma"/>
                        </FormGroup>
                    </div>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}

                        {!item.name ?
                            <Button color="secondary" tag={Link} to="/pcs" 
                                onClick={() => item.name ? console.log('cancelled') : this.remove(item.id)}>Cancel</Button>
                            : 
                            <Button className="float-right" color="danger"  
                                onClick={() => this.remove(item.id)}>Delete</Button>}
                        
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(PCEdit);
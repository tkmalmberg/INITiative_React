import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class Register extends Component {

    emptyUser = {
        email: '',
        pass: ''
    }

    constructor(props) {
        super(props);
        this.state = {
            user: this.emptyUser
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleRegister = this.handleRegister.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let user = {...this.state.user};
        user[name] = value;
        this.setState({user});
    }

    async handleRegister(event) {
        event.preventDefault();
        const {user} = this.state

        await fetch('/register', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        });
        this.props.history.push('/login');
    }

    render() {
        const {user} = this.state;

        return <div>
            <AppNavbar/>
            <Container fluid>
                <h2>Register</h2>
                <Form onSubmit={this.handleRegister}>
                    <FormGroup className="col-md-4 mb-3">
                        <Label for="email">Email</Label>
                        <Input type="text" name="email" id="email"
                                value={user.email || ''} onChange={this.handleChange}/>
                    </FormGroup>
                    <FormGroup className="col-md-4 mb-3">
                        <Label for="pass">Password</Label>
                        <Input type="password" name="pass" id="pass"
                                value={user.pass || ''} onChange={this.handleChange}/>
                    </FormGroup>
                    <FormGroup className="col-md-4 mb-3">
                        <Button color="primary" type="submit">Register</Button>{' '}
                        <Button color="secondary" tag={Link} to="/">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default Register
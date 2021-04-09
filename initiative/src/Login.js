import React, { Component } from 'react';
import { Button, Container, Form, FormGroup, Label, Input} from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class Login extends Component {

    emptyUser = {
        email: '',
        pass: ''
    }


    constructor(props) {
        super(props);
        this.state = {
            user: this.emptyUser,
            isLoading: false
        }
        this.handleLogin = this.handleLogin.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let user = {...this.state.user};
        user[name] = value;
        this.setState({user})
    }

    async handleLogin(e) {
        e.preventDefault();
        this.setState({isLoading: true})
        const {user} = this.state
        await fetch('/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        }).then(response => response.json())
        .then(data => this.setState({user: data, isLoading: false}))
        .catch(e => {
            console.log(e);
            this.setState({...this.state, isLoading: false});
        });

        // sessionStorage.setItem("currentUser", "Tyler");
    }

    handleLogout(e) {
        sessionStorage.clear();
    }

    render() {
        const {user} = this.state;

        return (
            <div>
                <AppNavbar/>
                <Container fluid>

                    {sessionStorage.getItem("currentUser") ? 
                        <div>
                            <h2>Logout</h2>
                            <Button color="primary" onClick={this.handleLogout} tag={Link} to="/">Logout</Button>
                        </div>
                        : 
                        <div>
                            <h2>Login</h2>
                            <Form onSubmit={this.handleLogin}>
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
                                    <Button color="primary" type="submit">Login</Button>{' '}
                                    <Button color="secondary" tag={Link} to="/">Cancel</Button>
                                </FormGroup>
                            </Form>
                        </div>
                    }
                    
                </Container>
            </div>
        )
    }
}
export default Login
import React, { Component } from 'react';
import { Button, Container, Form, FormGroup, Label, Input} from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class Login extends Component {

    emptyUser = {
        id: '',
        firstName: '',
        lastName: '',
        email: '',
        pass: '',
        admin: ''
    }

    emptyCredentials = {
        email: '',
        pass: ''
    }

    constructor(props) {
        super(props);
        this.state = {
            user: null,
            creds: this.emptyCredentials,
            isLoading: false
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let creds = {...this.state.creds};
        creds[name] = value;
        this.setState({creds});
    }

    handleLogin(e) {
        e.preventDefault();
        this.setState({isLoading: true})
        const {creds} = this.state
        fetch('/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(creds),
        }).then(response => response.json(), reject => console.log(reject))
        // .then(data => console.log(JSON.stringify(data)));
        .then(data => sessionStorage.setItem("currentUser", JSON.stringify(data)));
        this.forceUpdate();
        this.props.history.push('/');
    }

    handleLogout(e) {
        sessionStorage.clear();
    }

    render() {
        const {creds} = this.state;

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
                                            defautlValue={creds.email} onChange={this.handleChange}/>
                                </FormGroup>
                                <FormGroup className="col-md-4 mb-3">
                                    <Label for="pass">Password</Label>
                                    <Input type="password" name="pass" id="pass"
                                            defaultValue={creds.password} onChange={this.handleChange}/>
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
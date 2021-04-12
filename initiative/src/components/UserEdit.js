import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../AppNavbar';

class UserEdit extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: sessionStorage.getItem("currentUser")
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let user = {...this.state.user};
        user[name] = value;
        this.setState({user});
    }

    

    async handleSubmit(event) {
        event.preventDefault();
        const {user} = this.state.user;

        await fetch('/api/user/' + user.id, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        });
        this.props.history.push('/user/' + user.id);
    }

    handleLogout(e) {
        sessionStorage.clear();
    }
    
    render() {
        const {user} = this.state.user;

        return <div>
            <AppNavbar/>
            <Container>
                <h2>User Details</h2>
                <Form onSubmit={this.handleSubmit}>
                    <div className="row">
                        <FormGroup className="col-md-4 mb-3">
                            <Label for="firstName">First Name</Label>
                            <Input type="text" firstName="firstName" id="firstName" 
                                    value={user.firstName || ''} onChange={this.handleChange} 
                                    autoComplete="firstName"/>
                        </FormGroup>
                        <FormGroup className="col-md-2 mb-3">
                            <Label for="lastName">Last Name</Label>
                            <Input type="text" name="lastName" id="lastName" value={user.lastName || ''}
                                    onChange={this.handleChange} autoComplete="lastName"/>
                        </FormGroup>
                    </div>
                    <div className="row">
                        <FormGroup className="col-md-4 mb-3">
                            <Label for="email">Email</Label>
                            <Input type="text" email="email" id="email" 
                                    value={user.email || ''} onChange={this.handleChange} 
                                    autoComplete="email"/>
                        </FormGroup>
                    </div>
                    <div className="row">
                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>
                        </FormGroup>
                    </div>
                    <FormGroup>
                        <Button color="primary" onClick={this.handleLogout} tag={Link} to="/">Logout</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default UserEdit
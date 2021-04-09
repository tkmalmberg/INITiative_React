import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        const currentUser = JSON.parse(sessionStorage.getItem("currentUser"));

        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to="/">INITiative</NavbarBrand>
            <NavbarToggler onClick={this.toggle}/>
            <Collapse isOpen={this.state.isOpen} navbar>
                <Nav navbar>
                    <NavItem>
                        <NavLink href="/monsters">Monsters</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/pcs">Characters</NavLink>
                    </NavItem>
                </Nav>
                <Nav className="ml-auto" navbar>
                    <NavItem>
                        <NavLink href={"/register"}>
                            {currentUser ? <span></span> : <span>Register</span>}
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/login"}>
                            {sessionStorage.getItem("currentUser") ? <span>{currentUser.email}</span> : <span>Sign In</span>}
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="https://github.com/tkmalmberg/INITiative_React">GitHub</NavLink>
                    </NavItem>
                </Nav>
            </Collapse>
        </Navbar>
    }
}
import React, { Component } from 'react';
import { Button, Container} from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class Login extends Component {

    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(e) {
        sessionStorage.setItem("currentUser", "Tyler");
    }

    render() {

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-center">
                        <Button color="primary" onClick={this.handleClick} tag={Link} to="/">Login</Button>
                    </div>
                </Container>
            </div>
        )
    }
}
export default Login
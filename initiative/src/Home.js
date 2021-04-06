import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import PCListShow from './components/PCListShow';
import MonsterListShow from './components/MonsterListShow';
import { Container, Row, Col } from 'reactstrap';
// import { Link } from 'react-router-dom';
// import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Row>
                        <Col><PCListShow/></Col>
                        <Col><MonsterListShow/></Col>
                        <Col> Placehoder Text</Col>
                    </Row>
                </Container>
            </div>
            
        );
    }
}
export default Home;
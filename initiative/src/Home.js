import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import Tracker from './components/Tracker';
// import { Link } from 'react-router-dom';
// import { Button, Container } from 'reactstrap';

class Home extends Component {

    

    render() {
        return (
            <div>
                <AppNavbar/>
                <Tracker/>
            </div>
            
        );
    }
}
export default Home;
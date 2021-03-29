import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import MonsterList from './MonsterList';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/monster/all' exact={true} component={MonsterList}/>
        </Switch>
      </Router>
    )
  }
}


export default App;

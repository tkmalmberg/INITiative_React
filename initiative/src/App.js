import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import MonsterList from './components/MonsterList';
import MonsterEdit from './components/MonsterEdit';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/monster/all' exact={true} component={MonsterList}/>
          <Route path='/monster/:id' component={MonsterEdit}/>
        </Switch>
      </Router>
    )
  }
}


export default App;

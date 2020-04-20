import React, {Component} from 'react';
import logo from './logo.svg';
import Homepage from './components/Homepage';
import StudentLoginPage from './components/StudentLoginPage';
import AdminLoginPage from './components/AdminLoginPage';

import {Route, Switch, BrowserRouter as Router} from "react-router-dom";
import './index.css';

function App() {
  return (
    <div className="container">
     <Router>
                   <Switch>
                      <Route path="/" exact component={Homepage} />
                      <Route path="/studentlogin" component={StudentLoginPage} />
                      <Route path="/adminlogin" component={AdminLoginPage} />
                  </Switch>
              
          </Router>
          </div>
  );
}

export default App;
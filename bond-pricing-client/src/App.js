import React, { Component } from 'react';
import { withRouter, Route, Switch } from 'react-router-dom';

import { ACCESS_TOKEN } from './constants';
import { getCurrentUser } from './rest/APICalls';

import LoadingIndicator from './common/LoadingIndicator';
import Login from './Login';
import Profile from './Profile';
import BondTable from './BondTable';
import BondInfo from './BondInfo';
import AddBond from './Bond';


import './App.css';
import AppHeader from './AppHeader';

import { Layout, notification } from 'antd';
const { Content } = Layout;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentUser: null,
      isAuthenticated: false,
      isLoading: false
    }
    this.handleLogout = this.handleLogout.bind(this);
    this.loadCurrentUser = this.loadCurrentUser.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
    this.bondAdded = this.bondAdded.bind(this);

    notification.config({
      placement: 'topRight',
      top: 70,
      duration: 3,
    });    
  }

  loadCurrentUser() {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        isAuthenticated: true,
        isLoading: false
      });
    }).catch(error => {
      this.setState({
        isLoading: false
      });  
    });
  }

  handleLogout(redirectTo="/", notificationType="success", description="You're successfully logged out.") {
    localStorage.removeItem(ACCESS_TOKEN);

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push("/login");
    
    notification[notificationType]({
      message: 'Bond Pricing Application',
      description: description,
    });
  }

  handleLogin() {
    notification.success({
      message: 'Bond Pricing Application',
      description: "You're successfully logged in.",
    });
    this.loadCurrentUser();
    this.props.history.push("/");
  }

  bondAdded() {
    notification.success({
      message: 'Bond Pricing Application',
      description: "Successfully added bond.",
    });
    this.props.history.push("/");
  }


  render() {
    if(this.state.isLoading) {
      return <LoadingIndicator />
    }
    return (
      <Layout className="app-container">
        <AppHeader isAuthenticated={this.state.isAuthenticated} 
            currentUser={this.state.currentUser} 
            onLogout={this.handleLogout} />
        
        <Content className="app-content">
            <div className="container">
              <Switch>      
                <Route exact path="/" 
                  render={(props) => <BondTable isAuthenticated={this.state.isAuthenticated} 
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/bond/:id" 
                  render={(props) => <BondInfo isAuthenticated={this.state.isAuthenticated} 
                      currentUser={this.state.currentUser} {...props} />}>
                </Route>
                <Route exact path="/addbond" 
                  render={(props) => <AddBond isAuthenticated={this.state.isAuthenticated} 
                      currentUser={this.state.currentUser} {...props} bondAdded={this.bondAdded}/>} >
                </Route>
                <Route path="/login" 
                  render={(props) => <Login onLogin={this.handleLogin} {...props} />}>
                </Route>
                <Route path="/users/:username" 
                  render={(props) => <Profile isAuthenticated={this.state.isAuthenticated} currentUser={this.state.currentUser} {...props}  />}>
                </Route>
              </Switch>
            </div>
          </Content>

      </Layout>
    )
  };
}

export default withRouter(App);

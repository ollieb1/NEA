import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Layout, Menu, Dropdown } from 'antd';
import { HomeOutlined, UserOutlined, DownOutlined, EditOutlined, SlidersOutlined }  from '@ant-design/icons';

import 'antd/dist/antd.css';
import './AppHeader.css';

{/* Class relating to header at top of each page */}
class AppHeader extends Component {
    constructor(props) {
        super(props);   
        this.handleMenuClick = this.handleMenuClick.bind(this);   
    }

    handleMenuClick({ key }) {
      if(key === "logout") {
        this.props.onLogout();
      }
    }

    render() {
        let menuItems;
    {/* Loads the home button, profile drop-down and the add menu */}
        if(this.props.currentUser) {
            menuItems = [
                <Menu.Item key="/">
                    <Link to="/">
                        <HomeOutlined />
                    </Link>
                </Menu.Item>,
                <Menu.Item key="/add" className="add-menu">
                        <AddDropdownMenu
                            currentUser={this.props.currentUser} 
                            handleMenuClick={this.handleMenuClick}/>
                </Menu.Item>,
                <Menu.Item key="/profile" className="profile-menu">
                    <ProfileDropdownMenu 
                        currentUser={this.props.currentUser} 
                        handleMenuClick={this.handleMenuClick}/>
                </Menu.Item>
            ]; 
          } else {
  {/* If user not logged in they only have login button in app header */}
            menuItems = [
                <Menu.Item key="/login">
                    <Link to="/login">Login</Link>
                </Menu.Item>                 
            ];
        }
        return (
            <Layout.Header className="app-header">
                <div className="container">
                    <div className="app-title" >
                        <Link to="/">Bond Pricing Application</Link>
                    </div>
                    <Menu
                        className="app-menu"
                        mode="horizontal"
                        style={{ lineHeight: '64px' }} >
                            {menuItems}
                    </Menu>
                </div>
            </Layout.Header>
        );
    }
}

{/* Functionality of the profile dropdown menu */}
const ProfileDropdownMenu = (props) => {
    
    const dropdownMenu = (
        <Menu onClick={props.handleMenuClick} className="profile-dropdown-menu">
        <Menu.Item key="user-info" disabled>
            <div className="user-full-name-info">
                {props.currentUser.name}
            </div>
            <div className="username-info">
                @{props.currentUser.username}
            </div>
        </Menu.Item>
        <Menu.Divider />
        <Menu.Item key="profile">
            Profile
        </Menu.Item>
        <Menu.Item key="logout">
            Logout
        </Menu.Item>
      </Menu>
    );
  
    return (
        <Dropdown 
            overlay={dropdownMenu} 
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a href="#/" className="ant-dropdown-link">
                <UserOutlined style={{marginRight: 0}} /> <DownOutlined />
            </a>
        </Dropdown>
    );
  }

{/* Functionality of the add dropdown menu */}
const AddDropdownMenu = (props) => {
    
    const dropdownMenu = (
        <Menu onClick={props.handleMenuClick} className="add-dropdown-menu">
        <Menu.Item key="addbond">
            <SlidersOutlined /> Bond
            <Link to={`/addbond/`}></Link>
        </Menu.Item>
      </Menu>
    );
  
    return (
        <Dropdown 
            overlay={dropdownMenu} 
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('add-menu')[0]}>
            <a href="#/" className="ant-dropdown-link">
                <EditOutlined style={{marginRight: 0}} /> <DownOutlined />
            </a>
        </Dropdown>
    );
  }
export default withRouter(AppHeader);
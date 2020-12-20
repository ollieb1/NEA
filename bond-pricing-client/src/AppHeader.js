import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Layout, Menu, Dropdown } from 'antd';
import { HomeOutlined, UserOutlined, DownOutlined }  from '@ant-design/icons';

import 'antd/dist/antd.css';
import './AppHeader.css';

class AppHeader extends Component {

    render() {
        let menuItems;
        if(this.props.currentUser) {
            menuItems = [
                <Menu.Item key="/">
                    <Link to="/">
                        <HomeOutlined />
                    </Link>
                </Menu.Item>,
                <Menu.Item key="/profile" className="profile-menu">
                    <ProfileDropdownMenu 
                        currentUser={this.props.currentUser} 
                        handleMenuClick={this.handleMenuClick}/>
                </Menu.Item>
            ]; 
          } else {
  
            menuItems = [
                <Menu.Item key="/login">
                    <Link to="/login">Login</Link>
                </Menu.Item>,
                <Menu.Item key="/signup">
                    <Link to="/signup">Signup</Link>
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

const ProfileDropdownMenu = (props) => {

    const dropdownMenu = (
        <Menu onClick={props.handleMenuClick} className="profile-dropdown-menu">
            <Menu.Item key="user-info" className="dropdown-item" disabled>
                <div className="user-full-name-info">
                    {props.currentUser.name}
                </div>
                <div className="username-info">
                    @{props.currentUser.username}
                </div>
            </Menu.Item>
            <Menu.Divider />
            <Menu.Item key="profile" className="dropdown-item">
                <Link to={`/users/${props.currentUser.username}`}>Profile</Link>
            </Menu.Item>
            <Menu.Item key="logout" className="dropdown-item">
                Logout
            </Menu.Item>
        </Menu>
    );
  
    return (
        <Dropdown 
            overlay={dropdownMenu} 
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a className="ant-dropdown-link">
                <UserOutlined style={{marginRight: 0}} /> <DownOutlined />
            </a>
        </Dropdown>
    );
  }
  
export default withRouter(AppHeader);
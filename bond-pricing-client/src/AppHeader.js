import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Layout, Menu } from 'antd';

import 'antd/dist/antd.css';
import './AppHeader.css';

class AppHeader extends Component {

    render() {
        let menuItems;
        menuItems = [
            <Menu.Item key="/login">
              <Link to="/login">Login</Link>
            </Menu.Item>,
            <Menu.Item key="/signup">
              <Link to="/signup">Signup</Link>
            </Menu.Item>                  
          ];

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

export default withRouter(AppHeader);
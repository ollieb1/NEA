import React, { Component } from 'react';
import { login } from './rest/APICalls';
import './Login.css';
import { Link } from 'react-router-dom';
import { ACCESS_TOKEN } from './constants';

import { Form, Input, Button, notification } from 'antd';
import { LockOutlined, UserOutlined } from '@ant-design/icons';

class Login extends Component {
    render() {
        return (
            <div className="login-container">
                <h1 className="page-title">Login</h1>
                <div className="login-content">
                    <LoginForm onLogin={this.props.onLogin} />
                </div>
            </div>
        );
    }
}

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(values) {
        const loginRequest = Object.assign({}, values);
        login(loginRequest)
        .then(response => {
            localStorage.setItem(ACCESS_TOKEN, response.accessToken);
            this.props.onLogin();
        }).catch(error => {
            if(error.status === 401) {
                notification.error({
                    message: 'Bond Pricing Application',
                    description: 'Your Username or Password is incorrect. Please try again!'
                });                    
            } else {
                notification.error({
                    message: 'Bond Pricing Application',
                    description: error.message || 'Sorry! Something went wrong. Please try again!'
                });                                            
            }
        });
    }

    render() {
        return (
            <Form onFinish={this.handleSubmit} className="login-form">
                <Form.Item
                    name='usernameOrEmail' rules={[{ required: true, message: 'Please input your username or email!'}]}>
                    <Input 
                        prefix={<UserOutlined />}
                        size="large" 
                        placeholder="Username" /> 
                </Form.Item>
                <Form.Item
                    name='password' rules={[{ required: true, message: 'Please input your Password!'}]}>
                    <Input.Password
                        prefix={<LockOutlined />}
                        size="large"
                        placeholder="Password" />                        
                </Form.Item>
                <Form.Item>
                    <Button type="primary" htmlType="submit" size="large" className="login-form-button">Login</Button>
                </Form.Item>
            </Form>
        );
    }
}

export default Login;
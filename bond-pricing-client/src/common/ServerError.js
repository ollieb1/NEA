import React, { Component } from 'react';
import './ServerError.css';
import { Link } from 'react-router-dom';
import { Button } from 'antd';

{/* If there is a server error catches error and prompts user to be returned to home page*/}
class ServerError extends Component {
    render() {
        return (
            <div className="server-error-page">
                <h1 className="server-error-title">
                    500
                </h1>
                <div className="server-error-desc">
                    Oops! Something went wrong at our Server. Why don't you go back?
                </div>
                <Link to="/"><Button className="server-error-go-back-btn" type="primary" size="large">Go Back</Button></Link>
            </div>
        );
    }
}

export default ServerError;


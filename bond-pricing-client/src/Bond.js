import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { Form, Input, Button, Select, DatePicker, InputNumber, Row, Col, notification } from 'antd';
import { add } from './rest/APICalls'; 

{/* Handles the adding of a bond */}
class AddBond extends Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    handleSubmit(values) {
        const addRequest = Object.assign({}, values);
        addRequest.coupon /= 100; {/* Coupon displayed as percentage on screen so must divide by 100 */}
        add(addRequest)
        .then(response => {
            this.props.bondAdded();
        }).catch(error => {
            notification.error({
                    message: 'Error',
                    description: 'Something went wrong, please try again'
            });                            
        });
    }

    render() {
        {/* Renders the form where the user can fill out the bond attributes */}
        return (
            <Form
                labelCol={{ span: 5 }}
                wrapperCol={{ span: 14 }}
                layout="horizontal"
                onFinish={this.handleSubmit} className="bond-form">
                <Form.Item name="isin" label="Isin">
                    <Input/>
                </Form.Item>
                <Form.Item name="currency" label="Currency">
                    <Select>
                        <Select.Option value="EUR">EUR</Select.Option>
                        <Select.Option value="GBP">GBP</Select.Option>
                        <Select.Option value="USD">USD</Select.Option>
                    </Select>
                </Form.Item>
                <Form.Item name="coupon" label="Coupon">
                    <InputNumber
                        min={0}
                        max={100}
                        formatter={value => `${value}%`}
                        parser={value => value.replace('%', '')}
                    />
                </Form.Item>
                <Form.Item name="frequency" label="Frequency">
                    <Select>
                        <Select.Option value="ANNUALLY">Annually</Select.Option>
                        <Select.Option value="QUARTERLY">Quarterly</Select.Option>
                        <Select.Option value="SEMIANNUALLY">Semi-annually</Select.Option>
                    </Select>
                </Form.Item>
                <Form.Item name="dayCount" label="Daycount">
                    <Select>
                        <Select.Option value="ACT360">Act/360</Select.Option>
                        <Select.Option value="ACT365">Act/365</Select.Option>
                    </Select>
                </Form.Item>
                <Form.Item label="Issue Date" >
                    <Row gutter={8}>
                        <Col span={6}>
                            <Form.Item name="issueDate" >
                                <DatePicker />
                            </Form.Item>
                        </Col>
                        <Col span={2}/>
                        <Col span={12}>
                            <Form.Item name="maturityDate" label="Maturity Date">
                                <DatePicker />
                            </Form.Item>
                        </Col>
                    </Row>        
                </Form.Item>
                <Form.Item>
                    <Row gutter={8}>
                        <Col span={18}/>
                        <Col span={2}>
                            <Button type="primary" htmlType="submit">
                                Add
                            </Button>
                        </Col>
                    </Row>
                </Form.Item>
            </Form>
        );
    }
}

export default withRouter(AddBond);
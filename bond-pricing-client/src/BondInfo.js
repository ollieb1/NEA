import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { Form, Input, Button, Select, DatePicker, InputNumber } from 'antd';
import { getBond } from './rest/APICalls';
import moment from 'moment';

class BondInfo extends Component {
    
    formRef = React.createRef();

    constructor(props) {
        super(props);
        this.state = {
          isLoading: false,
        };
        this.loadBond = this.loadBond.bind(this);
    }

    loadBond(id) {
        this.setState({
            isLoading: true
        });

        getBond(id)
        .then(response => {
            this.formRef.current.setFieldsValue({
                isin: response.isin,
                currency: response.currency,
                coupon: response.coupon * 100,
                frequency: response.frequency,
                dayCount: response.dayCount,
                issueDate: moment(response.issueDate),
                maturityDate: moment(response.maturityDate),
                stubStartDate: response.stubStartDate == null ? null : moment(response.stubStartDate),
                stubEndDate: response.stubEndDate == null ? null : moment(response.stubEndDate),

            })
            this.setState({
                isLoading: false
            });
        }).catch(error => {
            if(error.status === 404) {
                this.setState({
                    notFound: true,
                    isLoading: false
                });
            } else {
                this.setState({
                    serverError: true,
                    isLoading: false
                });        
            }
        });        
    }
      
    componentDidMount() {
        const id = this.props.match.params.id;
        this.loadBond(id);
    }

    render() {

        return (
            <Form ref={this.formRef}
                labelCol={{ span: 5 }}
                wrapperCol={{ span: 10 }}
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
                <Form.Item name="issueDate" label="Issue Date">
                    <DatePicker />
                </Form.Item>
                <Form.Item name="maturityDate" label="Maturity Date">
                    <DatePicker />
                </Form.Item>
                <Form.Item name="stubStartDate" label="First Coupon Date">
                    <DatePicker />
                </Form.Item>
                <Form.Item name="stubEndDate" label="Penultimate Coupon Date">
                    <DatePicker />
                </Form.Item>
            </Form>
        );
    }
}

export default withRouter(BondInfo);
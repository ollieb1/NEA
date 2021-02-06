import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { Divider, Form, Input, Button, Select, DatePicker, InputNumber,
    Row, Col, notification } from 'antd';
import { getBond, price } from './rest/APICalls';
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

    handleSubmit(values) {
        const priceRequest = Object.assign({}, values);
        price(priceRequest)
        .then(response => {
            notification.error({
                message: response.price,
                description: 'TODO'
            }); 
            
        }).catch(error => {
            notification.error({
                    message: 'TODO - something went wrong',
                    description: 'TODO - something went wrong'
            });                            
        });
    }

    render() {
        return (
            <Form ref={this.formRef}
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
                <Form.Item label="First Coupon Date" >
                    <Row gutter={8}>
                        <Col span={6}>
                            <Form.Item name="stubStartDate" >
                                <DatePicker />
                            </Form.Item>
                        </Col>
                        <Col span={2}/>
                        <Col span={14}>
                            <Form.Item name="stubEndDate" label="Penultimate Coupon Date">
                                <DatePicker />
                            </Form.Item>
                        </Col>
                    </Row>        
                </Form.Item>
                <Divider />
                <Form.Item label="Valuation Date">
                    <Row gutter={8}>
                        <Col span={6}>
                            <Form.Item name="valuationDate" noStyle rules={[{ required: true}]}>
                                <DatePicker />
                            </Form.Item>
                        </Col>
                        <Col span={2}>
                            <Button type="primary" htmlType="submit">
                                Price
                            </Button>
                        </Col>
                        <Col span={8}/>
                    </Row>
                </Form.Item>
            </Form>
        );
    }
}

export default withRouter(BondInfo);
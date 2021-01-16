import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { BOND_LIST_SIZE } from './constants';
import { getAllBonds } from './rest/APICalls';
import { Table, Space } from 'antd';


const columns = [
    {
      title: 'Isin',
      dataIndex: 'isin',
      key: 'isin',
    },
    {
      title: 'Currency',
      dataIndex: 'currency',
      key: 'currency',
    },
    {
      title: 'Coupon',
      dataIndex: 'coupon',
      key: 'coupon',
    },
    {
      title: 'Frequency',
      dataIndex: 'frequency',
      key: 'frequency',
    },
    {
      title: 'Issue Date',
      dataIndex: 'issueDate',
      key: 'issueDate',
    },
    {
      title: 'Maturity Date',
      dataIndex: 'maturityDate',
      key: 'maturityDate',
    },
    {
        title: 'Action',
        key: 'action',
        render: (text, row) => (
            <Space size="middle">
                <Link to={`/bond/${row.id}`}>Select...</Link>
            </Space>
        ),
    },
  ];

class BondTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bonds: [],
            pagination: {
              current: 1,
              pageSize: BOND_LIST_SIZE,
              total: 0
            },
            loading: false,
          };
        this.loadBonds = this.loadBonds.bind(this);
    }

    componentDidMount() {
        const { pagination } = this.state;
        this.loadBonds(pagination.current, pagination.size)
      }

    loadBonds(page = 1, size = BOND_LIST_SIZE) {
        
        let promise = getAllBonds(page, size);
        if (!promise) {
            return;
        }

        this.setState({
            loading: true
        });

        promise            
        .then(response => {

            this.setState({
                bonds: response.content,
                pagination: {
                    current: response.page + 1,
                    pageSize: response.size,
                    total: response.totalElements,
                },
                loading: false
            })
        }).catch(error => {
            this.setState({
                loading: false
            })
        });  
        
    }

    handleTableChange = (pagination, filters, sorter) => {
        this.loadBonds(pagination.current, pagination.pageSize)    
    };

    render() {
        const { bonds, pagination, loading } = this.state;
        return (
          <Table
            columns={columns}
            rowKey={row => row.id}
            dataSource={bonds}
            pagination={pagination}
            loading={loading}
            onChange={this.handleTableChange}
          />
        );
    }
}

export default withRouter(BondTable);

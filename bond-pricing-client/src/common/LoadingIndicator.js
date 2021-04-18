import React from 'react';
import { Spin } from 'antd';
import { Loading3QuartersOutlined }  from '@ant-design/icons';

{/* Represents the loading indicator when waiting for something to load. */}
export default function LoadingIndicator(props) {
    const antIcon = <Loading3QuartersOutlined style={{ fontSize: 30 }} spin />;
    return (
        <Spin indicator={antIcon} style = {{display: 'block', textAlign: 'center', marginTop: 30}} />
    );
}
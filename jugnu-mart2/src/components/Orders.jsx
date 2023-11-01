import React, { useState, useEffect } from 'react';

export function Orders() {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        // Fetch orders data from an API or other source
        // Example:
        // fetch('https://api.example.com/orders')
        //     .then(response => response.json())
        //     .then(data => setOrders(data));
    }, []);

    return (
        <div className="container" style={{overflow: 'scroll'}}>
            <table className="table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Product Image</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Total Amount</th>
                        <th>Order Time</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>53625</td>
                        <td><img src="logo192.png" alt="" width="40px" /></td>
                        <td>Shoes</td>
                        <td>2</td>
                        <td>2000.0</td>
                        <td>2023-01-01 12:03 PM</td>
                        <td>Out For Delivery</td>
                    </tr>
                    <tr>
                        <td>62532</td>
                        <td><img src="logo192.png" alt="" width="40px" /></td>
                        <td>Pens</td>
                        <td>10</td>
                        <td>100.0</td>
                        <td>2023-02-01 09:03 AM</td>
                        <td>Completed</td>
                    </tr>
                    <tr>
                        <td>53625</td>
                        <td><img src="logo192.png" alt="" width="40px" /></td>
                        <td>Mobile</td>
                        <td>1</td>
                        <td>200000.0</td>
                        <td>2023-01-01 12:03 PM</td>
                        <td>Shipped</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default Orders;

import React, { useState } from 'react';

function ViewRequest() {
  // Sample request data
  const [productRequests, setProductRequests] = useState([
    {
      id: 1,
      employeeName: 'John Doe',
      productName: 'Product A',
      action: 'Add',
    },
    {
      id: 2,
      employeeName: 'Jane Smith',
      productName: 'Product B',
      action: 'Update',
    },
    // Add more request objects as needed
  ]);

  return (
    <div className='container'>
      <h3>View Requests</h3>
      <hr />
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Product Name</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {productRequests.map((request) => (
            <tr key={request.id}>
              <td>{request.id}</td>
              <td>{request.employeeName}</td>
              <td>{request.productName}</td>
              <td>{request.action}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ViewRequest;

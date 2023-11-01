import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DeleteEmployee() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    // Fetch employee data from the backend when the component mounts
    axios.get('your-backend-api-url/employees')
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error('Error fetching employee data:', error);
      });
  }, []);

  const handleDelete = (employeeId) => {
    // Function to delete an employee by their ID and update the backend
    axios.delete(`your-backend-api-url/employees/${employeeId}`)
      .then(() => {
        // Update the employees state after a successful deletion
        const updatedEmployees = employees.filter((employee) => employee.id !== employeeId);
        setEmployees(updatedEmployees);
      })
      .catch((error) => {
        console.error('Error deleting employee:', error);
      });
  };

  return (
    <div className='container'>
      <h3>Delete Employee</h3>
      <hr />
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.name}</td>
              <td>
                <button onClick={() => handleDelete(employee.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DeleteEmployee;

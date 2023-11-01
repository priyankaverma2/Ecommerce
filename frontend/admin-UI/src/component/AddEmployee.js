import React, { useState } from 'react';

function AddEmployee() {
  const [employeeName, setEmployeeName] = useState('');
  const [employeeTitle, setEmployeeTitle] = useState('');
  const [employeeSalary, setEmployeeSalary] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Here, you can send the employee data to your API or perform any desired action.
    // For this example, we'll log the employee data to the console.
    console.log('Employee Name: ', employeeName);
    console.log('Employee Title: ', employeeTitle);
    console.log('Employee Salary: ', employeeSalary);

    // You can also reset the form fields here if needed.
    setEmployeeName('');
    setEmployeeTitle('');
    setEmployeeSalary('');
  };

  return (
    <div className='container'>
      <h3>Add Employee</h3>
      <hr />
      <form onSubmit={handleSubmit}>
        <div className='form-group'>
          <label>Name</label>
          <input
            type='text'
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
          />
        </div>
        <div className='form-group'>
          <label>Title</label>
          <input
            type='text'
            value={employeeTitle}
            onChange={(e) => setEmployeeTitle(e.target.value)}
            required
          />
        </div>
        <div className='form-group'>
          <label>Salary</label>
          <input
            type='number'
            value={employeeSalary}
            onChange={(e) => setEmployeeSalary(e.target.value)}
            required
          />
        </div>
        <button type='submit'>Add Employee</button>
      </form>
    </div>
  );
}

export default AddEmployee;

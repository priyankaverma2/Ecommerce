import React, { useState } from "react";
import './employeeLogin.css'
import { useNavigate } from "react-router-dom";
import axios from 'axios';

function EmployeeLogin({ setAuthStatus }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
      e.preventDefault();
      let profile = {
        email: email,
        password: password,
      };
      let url = 'http://localhost:8080/employee/login';

      try {
        const response = await axios.post(url, profile);

        if (response.status === 201) {
          // Successful login
          setAuthStatus(true); // Set authentication status
          navigate('/employeeDashboard', { state: { userdata: response.data } });

        } else {
          // Handle other status codes if needed
          setErrorMessage('Incorrect email or password. Please try again.');
        }
      } catch (err) {
        console.log(err);
        setErrorMessage('Incorrect email or password. Please try again.');
      }
    };

    return (
      <div className="Auth-form-container">
        <form className="Auth-form" onSubmit={handleLogin}>
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Employee Login</h3>
            <div className="form-group mt-3">
              <label>Email ID</label>
              <input
                type="text"
                className="form-control mt-1"
                placeholder="Enter emailId"
                value={email}
                onChange={(e) => setEmail(e.target.value)} // Add onChange to update the state
              />
            </div>
            <div className="form-group mt-3">
              <label>Password</label>
              <input
                type="password"
                className="form-control mt-1"
                placeholder="Enter password"
                value={password}
                onChange={(e) => setPassword(e.target.value)} // Add onChange to update the state
              />
            </div>
            <div className="d-grid gap-2 mt-3">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
            <p className="forgot-password text-right mt-2">
              <a href="#">Forgot password?</a>
            </p>
          </div>
        </form>
      </div>
    );
}

export default EmployeeLogin;

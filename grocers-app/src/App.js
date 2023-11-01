import './App.css';
import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import EmployeeLogin from './components/Employee/employeeLogin'; // Updated component name
import EmployeeDashboard from './components/employeeDashboard/employeeDashboard';

function App() {
  const [authStatus, setAuthStatus] = useState(false);

  return (
    <Router>
      <Routes>
        <Route
          path="/employeeLogin"
          element={<EmployeeLogin setAuthStatus={setAuthStatus} />}
        />
        <Route
          path="/employeeDashboard"
          element={
            authStatus ? (
              <EmployeeDashboard />
            ) : (
              <Navigate to="/employeeLogin" replace />
            )
          }
        />
      </Routes>
    </Router>
  );
}

export default App;

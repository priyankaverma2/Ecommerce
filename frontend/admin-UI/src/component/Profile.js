import React, { useState } from 'react';
import { useNavigate, BrowserRouter as Router } from 'react-router-dom'; // Import and use BrowserRouter here

function Login(props) {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  
  const handleLogin = () => {
    if (userId === 'admin' && password === 'password') {
      props.setAuthenticated(true);
      navigate('/adminView');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <div>
        <input
          type="text"
          placeholder="User ID"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
      </div>
      <div>
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;

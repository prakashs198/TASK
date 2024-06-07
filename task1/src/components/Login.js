import React, { useState } from 'react'
import './Login.css'

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({});
  
    const validate = () => {
      let isValid = true;
      const errors = {};
  
      if (!email) {
        isValid = false;
        errors.email = 'Email is required';
      } else if (!/\S+@\S+\.\S+/.test(email)) {
        isValid = false;
        errors.email = 'Email address is invalid';
      }
  
      if (!password) {
        isValid = false;
        errors.password = 'Password is required';
      } else if (password.length < 8) {
        isValid = false;
        errors.password =alert( 'Password must be at least 10 characters');
      }
  
      setErrors(errors);
      return isValid;
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      if (validate()) {
        alert('Login successfully');
      }
    };
  
    return (
      <div className="login-container">
        <form onSubmit={handleSubmit}>
          <div>
            <label>Email:</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            {errors.email && <span className="error">{errors.email}</span>}
          </div>
          <div>
            <label>Password:</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            {errors.password && <span className="error">{errors.password}</span>}
          </div>
          <button type="submit">Login</button>
        </form>
      </div>
    );
  };

export default Login

import React, { useState } from 'react';
import axios from 'axios';
import {jwtDecode} from 'jwt-decode';
import { Link } from 'react-router-dom';

function Login() {
  const [name, setname] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:5000/login', { name, password });
      const token = response.data.token;
      const decoded = jwtDecode(token);
      console.log(decoded);
      localStorage.setItem('token', token);
      alert('Login successful!');
    } catch (error) {
      console.error(error);
      alert('Login Successfull!');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="Username" value={name} onChange={(e) => setname(e.target.value)} required />
        <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        <button type="submit">Login</button>
        <div>
             <Link to="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S471277560%3A1717333175685470&ddm=0" className='btn btn-primary border w-100 rounded-0 text-decoration-none'><strong>Gmail</strong></Link>&nbsp;&nbsp;&nbsp;
             
             <Link to="https://www.facebook.com/login.php/" className='btn btn-primary border w-100 rounded-0 text-decoration-none'>
              <strong>FaceBook</strong></Link></div>
      </form>
    </div>
  );
}

export default Login;


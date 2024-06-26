import './App.css';

import React from 'react';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';


function App() {
  return (
    <BrowserRouter>
    <Routes>
          <Route path="/register" element={<Register/>} />
          <Route path="/" element={<Login/>} />
    </Routes>
    </BrowserRouter>
  );
}

export default App;

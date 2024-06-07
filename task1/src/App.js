import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import Login from './components/Login';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <div className="content">
        <Login/>
        <Login/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;

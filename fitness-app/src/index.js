import React from 'react';
import ReactDOM from 'react-dom/client';
import './CSS/index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Home from './Views/home';
import Exercise from './Components/exercise';
import ProfileInfo from './Views/ProfileInfo';
import Header from './Components/Header'
import {BrowserRouter as Router,
        Route,
        Routes
        } from 'react-router-dom';

const Routing = () => {
  return(
    <Router>
      <Header/>
      <Routes>
        <Route  exact path="/" element={<Home />}></Route>
        <Route  exact path='/search' element={<Exercise />}></Route>
        <Route  exact path="/profile" element={<ProfileInfo />}></Route>
      </Routes>
    </Router>
  )
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <div className="layer"></div>
    <Routing />
    
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

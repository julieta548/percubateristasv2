import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Principal from './Componentes/Principal/Principal';
import Login from './Componentes/Login/Login';

const App = () => {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/" element={<Principal />} />
                    <Route path="/login" element={<Login />} />
                </Routes>
            </Router>
        </>

    );
}

export default App;

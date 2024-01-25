import React from 'react'
import './Login.css'
import { FaUserAlt, FaLock } from "react-icons/fa";

const Login = () => {
    return (
        <div className='wrapper'>
            <form action="">
                <h1>Ingresar</h1>
                <div className="input-box">
                    <input type="text" placeholder='Usuario' required />
                    <FaUserAlt className='icon' />
                </div>
                <div className="input-box">
                    <input type="password" placeholder='Contraseña' required />
                    <FaLock className='icon' />
                </div>
                <div className="remember-forgot">
                    <label>
                        <input type="checkbox" />Recordarme
                    </label>
                    <a href="#">¿Olvidaste tu contraseña?</a>

                </div>
                <button type='submit'>Ingresar</button>
                <div className="register-link">
                    <p>¿No estás registrado? <a href="#">Registrarse</a></p>
                </div>

            </form>
        </div>
    )
}

export default Login
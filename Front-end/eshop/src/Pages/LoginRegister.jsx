import React, { cloneElement, useState } from 'react'
import './Css/LoginRegister.css'


const LoginRegister = () => {
    var log = true;
    const urlLogin = "http://localhost:8080/api/v1/user/login";
    const urlSignup = "http://localhost:8080/api/v1/user/save";
    const [title, settitle] = useState('Login')
    const [message, setmesage] = useState('');
    const [form, setForm] = useState({
        username: "",
        name: "",
        surname: "",
        email: "",
        phonenumber: "",
        password: ""
    })

    const changeHandler = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }
    const loginFetch = async(url,form) => {
        return (await fetch(url,{
            method:"Post",
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(form)
        })).json();
    }

    const signupFetch = async(url,form) => {
        return (await fetch(url,{
            method:"POST",
            headers:{
                Accept : 'application/json',
                'Content-Type' : 'application/json'
            },
            body:JSON.stringify(form)
        })).json()
    }
    
    const login = async () => {
        let dataRes =[];
        dataRes = await loginFetch(urlLogin,form)
        if (dataRes.code === 1000) {
            log = true;
            console.log(dataRes.result.id)
            localStorage.setItem('userid', dataRes.result.id)
            window.location.replace('/')
        } else {
            setmesage(dataRes.message)
            setTimeout(() => {
                setmesage('')
            }, 1000)
            log = false;
        }
    }

    const signup = async () => {
        let datares = [];
        datares = await signupFetch(urlSignup,form)
        if (!datares.result) {
           setmesage(datares.message)
            setTimeout(() => {
                setmesage('')
            }, 1000)
            log = false;
            
        }else{
            window.location.replace('/login')
             setmesage(datares.message)
            setTimeout(() => {
                setmesage('')
            }, 1000)
            log = false;
        }
    }
    console.log(form)

  return (
  
        <div className={title === 'Sign up' ? 'loginsignup' : 'loginsignup1'}>
            {message ? <div className='mess'>{message}</div> : <></>}
            <div className={title === 'Sign up' ? 'loginsignup-container' : 'loginsignup-container1'} >
                {log === false ? <h1>error</h1> : <></>}
                <h1>{title}</h1>
                <div className="loginsignup-fields">
                    {title === 'Sign up' ? <div className='child'>
                        <input name='name' value={form.name} onChange={changeHandler} type="text" placeholder='Name' />
                        <input name='surname' value={form.surname} onChange={changeHandler} type='text' placeholder='Surname' />
                    </div> : <></>}
                    <input name='email' value={form.email} pattern="[^ @]*@[^ @]*" onChange={changeHandler} type="email" placeholder='Email' id="" />
                    
                    {title === 'Sign up' ? <input name='username' onChange={changeHandler} value={form.username} type="text" placeholder='Username' id="" required /> : <></>}
                    {title === 'Sign up' ? <input name='phonenumber' value={form.phonenumber} onChange={changeHandler} type="number" placeholder='Phone Number' id="" /> : <></>}
                    <input name='password' value={form.password} onChange={changeHandler} type="password" placeholder='Password' id="" required />

                </div>
                <button onClick={() => { title === 'Login' ? login() : signup() }} >Continue</button>
                {title === 'Sign up' ? <p className="loginsignup-login">Already have an account <span onClick={() => { settitle('Login') }}>Login here</span></p> : <p className="loginsignup-login">Create an account?<span onClick={() => { settitle('Sign up') }}>Click here</span></p>}
                <div className='loginsignup-agree'>
                    <input type="checkbox" name="" id="" />
                    <p>By continuing, i agree to the terms of use & privacy policy.</p>
                </div>
            </div>
        </div>
  )
}

export default LoginRegister

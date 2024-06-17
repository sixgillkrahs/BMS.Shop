import React from 'react'
import './Header.css'
import './Header.scss'
import { Link  ,useLocation } from 'react-router-dom';
const logo = require('../Assets/img/logo.png');

const Header = () => {
    const location = useLocation();

  return (
    <header className="header">
        <div className="container-fluid">
            <div className="row">
                <div className="col-xl-3 col-lg-2">
                    <div className="header__logo">
                        <a href="./index.html"><img src={logo} alt=""/></a>
                    </div>
                </div>
                <div className="col-xl-6 col-lg-7">
                    <nav className="header__menu">
                        <ul>
                            <li className={location.pathname === '/' ? 'active' : ''}><Link style={{textDecoration:'none' , color:'#626262'}} to='/'>Home</Link></li>
                            <li><a href="#">Women’s</a></li>
                            <li><a href="#">Men’s</a></li>
                            <li className={location.pathname === '/shop' ? 'active' : ''}><Link style={{textDecoration:'none' , color:'#626262'}} to='/shop'>Shop</Link></li>
                            <li><a href="#">Pages</a>
                                <ul className="dropdown">
                                    <li><a href="./product-details.html">Product Details</a></li>
                                    <li><a href="./shop-cart.html">Shop Cart</a></li>
                                    <li><a href="./checkout.html">Checkout</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div className="col-lg-3">
                    <div className="header__right">
                        <div className="header__right__auth">
                            <Link style={{textDecoration:'none' , color:'#626262'}} to='/login'>Login</Link>
                            <Link style={{textDecoration:'none' , color:'#626262'}} to='/register'>Register</Link>
                        </div>
                         <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <li><a href="#"><span class="icon_heart_alt"></span>
                                <div class="tip">2</div>
                            </a></li>
                            <li><a href="#"><span class="icon_bag_alt"></span>
                                <div class="tip">2</div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="canvas__open">
                <i className="fa fa-bars"></i>
            </div>
        </div>
    </header>
  )
}

export default Header

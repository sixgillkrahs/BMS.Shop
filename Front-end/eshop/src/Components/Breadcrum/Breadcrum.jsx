import React from 'react'
import './Breadcrum.css'
import './Breadcrum.scss'
import { Link } from 'react-router-dom'

const Breadcrum = (props) => {
  return (
    <div className="breadcrumb-option">
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <div className="breadcrumb__links">
                        <Link style={{textDecoration:'none' , color:'#626262'}} to='/'><i class="fa fa-home"></i> Home</Link>
                        {props.category ? <span><Link>Shop</Link> <Link>{props.category}</Link> <span>{props.product}</span></span>:<span>Shop</span>}
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Breadcrum

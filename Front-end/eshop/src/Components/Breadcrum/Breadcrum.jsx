import React from 'react'
import './Breadcrum.css'
import './Breadcrum.scss'
import { Link } from 'react-router-dom'

const Breadcrum = (props) => {
    const {product,param,category} = props
    console.log(param)
  return (
    <div className="breadcrumb-option">
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <div className="breadcrumb__links">
                        <Link style={{textDecoration:'none' , color:'#626262'}} to='/'><i class="fa fa-home"></i> Home</Link>
                        {category ? <span><Link>{param}</Link> <Link>{category}</Link> <span>{product}</span></span>:<span>{param}</span>}
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Breadcrum

import React, { useContext } from 'react'
import SideBar from '../SideBar/SideBar'
import './Section.css'
import './Section.scss'
import Item from '../Item/Item';
import { Context } from '../../Context/ShopContext';
const product1 = require('../Assets/img/shop/shop-1.jpg');


const Section = () => {
    const {allproduct} = useContext(Context)
    return (
        <section className="shop spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-3 col-md-3">
                        <div className="shop__sidebar">
                            <SideBar/>
                        </div>
                    </div>
                    <div className="col-lg-9 col-md-9">
                        <div className="row">
                            {allproduct.map((item) => {
                                return <Item id={item.id} name={item.name}  price={59.0} rating={4} image={item.thumnailimage}/>
                            })}
                            <div className="col-lg-12 text-center">
                                <div className="pagination__option">
                                    <a href="#">1</a>
                                    <a href="#">2</a>
                                    <a href="#">3</a>
                                    <a href="#"><i className="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default Section

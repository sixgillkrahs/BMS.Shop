import React from 'react'
import './Banner.css'
import './Banner.scss'
const category1 = require('../Assets/img/categories/category-1.jpg');
const category2 = require('../Assets/img/categories/category-2.jpg');
const category3 = require('../Assets/img/categories/category-3.jpg');
const category4 = require('../Assets/img/categories/category-4.jpg');
const category5 = require('../Assets/img/categories/category-5.jpg');


const Banner = () => {


  return (
    <section className="categories">
        <div className="container-fluid">
            <div className="row">
                <div className="col-lg-6 p-0">
                    <div className="categories__item categories__large__item set-bg " style={{
                                    backgroundImage: `url(${category1})`,
                                }}>
                    <div className="categories__text">
                        <h1>Women’s fashion</h1>
                        <p>Sitamet, consectetur adipiscing elit, sed do eiusmod tempor incidid-unt labore
                        edolore magna aliquapendisse ultrices gravida.</p>
                        <a href="#">Shop now</a>
                    </div>
                </div>
            </div>
            <div className="col-lg-6">
                <div className="row">
                    <div className="col-lg-6 col-md-6 col-sm-6 p-0">
                        <div className="categories__item set-bg" style={{
                                    backgroundImage: `url(${category2})`,
                                }}>
                            <div className="categories__text">
                                <h4>Men’s fashion</h4>
                                <p>358 items</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6 col-sm-6 p-0">
                        <div className="categories__item set-bg" style={{
                                    backgroundImage: `url(${category3})`,
                                }}>
                            <div className="categories__text">
                                <h4>Kid’s fashion</h4>
                                <p>273 items</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6 col-sm-6 p-0">
                        <div className="categories__item set-bg" style={{
                                    backgroundImage: `url(${category4})`,
                                }}>
                            <div className="categories__text">
                                <h4>Cosmetics</h4>
                                <p>159 items</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6 col-sm-6 p-0">
                        <div className="categories__item set-bg" style={{
                                    backgroundImage: `url(${category5})`,
                                    backgroundPosition: 'top center',
                                }}>
                            <div className="categories__text">
                                <h4>Accessories</h4>
                                <p>792 items</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
  )
}

export default Banner

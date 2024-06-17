import React from 'react'
import './Category.css'
import './Category.scss'

const Category = () => {
  return (
    <div class="sidebar__categories">
        <div class="section-title">
            <h4>Categories</h4>
        </div>
        <div class="categories__accordion">
            <div class="accordion" id="accordionExample">
                <div class="card">
                    <div class="card-heading active">
                        <a data-toggle="collapse" data-target="#collapseOne">Women</a>
                    </div>
                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                        <div class="card-body">
                            <ul>
                                <li><a href="#">Coats</a></li>
                                <li><a href="#">Jackets</a></li>
                                <li><a href="#">Dresses</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">T-shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-heading">
                        <a data-toggle="collapse" data-target="#collapseTwo">Men</a>
                    </div>
                    <div id="collapseTwo" class="collapse" data-parent="#accordionExample">
                        <div class="card-body">
                            <ul>
                                <li><a href="#">Coats</a></li>
                                <li><a href="#">Jackets</a></li>
                                <li><a href="#">Dresses</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">T-shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-heading">
                        <a data-toggle="collapse" data-target="#collapseThree">Kids</a>
                    </div>
                    <div id="collapseThree" class="collapse" data-parent="#accordionExample">
                        <div class="card-body">
                            <ul>
                                <li><a href="#">Coats</a></li>
                                <li><a href="#">Jackets</a></li>
                                <li><a href="#">Dresses</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">T-shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-heading">
                        <a data-toggle="collapse" data-target="#collapseFour">Accessories</a>
                    </div>
                    <div id="collapseFour" class="collapse" data-parent="#accordionExample">
                        <div class="card-body">
                            <ul>
                                <li><a href="#">Coats</a></li>
                                <li><a href="#">Jackets</a></li>
                                <li><a href="#">Dresses</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">T-shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-heading">
                        <a data-toggle="collapse" data-target="#collapseFive">Cosmetic</a>
                    </div>
                    <div id="collapseFive" class="collapse" data-parent="#accordionExample">
                        <div class="card-body">
                            <ul>
                                <li><a href="#">Coats</a></li>
                                <li><a href="#">Jackets</a></li>
                                <li><a href="#">Dresses</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">T-shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Category

import React from 'react'
import './Filter.css'
import './Filter.scss'

const Filter = () => {
  return (
    <div class="sidebar__filter">
        <div class="section-title">
            <h4>Shop by price</h4>
        </div>
        <div class="filter-range-wrap">
            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
            data-min="33" data-max="99"></div>
            <div class="range-slider">
                <div class="price-input">
                    <p>Price:</p>
                    <input type="text" id="minamount"/>
                    <input type="text" id="maxamount"/>
                </div>
            </div>
        </div>
        <a href="#">Filter</a>
    </div>
  )
}

export default Filter

import React from 'react'
import './Item.css'
import './Item.scss'


const Item = (props) => {
  return (
     <div class="col-lg-4 col-md-6">
        <div class="product__item">
            <div class="product__item__pic set-bg" style={{
                                    backgroundImage: `url(${props.image})`,
                                    backgroundPosition: 'top center',
                                }}>
                <div class="label new">New</div>
                <ul class="product__hover">
                    <li><a href="img/shop/shop-1.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                </ul>
            </div>
            <div class="product__item__text">
                <h6><a href={`/category/product/${props.id}`}>{props.name}</a></h6>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                </div>
                <div class="product__price">$ {props.price}</div>
            </div>
        </div>
    </div>
  )
}

export default Item

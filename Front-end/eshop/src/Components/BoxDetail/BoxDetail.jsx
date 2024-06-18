import React ,{useContext, useEffect, useState} from 'react'
import './BoxDetail.css'
const image1 = require('../Assets/img/product/details/thumb-1.jpg');
const image2 = require('../Assets/img/product/details/thumb-2.jpg');
const image3 = require('../Assets/img/product/details/thumb-3.jpg');
const image4 = require('../Assets/img/product/details/thumb-4.jpg');
const product1 = require('../Assets/img/product/details/product-1.jpg');
const product2 = require('../Assets/img/product/details/product-2.jpg');
const product3 = require('../Assets/img/product/details/product-3.jpg');
const product4 = require('../Assets/img/product/details/product-4.jpg');

const BoxDetail = (props) => {
    const urlAddToCart = "http://localhost:8080/api/v1/user/cart/add";
    const {product,color,option ,size} = props
    const [pro,setpro] = useState({})
    const [form, setForm] = useState({
        cartid: '1ea21f2c-19a9-48a4-83ad-a0f3610741d2',
        productid: product.id,
        productname: product.name,
        colorid: '',
        sizeid: '',
        quantity: '1',
        price: product.price,
        image: product.thumnailimage
    });
    // console.log(form)
    const handleColorClick = (colorId) => {
        setForm({ ...form, colorid: colorId });
    };
    const changeHandler = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }
    const handleSizeClick = (sizeId) => {
        setForm({ ...form, sizeid: sizeId });
    };

    useEffect(() => {
        if (form.colorid != '' && form.sizeid != '') {
            const selectedOption = option.filter(item => item.colorId === form.colorid && item.sizeId === form.sizeid);
            if (selectedOption) {
                setpro(selectedOption[0])
                
            }
        }
    }, [form.colorid, form.sizeid]);
    console.log(pro)

    const addToCart =async () => {
        // const aa =await addCart(urlAddToCart,form);
        // setmesage(aa.message)
        setTimeout(() => {
            // setmesage("")
        }, 1000);
    }


  return (
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__left product__thumb nice-scroll">
                            
                            {/* <a class="pt active" href="#product-1">
                                <img src={image1} alt=""/>
                            </a> */}
                            {/* <a class="pt" href="#product-2">
                                <img src={image2} alt=""/>
                            </a>
                            <a class="pt" href="#product-3">
                                <img src={image3} alt=""/>
                            </a>
                            <a class="pt" href="#product-4">
                                <img src={image4} alt=""/>
                            </a> */}
                        </div>
                        <div class="product__details__slider__content">
                            <div class="">
                                {/* <img data-hash="product-1" class="product__big__img" src={product1} alt=""/>
                                <img data-hash="product-2" class="product__big__img" src={product2} alt=""/>
                                <img data-hash="product-3" class="product__big__img" src={product3} alt=""/>
                                <img data-hash="product-4" class="product__big__img" src={product4} alt=""/> */}
                                {pro.image?<img src={pro.image} style={{width :'100%'}}/> : <img style={{width :'100%'}} src={product.thumnailimage}/>}
                                {/* <img src={product.thumnailimage}/> */}
                               
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3>{product.name} <span>Brand: {product.brandName}</span></h3>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <span>( 138 reviews )</span>
                        </div>
                        <div class="product__details__price">{pro.price? `$${pro.price}` : '$54'}</div>
                        <p>{product.description}</p>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantity:</span>
                                <div class="pro-qty">
                                    <input type="text" name='quantity' value={form.quantity} onChange= {changeHandler} />
                                </div>
                            </div>
                            <a href="#" class="cart-btn"><span class="icon_bag_alt"></span> Add to cart</a>
                            <ul>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_adjust-horiz"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>Availability:</span>
                                    <div class="stock__checkbox">
                                        <label for="stockin">
                                            {pro?pro.quantity:<></>} In Stock
                                            {/* <input type="checkbox" id="stockin"/> */}
                                            {/* <span class="checkmark"></span> */}
                                        </label>
                                    </div>
                                </li>
                                {color?
                                <li>
                                    <span>Available color:</span>
                                    <div class="color__checkbox">
                                        {color.map((item)=>{
                                            return  <label for={item.name}>
                                                        <input type="radio" name="color__radio"  onClick={()=>{ handleColorClick(item.id);}} id={item.name}/>
                                                        <span class={`checkmark ${item.name}`}></span>
                                                    </label>
                                        })}
                                    </div>
                                </li>
                                :<></> }
                                {size ?
                                <li>
                                    <span>Available size:</span>
                                    <div class="size__btn">
                                        {size.map((item)=>{
                                        return  <label for={item.id} onClick={()=>{handleSizeClick(item.id)}} >
                                                    <input type="radio" id={item.id} />
                                                    {item.name}
                                                </label>
                                        })}
                                       
                                    </div>
                                </li>
                                :<></>}
                                <li>
                                    <span>Promotions:</span>
                                    <p>Free shipping</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews ( 2 )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>Description</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <h6>Specification</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <h6>Reviews ( 2 )</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="related__title">
                        <h5>RELATED PRODUCTS</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/product/related/rp-1.jpg">
                            <div class="label new">New</div>
                            <ul class="product__hover">
                                <li><a href="img/product/related/rp-1.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Buttons tweed blazer</a></h6>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product__price">$ 59.0</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/product/related/rp-2.jpg">
                            <ul class="product__hover">
                                <li><a href="img/product/related/rp-2.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Flowy striped skirt</a></h6>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product__price">$ 49.0</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/product/related/rp-3.jpg">
                            <div class="label stockout">out of stock</div>
                            <ul class="product__hover">
                                <li><a href="img/product/related/rp-3.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Cotton T-Shirt</a></h6>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product__price">$ 59.0</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/product/related/rp-4.jpg">
                            <ul class="product__hover">
                                <li><a href="img/product/related/rp-4.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Slim striped pocket shirt</a></h6>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product__price">$ 59.0</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
  )
}

export default BoxDetail

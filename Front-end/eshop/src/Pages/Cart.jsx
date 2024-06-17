import React from 'react'
import Breadcrum from '../Components/Breadcrum/Breadcrum'
import CartItem from '../Components/CartItem/CartItem'

const Cart = () => {
  return (
    <div>
      <Breadcrum param={'Cart'}/>
      <CartItem/>
    </div>
  )
}

export default Cart

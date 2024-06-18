import React, { useEffect, useState } from 'react'
import Breadcrum from '../Components/Breadcrum/Breadcrum'
import CartItem from '../Components/CartItem/CartItem'

const Cart = () => {
  const userid = localStorage.getItem('userid');
  const url = `http://localhost:8080/api/v1/user/cart/${userid}`
  const [cartItem,setCartItem] = useState([])

  const fetchhandle = async(url) => {
    return await (await fetch(url)).json();
  }

   useEffect(()=>{

    const fetchCartitem = async()=>{
      const cartitem = await fetchhandle(url);
      setCartItem(cartitem.result)
    }

    fetchCartitem();

  },[])

  if(!userid){
     window.location.replace('/login')
     return;
  }
 
  
  return (
    <div>
      <Breadcrum param={'Cart'}/>
      <CartItem cartitem={cartItem}/>
    </div>
  )
}

export default Cart

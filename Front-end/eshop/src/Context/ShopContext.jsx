import React, { createContext, useEffect, useState } from 'react'

export const Context = createContext()

const ShopContext = (props) => {
    const userid = localStorage.getItem('userid')
    const url = 'http://localhost:8080/api/v1/product/all'
    const urlcart = `http://localhost:8080/api/v1/user/cart/cart/${userid}`
    const [allproduct, setallproduct] = useState([]);
    const [cart,setCart] =useState([])
    const fetchhandle = async (url) => {
        return await (await fetch(url)).json();
    };
    
    useEffect(() => {
        const fetchProducts = async () => {
            const products = await fetchhandle(url);
             if(userid){
              const cart = await fetchhandle(urlcart);
              setCart(cart)
            }
            setallproduct(products.result);
        };
        
        fetchProducts();
    }, []);
   
    const contextValue = {allproduct,cart}


  return (
    <Context.Provider value={contextValue}>
       {props.children}
    </Context.Provider>
  )
}

export default ShopContext

import React, { createContext, useEffect, useState } from 'react'

export const Context = createContext()

const ShopContext = (props) => {
    const url = 'http://localhost:8080/api/v1/product/all'
    const [allproduct, setallproduct] = useState([]);

    const getAllProduct = async (url) => {
        return await (await fetch(url)).json();
    };
    
    useEffect(() => {
        const fetchProducts = async () => {
            const products = await getAllProduct(url);
            setallproduct(products.result);
        };
        
        fetchProducts();
    }, []);
   
    const contextValue = {allproduct}


  return (
    <Context.Provider value={contextValue}>
       {props.children}
    </Context.Provider>
  )
}

export default ShopContext

import React, { useEffect, useState } from 'react'
import Breadcrum from '../Components/Breadcrum/Breadcrum'
import { useParams } from 'react-router-dom'
import BoxDetail from '../Components/BoxDetail/BoxDetail'

const ProductDetail = () => {
    const {id} = useParams()
    const userid = localStorage.getItem('userid')
    const urlOption = `http://localhost:8080/api/v1/product/stocks/${id}`;
    const urlColor = `http://localhost:8080/api/v1/product/colors/${id}`
    const urlSize = `http://localhost:8080/api/v1/product/sizes/${id}`
    const urlcart = `http://localhost:8080/api/v1/user/cart/cart/${userid}`
    const url = `http://localhost:8080/api/v1/product/get/${id}`
   
    const [product,setproduct] = useState({})
    const [option, setoption] = useState([])
    const [size,setSize] = useState([])
    const [color,setColor] =useState([])
    const [cart,setCart] =useState([])
    const fetchhandle = async (url) => {
        return (await fetch(url)).json();
    }
    useEffect(() =>{
        const fetc =async () =>{
            const product = await fetchhandle(url)
            const option = await fetchhandle(urlOption);
            const color = await fetchhandle(urlColor);
            const Size = await fetchhandle(urlSize);
            if(userid){
              const cart = await fetchhandle(urlcart);
              setCart(cart)
            }
            setproduct(product.result)
            setoption(option);
            setColor(color.result)
            setSize(Size.result)
            
        }
        fetc()
    },[])
    return (

    <div>
      <Breadcrum category={product.categoryName} product = {product.name} param ={'Shop'}/>
      <BoxDetail product={product} option={option.result} color={color} size={size} cart={cart}/>
    </div>
  )
}

export default ProductDetail

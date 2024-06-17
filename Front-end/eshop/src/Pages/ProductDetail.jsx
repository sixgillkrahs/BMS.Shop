import React, { useEffect, useState } from 'react'
import Breadcrum from '../Components/Breadcrum/Breadcrum'
import { useParams } from 'react-router-dom'
import BoxDetail from '../Components/BoxDetail/BoxDetail'

const ProductDetail = () => {
    const {id} = useParams()
    const url = `http://localhost:8080/api/v1/product/get/${id}`
    const [product,setproduct] = useState({})
    const getproductbyid = async(url) => {
        return await ( await fetch(url)).json();
    }
    useEffect(() =>{
        const fetchgetproduct =async () =>{
            const product = await getproductbyid(url)
            setproduct(product.result)
        }
        fetchgetproduct()
    },[])
    return (

    <div>
      <Breadcrum category={product.categoryName} product = {product.name}/>
      <BoxDetail product={product}/>
    </div>
  )
}

export default ProductDetail

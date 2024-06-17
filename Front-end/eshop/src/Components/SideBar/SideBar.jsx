import React from 'react'
import './SideBar.css'
import './SideBar.scss'
import Category from '../Category-SideBar/Category'
import Filter from '../Filter-SideBar/Filter'
import Size from '../Size-SideBar/Size'


const SideBar = () => {
  return (
    <div className='shop__sidebar'>
       <Category/>
       <Filter/>
       <Size/>
    </div>
  )
}

export default SideBar

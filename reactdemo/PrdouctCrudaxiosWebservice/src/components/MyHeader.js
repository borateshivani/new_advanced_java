import React from 'react'
import './MyHeader.css';
export default function MyHeader() {
    console.log("in header component function")
  return (
    <div>
        <h1 style={{'border':'2px solid red','borderRadius':'20px',"paddingLeft":"200px"}}>Product category Management Service
         </h1>
    </div>
  )
}

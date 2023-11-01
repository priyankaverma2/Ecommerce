import React from 'react';
import { useState } from "react"
import {  useNavigate } from "react-router-dom"
import axios from "axios";


export function AddProduct(){
    
    let [productName,setProductName] = useState('');
    let[productPrice,setProductPrice] = useState('');
    let [productQuantity,setProductQuantity] = useState('');

    let navigate = useNavigate();
    let handleSubmit=(e) => {
      e.preventDefault();
      let product={"productName":productName,"productPrice":productPrice,"productQuantity":productQuantity};
      let url = /*'http://localhost:9093/api/saveprofile';*/
      axios.post(url,product)
      .then(response=>console.log(response))
      .catch(err=>console.log(err));
    }
    return (
        <div className='container'>
            <h3>Add Product Form</h3><hr />
            <form onSubmit={handleSubmit}>
                <div className='w-25'>
                    <label>Enter Product Name</label>
                    <input type='text'></input>
                </div><br />
                <div className='w-25'>
                    <label>Product Price</label><br />
                    <input type='number'></input>
                </div><br />
                <div className='w-25'>
                    <label>Product Quantity</label>
                    <input type='number'></input>
                </div><br />
            </form>
            <div className='w-25'><input type='submit' value='Save'></input></div>
      </div>
    )
  
  }
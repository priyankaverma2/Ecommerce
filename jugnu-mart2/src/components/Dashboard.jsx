import React from 'react'
import { Navbar } from './Navbar'
import { Route,Routes } from 'react-router-dom';
import ProductList from './ProductList';

function Dashboard() {
  return (<>
    <div>
        <Navbar />
    </div>
    <ProductList />
    </>
  )
}

export default Dashboard
import React from 'react';
import { useState } from "react"
import {  useNavigate } from "react-router-dom"
import { AddProduct } from './AddProduct';
import axios from "axios";
import {
BsCart3, BsGrid1X2Fill, BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill,
BsListCheck, BsMenuButtonWideFill, BsFillGearFill
}
    from 'react-icons/bs';
import { FaBeer } from 'react-icons/fa';




  

function Sidebar({ openSidebarToggle, OpenSidebar }) {
    return (
        <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive" : ""}>
            <div className='sidebar-title'>
                <div className='sidebar-brand'>
                    <BsCart3 className='icon_header' /> Shop
                </div>
                <span className='icon close_icon' onClick={OpenSidebar}>X</span>
            </div>

            <ul className='sidebar-list'>
            <li className='sidebar-list-item'>
                    <a href="/addProduct">
                        <BsGrid1X2Fill className='icon' /> Add Product
                    </a>
                </li>
                
                <li className='sidebar-list-item'>
                    <a href="/deleteProduct">
                        <BsFillArchiveFill className='icon' />Delete Products
                    </a>
                </li>
                <li className='sidebar-list-item'>
                    <a href="/updateProduct">
                        <BsFillGrid3X3GapFill className='icon' /> Update Product
                    </a>
                </li>
                <li className='sidebar-list-item'>
                    <a href="/viewrequesst">
                        <BsListCheck className='icon' /> View Request
                    </a>
                </li>
                <li className='sidebar-list-item'>
                    <a href="/AddEmployee">
                        < BsPeopleFill className='icon' /> Add Employee
                    </a>
                </li>
                <li className='sidebar-list-item'>
                    <a href="/deleteEmployee">
                        <BsMenuButtonWideFill className='icon' /> Delete Employee
                    </a>
                </li>
                <li className='sidebar-list-item'>
                    <a href="">
                        <BsFillGearFill className='icon' /> Generate Reports
                    </a>
                </li>

                <li className='sidebar-list-item'>
                    <a href="">
                        <FaBeer className='icon' /> Logout
                    </a>
                </li>
            </ul>
        </aside>
    )
}

export default Sidebar
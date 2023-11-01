import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './component/Profile';
import Header from './component/Header';
import Sidebar from './component/Sidebar';
import Home from './component/Home';
import './App.css'
import { AddProduct } from './component/AddProduct';
import DeleteProduct from './component/DeleteProduct';
import AddEmployee from './component/AddEmployee';
import UpdateProduct from './component/UpdateProduct';
import ViewRequest from './component/ViewRequest';
import DeleteEmployee from './component/DeleteEmployee';

function App() {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);
  const [authenticated, setAuthenticated] = useState(false);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

  return (
    <Router>
      <div className="grid-container">
        <Routes>
          {authenticated ? (
            <Route
              path="/adminView"
              element={
                <>
                  <Header OpenSidebar={OpenSidebar} />
                  <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar} />
                  <Home />
              
                </>
              }
            />
          ) : (
            <>
              <Route path="/*" element={<Login setAuthenticated={setAuthenticated} />} />
              <Route path='/addProduct' element={<AddProduct/>}></Route>
              <Route path='/deleteProduct' element={<DeleteProduct/>}></Route>
              <Route path='/AddEmployee' element={<AddEmployee/>}></Route>
              <Route path='/updateProduct' element={<UpdateProduct/>}></Route>
              <Route path='/viewrequesst' element={<ViewRequest/>}></Route>
              <Route path='/deleteEmployee' element={<DeleteEmployee/>}></Route>
              
            </>
          )}
        </Routes>
      </div>
    </Router>
  );
}

export default App;

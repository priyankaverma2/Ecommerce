import './App.css';
import { Navbar } from './components/Navbar';
import ProductList from './components/ProductList';
import Orders from './components/Orders';
import { Login,AdminLogin,EmployeeLogin,UserLogin,UserRegister } from './pages/login/Login';
import { Route,Routes } from 'react-router-dom';
import Dashboard from './components/Dashboard';

function App() {
  return (
    <div className="App">

      <Routes>
        <Route path='' element={<Login />} />
        <Route path='/login' element={<Login />} />
        <Route path='/login/adminLogin' element={<AdminLogin />} />
        <Route path='/login/employeeLogin' element={<EmployeeLogin />} />
        <Route path='/login/userLogin' element={<UserLogin />} />
        <Route path='/login/userRegister' element={<UserRegister />} />
        <Route path='/dashboard' element={<Dashboard />}></Route>
      </Routes>

    </div>
  );
}

export default App;
      // <Routes>
      //   <Route path='*' element={<Login />} />
      //   <Route path='/login' element={<Login />} />
      //   <Route path='/login/adminLogin' element={<AdminLogin />} />
      //   <Route path='/login/employeeLogin' element={<EmployeeLogin />} />
      //   <Route path='/login/userLogin' element={<UserLogin />} />
      //   <Route path='/login/userRegister' element={<UserRegister />} />
      // </Routes>

      // <Route path='' element={<ProductList />} />
// <Route path='/orders' element={<Orders />} />

// <Route path='/login' element={<Login />} />
// <Route path='/login/adminLogin' element={<AdminLogin />} />
// <Route path='/login/employeeLogin' element={<EmployeeLogin />} />
// <Route path='/login/userLogin' element={<UserLogin />} />
// <Route path='/login/userRegister' element={<UserRegister />} />
import React, { useState } from 'react';
import { Link } from 'react-router-dom';



export function Login() {
    return (
        <div className="container d-flex justify-content-center align-items-center vh-100">
            <div className="text-center w-50">
                <h1 className="mb-4">Welcome to Jugnu Mart</h1>
                <div className="row">
                    <div className="col-md-4">
                        <Link to='/login/adminLogin' className="btn btn-primary btn-lg btn mb-3">Admin Login</Link>
                    </div>
                    <div className="col-md-4">
                        <Link to='/login/employeeLogin' className="btn btn-primary btn-lg btn btn mb-3">Employee Login</Link>
                    </div>
                    <div className="col-md-4">
                        <Link to='/login/userLogin' className="btn btn-primary btn-lg btn mb-3">User Login</Link>
                    </div>
                </div>
            </div>
        </div>
    );
}


export function AdminLogin() {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form submitted:', formData);
    };

    return (
        <div className="container mt-5 px-5" style={{ maxWidth: '1000px', margin: "0 auto" }}>
            <h2 className="text-center mb-4">Admin Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Admin Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Admin Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary btn-lg btn-block">Login</button>
            </form>
        </div>
    );
};


export function EmployeeLogin() {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form submitted:', formData);
    };

    return (
        <div className="container mt-5 px-5" style={{ maxWidth: '1000px', margin: "0 auto" }}>
            <h2 className="text-center mb-4">Employee Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Employee Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Employee Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary btn-lg btn-block">Login</button>
            </form>
        </div>
    );
};


export function UserRegister() {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        phone: '',
        dob: '',
        address: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Add your registration logic here
        console.log('Form submitted:', formData);
    };

    return (
        <div className="container mt-5 px-5" style={{ maxWidth: '1000px', margin: "0 auto" }}>
            <h2 className="text-center mb-4">User Registration</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="firstName" className="form-label">First Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="firstName"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="lastName" className="form-label">Last Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="lastName"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="phone" className="form-label">Phone</label>
                    <input
                        type="tel"
                        className="form-control"
                        id="phone"
                        name="phone"
                        value={formData.phone}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="dob" className="form-label">Date of Birth</label>
                    <input
                        type="date"
                        className="form-control"
                        id="dob"
                        name="dob"
                        value={formData.dob}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="address" className="form-label">Address</label>
                    <input
                        type="text"
                        className="form-control"
                        id="address"
                        name="address"
                        value={formData.address}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary btn-lg btn-block">Register</button>
                <div className="text-center mt-3">
                    <Link to='/login/userLogin'
                        type="button"
                        className="btn btn-link"
                    >
                        Login
                    </Link>
                </div>
            </form>
        </div>
    );
};



export function UserLogin() {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Add your login logic here
        console.log('Form submitted:', formData);
    };

    return (
        <div className="container mt-5 px-5" style={{ maxWidth: '1000px', margin: "0 auto" }}>
            <h2 className="text-center mb-4">User Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">User Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">User Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary btn-lg btn-block">Login</button>
                <div className="text-center mt-3">
                    <div className='d-flex'>
                        <Link to='/login/userRegister'
                            type="button"
                            className="btn btn-link"
                        >
                            Regsiter
                        </Link>

                        <button data-bs-toggle="modal" data-bs-target="#raiseTicket" className="btn btn-dark">Raise Ticket</button>
                    </div>

                    <div className="modal fade" id="raiseTicket" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">Edit Profile</h5>
                                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div className="modal-body">
                                    <DescriptionForm />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};


export function DescriptionForm() {
    const [description, setDescription] = useState('');
    const [email, setEmail] = useState('');

    const handleChange = (e) => {
        setDescription(e.target.value);
    };

    const handleEmail = (e) => {
        setEmail(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(description);
        console.log(email);
    };

    return (
        <div className="container">

            <div className="mb-3">
                <label htmlFor="email" className="form-label">Email</label>
                <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    value={email}
                    onChange={handleEmail}
                />
            </div>

            <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea
                    className="form-control"
                    id="description"
                    name="description"
                    onChange={handleChange}
                    rows="4"
                />
            </div>
            <button type="button" className="btn btn-primary" onClick={handleSubmit}>Submit</button>
        </div>
    );
}



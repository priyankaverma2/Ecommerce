import { Link, Outlet } from 'react-router-dom';
import { Cart } from './Cart';
import Profile from './Profile';
import Orders from './Orders';

export function Navbar() {
    return (<>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark navbar-position">
            <div className="container">
                <Link to="/" className="navbar-brand">Jugnu Mart</Link>

                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <button data-bs-toggle="modal" data-bs-target="#Cart" className="nav-link">Cart</button>
                        </li>
                        <li className="nav-item">
                            <button data-bs-toggle="modal" data-bs-target="#Profile" className="nav-link">Edit Profile</button>
                        </li>
                        <li className="nav-item">
                            <button data-bs-toggle="modal" data-bs-target="#Orders" className="nav-link">Orders</button>
                        </li>
                        <li className="nav-item">
                            <button className="nav-link">Wallet Balance : 902.0 rs</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div className="modal fade" id="Cart" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Cart</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <Cart />
                    </div>
                </div>
            </div>
        </div>


        <div className="modal fade" id="Profile" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Edit Profile</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <Profile />
                    </div>
                </div>
            </div>
        </div>

        <div className="modal fade" id="Orders" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog modal-dialog2">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Orders</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <Orders />
                    </div>
                </div>
            </div>
        </div>
    </>

    );
}

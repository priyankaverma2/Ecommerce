import React from 'react';

export function Cart() {

    const handleCheckout = () => {
        alert('Thank you for your purchase!');
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Image</th>
                                <th scope="col">Name</th>
                                <th scope="col">Category</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="logo192.png" alt="" width="40px" /></td>
                                <td>Shoes</td>
                                <td>Footwear</td>
                                <td>2</td>
                                <td>2000.0</td>
                                <td><button className='btn btn-danger'>Delete</button></td>
                            </tr>
                            <tr>
                                <td><img src="logo192.png" alt="" width="40px" /></td>
                                <td>Pen</td>
                                <td>Stationary</td>
                                <td>10</td>
                                <td>50.0</td>
                                <td><button className='btn btn-danger'>Delete</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div className="d-flex align-items-end justify-content-between">
                <h6 className='text-muted'>Total Amount: 2050.0</h6>
                    <button className="btn btn-success" onClick={handleCheckout}>
                        Checkout
                    </button>
                </div>
            </div>
        </div>
    );
}

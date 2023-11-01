import React from 'react';

function ProductList() {
    const products = [
        {
            id: 1,
            name: 'Product 1',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 50.00,
            category: 'Category A',
            image: 'https://via.placeholder.com/50',
        },
        {
            id: 2,
            name: 'Product 2',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 70.00,
            category: 'Category B',
            image: 'https://via.placeholder.com/50',
        },
        {
            id: 3,
            name: 'Product 3',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 90.00,
            category: 'Category C',
            image: 'https://via.placeholder.com/50',
        },
        {
            id: 4,
            name: 'Product 1',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 50.00,
            category: 'Category A',
            image: 'https://via.placeholder.com/50',
        },
        {
            id: 5,
            name: 'Product 2',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 70.00,
            category: 'Category B',
            image: 'https://via.placeholder.com/50',
        },
        {
            id: 6,
            name: 'Product 3',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut placerat libero. Sed rhoncus dapibus tincidunt.',
            amount: 90.00,
            category: 'Category C',
            image: 'https://via.placeholder.com/50',
        },
    ];

    return (
        <div className="container" style={{ margin: '100px auto' }}>
            <div className="row mt-5">
                {products.map(product => (
                    <div key={product.id} className="col-md-3 mb-4">
                        <div className="card">
                            <img src={product.image} className="card-img-top" alt={product.name} />
                            <div className="card-body">
                                <h5 className="card-title">{product.name}</h5>
                                <p className="card-text">{product.description}</p>
                                <p className="card-text"><strong>Amount:</strong> ${product.amount}</p>
                                <p className="card-text"><strong>Category:</strong> {product.category}</p>
                                <a href="#" className="btn btn-primary">Add to Cart</a>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProductList;

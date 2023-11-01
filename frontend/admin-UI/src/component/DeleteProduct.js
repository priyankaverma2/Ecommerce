import React, { useState } from 'react';

function DeleteProduct() {
  // Sample product data
  const [products, setProducts] = useState([
    { id: 1, name: 'Product 1', price: 10000 },
    { id: 2, name: 'Product 2', price: 19000 },
    { id: 3, name: 'Product 3', price: 50987},
    // Add more product objects as needed
  ]);

  const handleDelete = (productId) => {
    // Function to delete a product by its ID
    const updatedProducts = products.filter((product) => product.id !== productId);
    setProducts(updatedProducts);
  };

  return (
    <div className='container'>
      <h3>Delete Product</h3>
      <hr />
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>${product.price.toFixed(2)}</td>
              <td>
                <button onClick={() => handleDelete(product.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DeleteProduct;

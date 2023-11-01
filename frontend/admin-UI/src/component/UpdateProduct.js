import React, { useState } from 'react';

function UpdateProduct() {
  // Sample product data
  const [products, setProducts] = useState([
    { id: 1, name: 'Product 1', price: 10.99 },
    { id: 2, name: 'Product 2', price: 19.99 },
    { id: 3, name: 'Product 3', price: 5.99 },
    // Add more product objects as needed
  ]);

  const [selectedProduct, setSelectedProduct] = useState(null);
  const [updatedProductName, setUpdatedProductName] = useState('');
  const [updatedProductPrice, setUpdatedProductPrice] = useState('');

  const handleUpdateClick = (product) => {
    setSelectedProduct(product);
    setUpdatedProductName(product.name);
    setUpdatedProductPrice(product.price);
  };

  const handleSaveUpdate = () => {
    // Here, you can update the product data with the new values.
    const updatedProducts = products.map((product) =>
      product.id === selectedProduct.id
        ? { ...product, name: updatedProductName, price: updatedProductPrice }
        : product
    );
    setProducts(updatedProducts);
    setSelectedProduct(null);
  };

  return (
    <div className='container'>
      <h3>Update Product</h3>
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
              <td>
                {selectedProduct && selectedProduct.id === product.id ? (
                  <input
                    type='text'
                    value={updatedProductName}
                    onChange={(e) => setUpdatedProductName(e.target.value)}
                  />
                ) : (
                  product.name
                )}
              </td>
              <td>
                {selectedProduct && selectedProduct.id === product.id ? (
                  <input
                    type='number'
                    value={updatedProductPrice}
                    onChange={(e) => setUpdatedProductPrice(e.target.value)}
                  />
                ) : (
                  `$${product.price.toFixed(2)}`
                )}
              </td>
              <td>
                {selectedProduct && selectedProduct.id === product.id ? (
                  <button onClick={handleSaveUpdate}>Save</button>
                ) : (
                  <button onClick={() => handleUpdateClick(product)}>Update</button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UpdateProduct;

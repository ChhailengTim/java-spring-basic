package com.example.customers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<ProductModel> addProduct(ProductModel productModel) {
        productRepository.save(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Customer with Id " + productId + " not exists");
        }
          productRepository.deleteById(productId);
          return new ResponseEntity<>("Product with "+productId+" was deleted",HttpStatus.OK);
    }


    public ResponseEntity<ProductModel> updateProduct(Long productId, ProductModel productDetail) {
        Optional<ProductModel> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            ProductModel updateProduct = optionalProduct.get();
            updateProduct.setName(productDetail.getName());
            updateProduct.setBrand(productDetail.getBrand());
            updateProduct.setYear(productDetail.getYear());
            ProductModel addUpdateProduct = productRepository.save(updateProduct);
            return ResponseEntity.ok(addUpdateProduct);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

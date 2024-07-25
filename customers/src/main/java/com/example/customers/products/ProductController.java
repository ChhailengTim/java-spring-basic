package com.example.customers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductModel> getProduct(){
        return productService.getProducts();
    }

    @PostMapping()
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel){
        return productService.addProduct(productModel);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductModel productDetail){
        return productService.updateProduct(productId, productDetail);
    }
}

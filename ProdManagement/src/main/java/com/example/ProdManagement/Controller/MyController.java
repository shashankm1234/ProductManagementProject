package com.example.ProdManagement.Controller;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> creatingProduct(@RequestBody ProductRequest productRequest){
        return productService.addingProduct(productRequest);
    }

    @GetMapping("/api/products")
    public List<ProductData> gettingAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public Optional<ProductData> gettingProductsById(@PathVariable("id") Integer productCode){
        return productService.getProductById(productCode);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<String> deletingProduct(@PathVariable("id") Integer productCode){
        productService.deleteProduct(productCode);
        return new ResponseEntity<String>("Product Deleted Successfully!",HttpStatus.OK);
    }

    @PutMapping("/api/products/{id}")
    public Optional<ProductData> updatingProduct(@PathVariable("id") Integer productCode, @RequestBody ProductRequest productRequest){
        return productService.updateProductData(productRequest,productCode);
    }

}
//    @GetMapping("/api/products/productName")
//    public List<ProductData> findProductByName(@PathVariable("name") String productName){
//        return productService.findByName(productName);
//    }

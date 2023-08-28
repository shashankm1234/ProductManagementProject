package com.example.ProdManagement.Service;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public ResponseEntity<ProductResponse> addingProduct(ProductRequest productRequest);

    List<ProductData> getAllProducts();
    Optional<ProductData> getProductById(Integer productCode);

    void deleteProduct(Integer productCode);

    Optional<ProductData> updateProductData(ProductRequest productRequest, Integer productCode);


//    List<ProductData> findByName(String productName);
}
package com.example.ProdManagement.Service.impl;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Data.Repository.ProductRepo;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    @Transactional
    public ResponseEntity<ProductResponse> addingProduct(ProductRequest productRequest) {
        ProductResponse productResponse=new ProductResponse();
        ProductData productData=new ProductData();
            productData.setProductName(productRequest.getProductName());
            productData.setProductDescription(productRequest.getProductDesc());
            productData.setProductType(productRequest.getProductType());
            productData.setIsActive(true);
            productData.setCreatedAt(new Date());
            productData.setModifiedAt(new Date());

            productRepo.save(productData);

            productResponse.setMessage("Product Saved Successfully");
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @Override
    public List<ProductData> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<ProductData> getProductById(Integer productCode) {
        return productRepo.findById(productCode);
    }

    @Override
    public void deleteProduct(Integer productCode) {
//        if(productRepo.existsById(productCode)) {
//            productRepo.deleteById(productCode);
//        }
//        else{
//            ProductResponse productResponse = new ProductResponse();
//            productResponse.setMessage("Product Code Invalid");
//        }

        productRepo.deleteById(productCode);
    }

    @Override
    public Optional<ProductData> updateProductData(ProductRequest productRequest, Integer productCode) {
        Optional<ProductData> existingData = productRepo.findById(productCode);
        existingData.get().setProductName(productRequest.getProductName());
        existingData.get().setProductDescription(productRequest.getProductDesc());
        existingData.get().setProductType(productRequest.getProductType());
        productRepo.save(existingData.get());
        return existingData;
    }

}
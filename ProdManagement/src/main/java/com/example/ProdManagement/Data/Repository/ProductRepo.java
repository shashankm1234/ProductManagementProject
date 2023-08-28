package com.example.ProdManagement.Data.Repository;

import com.example.ProdManagement.Data.Entity.ProductData;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Where()

@Repository
public interface ProductRepo extends JpaRepository<ProductData,Integer> {

//    @Query("select * from ProductData order by productName")
//    Optional<ProductData> findProductByName(String productName);
//
//    @Query("select * from ProductData order by productDescription")
//    Optional<ProductData> findProductByDescription(String productDescription);
//
//    @Query("select * from ProductData order by productType")
//    Optional<ProductData> findProductByType(String productType);
}
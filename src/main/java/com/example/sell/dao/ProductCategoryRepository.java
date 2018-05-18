package com.example.sell.dao;

import com.example.sell.bean.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//<bean类，主键>
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //In表示在里面的
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

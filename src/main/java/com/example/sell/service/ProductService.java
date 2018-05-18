package com.example.sell.service;

import com.example.sell.bean.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String proudectId);

    List<ProductInfo> findUpAll(); //上架商品列表

    Page<ProductInfo> findAll(Pageable pageable); //传入页码来查看

    ProductInfo save(ProductInfo productInfo);

    //加减库存



}

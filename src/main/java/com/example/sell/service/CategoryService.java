package com.example.sell.service;

import com.example.sell.bean.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    //接口方法默认强制为public abstract 不可换，写了也是多余
    //接口属性默认public static final
    public abstract List<ProductCategory> findAll();

    //上面是卖家端用接口，下面是买家端使用接口
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

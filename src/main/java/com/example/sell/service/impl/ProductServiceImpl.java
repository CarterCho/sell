package com.example.sell.service.impl;

import com.example.sell.bean.ProductInfo;
import com.example.sell.dao.ProductInfoRepository;
import com.example.sell.enums.ProductStatusEnum;
import com.example.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


//@Service  自动注入service的实例，可以直接调用service.抽象方法（），调用时自动注入实现类
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String proudectId) {
        return productInfoRepository.findOne(proudectId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        System.out.println("~~~~~~~~~~~~@@@@@@@~~~~~~~~~~");
        return productInfoRepository.findByProductStatus(ProductStatusEnum.up.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}

package com.example.sell.service.impl;

import com.example.sell.bean.ProductInfo;
import com.example.sell.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Test
    public void findOne() {
        ProductInfo productInfo = productServiceImpl.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productServiceImpl.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        //不能实例化pageable对象传入，因为pageable是个接口
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productServiceImpl.findAll(request);
        //System.out.println("~~~~"+productInfos.getTotalElements());
        Assert.assertEquals(2,productInfos.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("牛肉面");
        productInfo.setProductPrice(new BigDecimal(7.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("good taste");
        productInfo.setProductIcon("www.XXX.jpg");
        productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
        productInfo.setCategoryType(6);
        ProductInfo result = productServiceImpl.save(productInfo);
        Assert.assertNotNull(result);
    }
}
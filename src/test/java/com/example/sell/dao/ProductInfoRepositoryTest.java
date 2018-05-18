package com.example.sell.dao;

import com.example.sell.bean.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public  void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("牛肉面");
        productInfo.setProductPrice(new BigDecimal(7.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("good taste");
        productInfo.setProductIcon("www.XXX.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(6);
        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }



    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertEquals(1,productInfos.size());
    }
}
package com.example.sell.dao;

import com.example.sell.bean.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne(){
        ProductCategory productCategory=productCategoryRepository.findOne(2);
        log.error("～～～～～"+productCategory.toString());

    }

    //@Transactional表示测试后撤销数据库修改记录，不修改数据库
    @Test
    @Transactional
    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory();
//        //一般更新的时候采用
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("价格榜单");
//        productCategory.setCategoryType(3);
//        productCategoryRepository.save(productCategory);


        //若做出修改和原数据一致比如categoryType都是11时会使得修改失效，啥都不改，导致时间不会修改
        //ProductCategory productCategory = productCategoryRepository.findOne(2);
        //productCategory.setCategoryType(11);
        //productCategoryRepository.save(productCategory);

        ProductCategory productCategory = new ProductCategory(23,"周末热卖");
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(9,19,55);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}
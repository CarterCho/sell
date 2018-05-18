package com.example.sell.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    //都遵循驼峰式命名法让Spring自动映射到属性
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;//商品库存

    private  String productDescription;

    private  Integer productStatus;//0正常，1下架

    private String productIcon;

    private Integer categoryType;//商品类目编号，用来关联类目表




}

package com.example.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

//返回的商品类目对象
//自动生成getter setter tostring
@Data
public class ProductVO {

    //序列化本属性时名字改为name
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    //子对象确定是ProducInvoVO，本类不会复用，因此不用泛型直接定义
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;




}

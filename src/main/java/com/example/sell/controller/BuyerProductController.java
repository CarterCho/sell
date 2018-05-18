package com.example.sell.controller;

import com.example.sell.Util.ResultVOUtil;
import com.example.sell.VO.ProductInfoVO;
import com.example.sell.VO.ProductVO;
import com.example.sell.VO.ResultVO;
import com.example.sell.bean.ProductCategory;
import com.example.sell.bean.ProductInfo;
import com.example.sell.service.CategoryService;
import com.example.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//等价与@controller 加上@responsebody @responsyBody 将返回的对象转化成json字符串
// ，若是String则直接返回
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1。找出所有上架商品

        //调用接口去查询而不是实体类从而解耦
        List<ProductInfo> productInfoList = productService.findUpAll();

        /*List<Integer> categoryTypeList  = new ArrayList<>();

        productInfoList.forEach(productInfo -> categoryTypeList.add(productInfo.getCategoryType()));
        */

        //2。找出这些商品的类目信息 findByCategoryTypeIn用来返回上架商品的类目信息放到返回的类目信息中

        List<Integer> categoryTypeList = productInfoList.stream()
                                         .map(productInfo -> productInfo.getCategoryType())
                                         .collect(Collectors.toList());

        //findByCategoryTypeIn（{6,6}）返回只有一个category，只找在列表里有的Integer categoryType
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        System.out.println("~~"+productCategoryList);

        //3。拼装数据（即拼接对象，对象在注解@RestController下以json格式返回）成按类目分类的json格式
        // 每一个category  对应一个  productVo
        // 商品如果对应这个categorytype就将商品加入到这个productVO中
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList) {

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            //加入每个商品的productInfoVO
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo:productInfoList){
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //对🐘的属性拷贝赋值
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                System.out.println("~~"+productInfoVOList);
            }


            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        System.out.println("~~"+productVOList);

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("查询成功");
//        resultVO.setData(productVOList);
//将这种传入对象构造其他对象的过程抽象出来成为工具方法，从而增加可读性


        return ResultVOUtil.success(productVOList);
    }
}

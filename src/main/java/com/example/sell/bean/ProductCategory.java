package com.example.sell.bean;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//若表名不是product_category ,需要加上@Table(name="表名")注解，若是spring会自动识别表
//并且只要加上以下实体映射注解


//当bean对象中含有创建时间修改时间的时候，不加@DynamicUpdate 注解的话会查出已有的时间，并将查出的旧时间重新保存回去，导致
// 数据库中自动更新的时间不会修改
//@Data注解自动生成gettersetter以及toString方法  使得写起来很简洁
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    //属性名使用驼峰式写法 对应表名中属性category_id,下划线改成大写
    //此时会自动识别
    @Id
    @GeneratedValue
    private Integer categoryId;

    private Integer categoryType;

    private String categoryName;

    //构造方法无返回值     String str = new String("content"); 这里的new 是调用构造函数，
    // 在堆里分配了一个String对象，并让str指向这个对象。实际上是那个 new 在起作用，而不是()在起作用。
    //为什么构造函数没有返回值呢，主要是为了区分构造函数和其它方法。
    // 其实，你可以尝试在你的构造函数前加上void，你会发现编译可以通过，
    // 但是编译器把它认为是方法，而不是构造函数，当然也无法在new的时候自动调用
    public ProductCategory() {
    }

    public ProductCategory(Integer categoryType, String categoryName) {
        this.categoryType = categoryType;
        this.categoryName = categoryName;
    }

    //private Date createTime;

    //private Date updateTime;

//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public Integer getCategoryType() {
//        return categoryType;
//    }
//
//    public void setCategoryType(Integer categoryType) {
//        this.categoryType = categoryType;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductCategory{" +
//                "categoryId=" + categoryId +
//                ", categoryType=" + categoryType +
//                ", categoryName='" + categoryName + '\'' +
//                '}';
//    }
}

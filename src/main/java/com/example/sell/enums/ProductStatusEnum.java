package com.example.sell.enums;

import lombok.Getter;

//带构造器的枚举类
//up down是枚举累的构造实例
@Getter
public enum ProductStatusEnum {
    up(0,"在架"),
    Down(1,"下架");
    private Integer code;
    private String  message;


    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}

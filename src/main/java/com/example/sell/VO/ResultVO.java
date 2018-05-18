package com.example.sell.VO;

import lombok.Data;

import java.util.List;

//返回给前端的对象view object视图对象 都放到这个包下

//http请求返回的最外层对象
@Data
public class ResultVO<T> {
    private  Integer code; //错误码

    private String msg; //错误提示信息

    //T泛型可以传List 因此可以不写,为了复用resultVo 类，因此不定义data类型
    private T data;     //返回的具体类容


}

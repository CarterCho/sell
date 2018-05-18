package com.example.sell.enums;

public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANAEL(2,"取消"),
        ;

    private Integer code;
    private String message;

    //枚举构造器默认私有 ，可以胜略掉
   private OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }



    public String getMessage() {
        return message;
    }

}

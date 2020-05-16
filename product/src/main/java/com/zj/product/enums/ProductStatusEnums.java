package com.zj.product.enums;

import lombok.Getter;

@Getter
public enum  ProductStatusEnums {
    //商品状态.1-在售 2-下架 3-删除
    UP(1,"在售"),

    DOWN(2,"下架"),

    NO(3,"删除");

    private Integer code;
    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

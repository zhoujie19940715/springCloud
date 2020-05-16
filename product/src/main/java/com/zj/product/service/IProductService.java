package com.zj.product.service;

import com.zj.product.dataobject.Product;

import java.util.List;

public interface IProductService {
    //查询所有在家商品列表
    List<Product> findUpAll();
}

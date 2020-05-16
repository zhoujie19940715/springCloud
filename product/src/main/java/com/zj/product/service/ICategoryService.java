package com.zj.product.service;

import com.zj.product.dataobject.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findByIdIn(List<Integer> idList);
}

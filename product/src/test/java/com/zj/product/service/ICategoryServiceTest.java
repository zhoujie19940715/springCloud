package com.zj.product.service;

import com.zj.product.ProductApplicationTests;
import com.zj.product.dataobject.Category;
import com.zj.product.service.Impl.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ICategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ICategoryService categoryService;
    @Test
    public void findByIdIn() {
        List<Category> categoryList = categoryService.findByIdIn(Arrays.asList(100001, 100002));
        Assert.assertTrue(categoryList.size() > 0);
    }
}
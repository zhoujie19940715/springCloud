package com.zj.product.repository;

import com.zj.product.dataobject.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired CategoryRepository categoryRepository;

    @Test
    public void findByIdIn() {
        List<Category> categories = categoryRepository.findByIdIn(Arrays.asList(100001, 100002));
        Assert.assertTrue(categories.size()>0);
    }
}
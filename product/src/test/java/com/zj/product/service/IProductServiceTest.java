package com.zj.product.service;

import com.zj.product.ProductApplicationTests;
import com.zj.product.dataobject.Product;
import com.zj.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@Component
public class IProductServiceTest extends ProductApplicationTests {


    @Autowired
    private IProductService productService;
    @Test
    public void findUpAll() {
        List<Product> productList = productService.findUpAll();
        Assert.assertTrue(productList.size()>0);
    }
}
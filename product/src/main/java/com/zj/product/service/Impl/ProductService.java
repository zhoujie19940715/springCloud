package com.zj.product.service.Impl;

import com.zj.product.dataobject.Product;
import com.zj.product.enums.ProductStatusEnums;
import com.zj.product.repository.ProductRepository;
import com.zj.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findUpAll() {
        return productRepository.findProductByStatus(ProductStatusEnums.UP.getCode());
    }
}

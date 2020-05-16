package com.zj.product.repository;

import com.zj.product.dataobject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findProductByStatus(Integer status);

}

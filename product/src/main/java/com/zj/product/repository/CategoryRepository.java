package com.zj.product.repository;

import com.zj.product.dataobject.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByIdIn(List<Integer> idList);
}

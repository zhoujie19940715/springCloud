package com.zj.product.service.Impl;

import com.zj.product.dataobject.Category;
import com.zj.product.repository.CategoryRepository;
import com.zj.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("categoryService")
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findByIdIn(List<Integer> idList) {
        return categoryRepository.findByIdIn(idList);
    }
}

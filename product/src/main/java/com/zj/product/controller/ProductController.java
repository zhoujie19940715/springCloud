package com.zj.product.controller;

import com.netflix.discovery.converters.Auto;
import com.zj.product.dataobject.Category;
import com.zj.product.dataobject.Product;
import com.zj.product.service.ICategoryService;
import com.zj.product.service.IProductService;
import com.zj.product.vo.ProductListVo;
import com.zj.product.vo.ProductVo;
import com.zj.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list")
    public ResultVo<ProductVo> list(){

        List<Product> productList = productService.findUpAll();
        List<Integer> idList = productList.stream().
                map(Product::getCategoryId).
                collect(Collectors.toList());
        List<Category> categoryList = categoryService.findByIdIn(idList);
        //
        List<ProductVo> productVos = new ArrayList<>();
        for (Category category: categoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(category.getName());
            productVo.setId(category.getId());

            List<ProductListVo> productListVoList = new ArrayList<>();
            for (Product p: productList) {
                if(p.getCategoryId().equals(category.getId())){
                    ProductListVo productListVo = new ProductListVo();
                    BeanUtils.copyProperties(p,productListVo);
                    productListVoList.add(productListVo);
                }
            }
            productVo.setProductList(productListVoList);
            productVos.add(productVo);
        }
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(productVos);
        return  resultVo;
    }
}

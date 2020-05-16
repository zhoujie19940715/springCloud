package com.zj.product.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Table(name ="mmall_product")
@Entity
public class Product {
   @Id
   private Integer id;
   private Integer categoryId;
   private String name;
   private String subtitle;
   private String mainImage;
   private String subImages;
   private String detail;
   private BigDecimal price;
   private Double stock;
   private Integer status;
   private Date createTime;
   private Date updateTime;
}

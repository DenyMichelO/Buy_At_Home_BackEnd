package com.buyathome.backend.dao;

import com.buyathome.backend.dto.*;
import com.buyathome.backend.model.Brand;
import com.buyathome.backend.model.Product;
import com.buyathome.backend.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {

    public void createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public List<ProductCategory> getProductCategory(Integer categoryId);

    public List<ProductGetId>  getProductbyId(Integer productId);

    public List<ProductsGetAdmin> getProducts ();

    public List<ProductGetDetail> getProductDetail(Integer productId);

    public List<BrandGet> getBrand();

    public List<CategoryGet> getCategory();
}

package com.buyathome.backend.bl;

import com.buyathome.backend.dao.ProductDao;
import com.buyathome.backend.dao.TransactionDao;

import com.buyathome.backend.dto.*;
import com.buyathome.backend.model.Brand;
import com.buyathome.backend.model.Product;
import com.buyathome.backend.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao){
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public ProductAdd createProduct(ProductAdd productAdd, Product product, Brand brand, Tag tag, Transaction transaction){

        product.setBrandId(productAdd.getBrandId());
        product.setTagId(productAdd.getTagId());
        product.setProductName(productAdd.getProductName());
        product.setDetail(productAdd.getDetail());
        product.setModel(productAdd.getModel());
        product.setPrice(productAdd.getPrice());
        product.setDescription(productAdd.getDescription());
        product.setStock(productAdd.getStock());
        product.setStoreAvailable(productAdd.getStoreAvailable());
        product.setDeliveryAvailable(productAdd.getDeliveryAvailable());
        product.setImage(productAdd.getImage());
        product.setTxId(transaction.getTxId());
        product.setTxHost(transaction.getTxHost());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxDate(transaction.getTxDate());
        productDao.createProduct(product);
        return productAdd;
    }
    public ProductUpdate updateProduct(ProductUpdate productUpdate, Transaction transaction, Product product, Integer productId){
        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        product.setStock(productUpdate.getStock());
        product.setPrice(productUpdate.getPrice());
        product.setStoreAvailable(productUpdate.getStoreAvailable());
        product.setDeliveryAvailable(productUpdate.getDeliveryAvailable());
        productDao.updateProduct(product);

        return productUpdate;
    }

    public ProductDelete deleteProduct(ProductDelete productDelete, Transaction transaction, Product product, Integer productId){

        product.setTxStatus(productDelete.getTxStatus());
        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        productDao.deleteProduct(product);

        return productDelete;
    }

    public List<ProductGetId> getProductId(Integer productId)
    {

        return productDao.getProductbyId(productId);

    }

    public List<ProductsGetAdmin> getProducts()
    {
        return productDao.getProducts();
    }

    public List<ProductCategory> getProductCategory(Integer categoryId){
        return  productDao.getProductCategory(categoryId);
    }

    public List<ProductGetDetail> getProductDeatil(Integer productId)
    {
        return  productDao.getProductDetail(productId);
    }
    public List<BrandGet> getBrand(){
        return productDao.getBrand();
    }
    public List<CategoryGet> getCategory(){
        return productDao.getCategory();
    }

}

package com.buyathome.backend.api;

import com.buyathome.backend.bl.ProductBl;
import com.buyathome.backend.bl.TransactionBl;
import com.buyathome.backend.dto.*;
import com.buyathome.backend.model.Brand;
import com.buyathome.backend.model.Product;
import com.buyathome.backend.model.Tag;
import com.buyathome.backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductApi {
    private TransactionBl transactionBl;
    private ProductBl productBl;

    @Autowired
    public ProductApi(TransactionBl transactionBl,ProductBl productBl){
        this.transactionBl = transactionBl;
        this.productBl = productBl;
    }

    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ProductAdd createProduct(@Valid @RequestBody ProductAdd productAdd, Product product, Brand brand, Tag tag, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductAdd productResponse = productBl.createProduct(productAdd, product,brand,tag, transaction);
        return productResponse;
    }

    /*
    * Este Endpoint sirve para editar el precio y el stock de un porductos en la base de datos. utilizando como variable de busqueda el 'productId'.
    */
    @RequestMapping(value = "/{productId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ProductUpdate updateProduct(@Valid @RequestBody ProductUpdate productUpdate,Product product, HttpServletRequest request, @PathVariable int productId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductUpdate productResponse = productBl.updateProduct(productUpdate,transaction, product, productId);
        return productResponse;
    }
    /*
    * Este endpoint sirve para realizar el eliminado logico de un producto. Utilizando como variable 'productId'.
    */
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDelete deleteProduct (@RequestBody ProductDelete productDelete, Product product, HttpServletRequest request, @PathVariable int productId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductDelete productResponse = productBl.deleteProduct(productDelete, transaction, product, productId);
        return productResponse;
    }
    /*
    * Este endpoint sirve para mostra un producto. utilizando como variable de busqueda 'productId'.
    */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductGetId> getProductId(HttpServletRequest request, @PathVariable int productId ) {
        return productBl.getProductId(productId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductsGetAdmin> getProdducts(HttpServletRequest request){
        return productBl.getProducts();
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductCategory> getProductCategory(HttpServletRequest request, @PathVariable int categoryId ) {
        return productBl.getProductCategory(categoryId);
    }

    @RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductGetDetail> getProductDetail(HttpServletRequest request, @PathVariable int productId ) {
        return productBl.getProductDeatil(productId);
    }

    @RequestMapping(value = "/brand", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BrandGet> getBrand(HttpServletRequest request) {
        return productBl.getBrand();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CategoryGet> getCategory(HttpServletRequest request) {
        return productBl.getCategory();
    }
}

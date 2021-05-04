package com.buyathome.backend.dao;

import bo.ucb.edu.ingsoft.dto.CartGet;
import bo.ucb.edu.ingsoft.dto.CartGetDetail;
import bo.ucb.edu.ingsoft.model.Cart;
import bo.ucb.edu.ingsoft.model.CartDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {

    public void createCartDetail(CartDetail cartDetail);

    public List<CartGetDetail> getCartDetail();

    public List<CartGet> getCart(Integer cartId);

    public  void createCart(Cart cart);

    public void deleteCartDetail(Integer cartDetailId);

    public List<CartGet> getCart();

}

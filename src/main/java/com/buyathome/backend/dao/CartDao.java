package com.buyathome.backend.dao;

import com.buyathome.backend.dto.CartGet;
import com.buyathome.backend.dto.CartGetDetail;
import com.buyathome.backend.model.Cart;
import com.buyathome.backend.model.CartDetail;
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

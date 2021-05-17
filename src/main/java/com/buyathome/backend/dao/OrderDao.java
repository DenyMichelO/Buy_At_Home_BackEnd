package com.buyathome.backend.dao;

import com.buyathome.backend.model.Address;
import com.buyathome.backend.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    public void updateOrderState(Order order);

    public void updateOrderAddress(Order order);

    public void updateAddress(Address address, Integer orderId);

    public Integer selectAddressId(Integer orderId);

    public void createOrder(Order order);
}

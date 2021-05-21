package com.buyathome.backend.bl;

import com.buyathome.backend.dao.AddressDao;
import com.buyathome.backend.dao.OrderDao;
import com.buyathome.backend.dao.TransactionDao;
import com.buyathome.backend.dto.*;
import com.buyathome.backend.model.Address;
import com.buyathome.backend.model.Order;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class OrderBl {
    private OrderDao orderDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;
    private static final Logger LOGGER= LoggerFactory.getLogger(OrderBl.class);

    @Autowired
    public OrderBl(OrderDao orderDao,TransactionDao transactionDao, AddressDao addressDao){
        this.orderDao = orderDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }
    public Order updateOrderState (Order order, OrderState orderState, Transaction transaction, Integer orderId){
        order.setState(orderState.getState());
        order.setOrderId(orderId);
        order.setTxDate(transaction.getTxDate());
        order.setTxUserId(transaction.getTxUserId());
        order.setTxHost(transaction.getTxHost());
        order.setTxId(transaction.getTxId());
        orderDao.updateOrderState(order);
        return order;
    }

    public OrderAddress updateOrderAddress (Order order, OrderAddress orderAddress, Address address, Transaction transaction, Integer orderId){

        address.setNeighbourId(orderAddress.getNeighbourId());
        address.setStreet(orderAddress.getStreet());
        address.setNumber(orderAddress.getNumber());
        address.setReference(orderAddress.getReference());
        address.setTxDate(transaction.getTxDate());
        address.setTxId(transaction.getTxId());
        address.setTxHost(transaction.getTxHost());
        address.setTxUserId(transaction.getTxUserId());
        orderDao.updateAddress(address, orderId);


        return orderAddress;
    }

    public OrderAdd createOrder (OrderAdd orderAdd, Transaction transaction, Address address, Order order){

        address.setNeighbourId(orderAdd.getNeighbourId());
        address.setNumber(orderAdd.getNumber());
        address.setReference(orderAdd.getReference());
        address.setStreet(orderAdd.getStreet());
        address.setTxDate(transaction.getTxDate());
        address.setTxId(transaction.getTxId());
        address.setTxHost(transaction.getTxHost());
        address.setTxUserId(transaction.getTxUserId());
        addressDao.create(address);
        Integer getLastId = transactionDao.getLastInsertId();
        address.setAddressId(getLastId);

        order.setAddressId(getLastId);
        order.setState(orderAdd.getState());
        order.setCartId(orderAdd.getCartId());
        order.setStatus(orderAdd.getStatus());
        order.setTxDate(transaction.getTxDate());
        order.setTxId(transaction.getTxId());
        order.setTxHost(transaction.getTxHost());
        order.setTxUserId(transaction.getTxUserId());
        orderDao.createOrder(order);

        return orderAdd;

    }
}


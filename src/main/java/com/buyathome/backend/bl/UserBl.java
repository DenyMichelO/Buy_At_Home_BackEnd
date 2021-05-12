package com.buyathome.backend.bl;

import com.buyathome.backend.dao.UserDao;
import com.buyathome.backend.dao.TransactionDao;
import com.buyathome.backend.dao.AddressDao;

import com.buyathome.backend.dto.*;

import com.buyathome.backend.model.User;
import com.buyathome.backend.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {
    private UserDao userDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;

    @Autowired
    public UserBl(UserDao userDao, TransactionDao transactionDao, AddressDao addressDao){
        this.userDao = userDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }

    //Creacion de Usuarios conjunta con address
    public UserCreate createUser(UserCreate userCreate, User user, Transaction transaction, Address address){

        address.setNeighbourId(userCreate.getNeighbourId());
        address.setStreet(userCreate.getStreet());
        address.setNumber(userCreate.getNumber());
        address.setReference(userCreate.getReference());
        address.setTxDate(transaction.getTxDate());
        address.setTxId(transaction.getTxId());
        address.setTxHost(transaction.getTxHost());
        address.setTxUserId(transaction.getTxUserId());
        addressDao.create(address);
        Integer getLastId = transactionDao.getLastInsertId();
        address.setAddressId(getLastId);

        user.setFirstname(userCreate.getFirstname());
        user.setAddressId(address.getAddressId());
        user.setLastname(userCreate.getLastname());
        user.setPhone(userCreate.getPhone());
        user.setEmail(userCreate.getEmail());
        user.setPassword(userCreate.getPassword());
        user.setTxDate(transaction.getTxDate());
        user.setTxId(transaction.getTxId());
        user.setTxHost(transaction.getTxHost());
        user.setTxUserId(transaction.getTxUserId());
        userDao.create(user);
        user.setUserId(getLastId);

        return userCreate;
    }

    //Modificacion de datos de Usuarios conjunta con address
    public UserUpdate updateUser(UserUpdate userUpdate, User user, Transaction transaction, Address address, Integer userId){

        user.setUserId(userId);
        user.setFirstname(userUpdate.getFirstname());
        user.setLastname(userUpdate.getLastname());
        user.setPhone(userUpdate.getPhone());
        user.setEmail(userUpdate.getEmail());
        user.setTxDate(transaction.getTxDate());
        user.setTxId(transaction.getTxId());
        user.setTxHost(transaction.getTxHost());
        user.setTxUserId(transaction.getTxUserId());
        userDao.update(user);
        Integer adId = userDao.selectAddressId(userId);
        userUpdate.setAddressId(adId);

        address.setAddressId(userUpdate.getAddressId());
        address.setNeighbourId(userUpdate.getNeighbourId());
        address.setStreet(userUpdate.getStreet());
        address.setNumber(userUpdate.getNumber());
        address.setReference(userUpdate.getReference());
        address.setTxDate(transaction.getTxDate());
        address.setTxId(transaction.getTxId());
        address.setTxHost(transaction.getTxHost());
        address.setTxUserId(transaction.getTxUserId());
        addressDao.update(address);

        return userUpdate;

    }
    //Obtencion de respuesta GET
    public List<UserGet> findUserById(Integer userId){
        return userDao.findUserById(userId);
    }

    //Obtencion de respuesta GET de pedidos realizados
    public List<UserOrderGet> findOrdersByUserId(Integer userId){
        return userDao.findOrdersByUserId(userId);
    }

    //Obtencion de respuesta GET de un pedido realizado por orderId
    public List<UserGetOrderId> findOrderByOrderId(Integer userId, Integer orderId){
        return userDao.findOrderByOrderId(userId, orderId);
    }

    //Obtencion de respuesta GET de las zonas disponibles
    public List<NieghbourGet> findNeighbour(){
        return userDao.findNeighbour();
    }
}

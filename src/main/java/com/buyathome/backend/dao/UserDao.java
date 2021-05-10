package com.buyathome.backend.dao;

import com.buyathome.backend.dto.UserGetOrderId;
import com.buyathome.backend.dto.UserOrderGet;
import com.buyathome.backend.model.User;
import com.buyathome.backend.dto.UserGet;
import com.buyathome.backend.dto.NieghbourGet;
import com.buyathome.backend.model.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //Creacion de Usuarios
    public void create(User user);

    //Get de usuario por Id
    public List<UserGet> findUserById(Integer userId);

    //GET de los pedidos realizados por el usuario
    public List<UserOrderGet> findOrdersByUserId(Integer userId);

    //GET de los pedidos realizados por el usuario
    public List<UserGetOrderId> findOrderByOrderId(Integer userId,Integer orderId);

    //GET datos de nieghbour
    public List<NieghbourGet> findNeighbour();

    //Actualizacion de datos de usuario
    public void update(User user);
    public Integer selectAddressId(Integer userId);



}

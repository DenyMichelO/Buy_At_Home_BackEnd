package com.buyathome.backend.dao;

import com.buyathome.backend.model.Address;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {

    public void create(Address address);

    public void update(Address address);

}

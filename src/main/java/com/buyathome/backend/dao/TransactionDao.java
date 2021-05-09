package com.buyathome.backend.dao;

import com.buyathome.backend.dto.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao {
    public Integer create(Transaction transaction);

    public Integer getLastInsertId();
}

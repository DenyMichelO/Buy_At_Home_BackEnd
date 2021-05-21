package com.buyathome.backend.dao;

import com.buyathome.backend.dto.PaymentAdd;
import com.buyathome.backend.model.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public void createPayment(Payment payment);
}

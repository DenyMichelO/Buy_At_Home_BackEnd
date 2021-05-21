package com.buyathome.backend.dao;


import com.buyathome.backend.model.Voucher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoucherDao {
    public void createVoucher(Voucher voucher);

    public void updateVoucher(Voucher voucher);

    public void deleteVoucher(Voucher voucher);

}

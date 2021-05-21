package com.buyathome.backend.api;


import com.buyathome.backend.bl.TransactionBl;
import com.buyathome.backend.bl.VoucherBl;
import com.buyathome.backend.dto.Transaction;
import com.buyathome.backend.dto.VoucherAdd;
import com.buyathome.backend.dto.VoucherDelete;
import com.buyathome.backend.dto.VoucherUpdate;
import com.buyathome.backend.model.Voucher;
import com.buyathome.backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
public class VoucherApi {
    private TransactionBl transactionBl;
    private VoucherBl voucherBl;

    @Autowired
    public VoucherApi(TransactionBl transactionBl, VoucherBl voucherBl){
        this.transactionBl = transactionBl;
        this.voucherBl = voucherBl;
    }

    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public VoucherAdd createVoucher(@RequestBody VoucherAdd voucherAdd, Voucher voucher, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherAdd voucherResponse = voucherBl.createVoucher(voucherAdd, voucher, transaction);
        return voucherResponse;
    }

    @RequestMapping(value = "/{voucherId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public VoucherUpdate updateVoucher(@RequestBody VoucherUpdate voucherUpdate, Voucher voucher, HttpServletRequest request, @PathVariable int voucherId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherUpdate voucherResponse = voucherBl.updateVoucher(voucherUpdate,transaction, voucher, voucherId);
        return voucherResponse;
    }

    @RequestMapping(value = "/{voucherId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public VoucherDelete deleteVoucher (@RequestBody VoucherDelete voucherDelete, Voucher voucher, HttpServletRequest request, @PathVariable int voucherId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherDelete voucherResponse = voucherBl.deleteVoucher(voucherDelete, transaction, voucher, voucherId);
        return voucherResponse;
    }


}

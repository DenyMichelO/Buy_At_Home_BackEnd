package com.buyathome.backend.api;

import com.buyathome.backend.bl.PaymentBl;
import com.buyathome.backend.bl.ProductBl;
import com.buyathome.backend.bl.TransactionBl;
import com.buyathome.backend.dto.PaymentAdd;
import com.buyathome.backend.dto.ProductAdd;
import com.buyathome.backend.dto.Transaction;
import com.buyathome.backend.model.Brand;
import com.buyathome.backend.model.Product;
import com.buyathome.backend.model.Tag;
import com.buyathome.backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/payment")
public class PaymentApi {
    private TransactionBl transactionBl;
    private PaymentBl paymentBl;

    @Autowired
    public PaymentApi(TransactionBl transactionBl,PaymentBl paymentBl){
        this.transactionBl = transactionBl;
        this.paymentBl = paymentBl;
    }

    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public PaymentAdd createPayment(@RequestBody PaymentAdd paymentAdd, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        PaymentAdd paymentResponse = paymentBl.createPayment(paymentAdd,transaction);
        return paymentResponse;
    }
}

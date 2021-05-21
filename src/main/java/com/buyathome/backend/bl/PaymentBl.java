package com.buyathome.backend.bl;

import com.buyathome.backend.dao.AddressDao;
import com.buyathome.backend.dao.PaymentDao;
import com.buyathome.backend.dao.TransactionDao;
import com.buyathome.backend.dao.UserDao;
import com.buyathome.backend.dto.PaymentAdd;
import com.buyathome.backend.dto.Transaction;
import com.buyathome.backend.dto.UserCreate;
import com.buyathome.backend.model.Address;
import com.buyathome.backend.model.Payment;
import com.buyathome.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentBl {

    private PaymentDao paymentDao;
    private TransactionDao transactionDao;


    @Autowired
    public PaymentBl(PaymentDao paymentDao, TransactionDao transactionDao) {
        this.paymentDao = paymentDao;
        this.transactionDao = transactionDao;
    }

    public PaymentAdd createPayment(PaymentAdd paymentAdd, Transaction transaction)
    {
        Payment payment = new Payment();
        payment.setFirstname(paymentAdd.getFirstname());
        payment.setLastname(paymentAdd.getLastname());
        payment.setCardNumber(paymentAdd.getCardNumber());
        payment.setSecurityCode(paymentAdd.getSecurityCode());
        payment.setDateExpire(paymentAdd.getDateExpire());
        payment.setTxId(transaction.getTxId());
        payment.setTxHost(transaction.getTxHost());
        payment.setTxUserId(transaction.getTxUserId());
        payment.setTxDate(transaction.getTxDate());
        paymentDao.createPayment(payment);
        payment.setPaymentId(transactionDao.getLastInsertId());


        return paymentAdd;
    }
}

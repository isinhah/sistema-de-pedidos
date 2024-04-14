package com.dev.spring.domain;

import com.dev.spring.domain.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serial;
import java.util.Date;

@Entity
public class BoletoPayment extends Payment {

    @Serial
    private static final long serialVersionUID = 1L;


    private Date dueDate;


    private Date paymentDate;

    public BoletoPayment() {}

    public BoletoPayment(Integer id, PaymentStatus status, Order order, Date dueDate, Date paymentDate) {
        super(id, status, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}

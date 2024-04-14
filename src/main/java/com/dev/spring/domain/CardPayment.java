package com.dev.spring.domain;

import com.dev.spring.domain.enums.PaymentStatus;
import jakarta.persistence.Entity;

import java.io.Serial;

@Entity
public class CardPayment extends Payment {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer installments;

    public CardPayment() {}

    public CardPayment(Integer id, PaymentStatus status, Order order, Integer installments) {
        super(id, status, order);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}

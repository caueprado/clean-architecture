package com.ada.cleanarchitecture.cliente.conta;

import java.math.BigDecimal;

public class AccountAfterWithdrawal {
    private BigDecimal amount;

    public AccountAfterWithdrawal(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

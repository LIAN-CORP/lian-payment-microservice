package com.lian.marketing.paymentmicroservice.domain.api;

import com.lian.marketing.paymentmicroservice.domain.model.Debt;

public interface IDebtServicePort {
    void createDebtFromTransaction(Debt debt);
}

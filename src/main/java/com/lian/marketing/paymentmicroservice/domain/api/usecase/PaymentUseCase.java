package com.lian.marketing.paymentmicroservice.domain.api.usecase;

import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import com.lian.marketing.paymentmicroservice.domain.api.IPaymentServicePort;
import com.lian.marketing.paymentmicroservice.domain.constant.ExceptionConstants;
import com.lian.marketing.paymentmicroservice.domain.exception.DebtDoNotExists;
import com.lian.marketing.paymentmicroservice.domain.exception.UserDoNoExists;
import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import com.lian.marketing.paymentmicroservice.domain.spi.IPaymentPersistencePort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PaymentUseCase implements IPaymentServicePort {

    private final IPaymentPersistencePort paymentPersistencePort;
    private final IDebtServicePort debtServicePort;

    @Override
    public void createPaymentFromTransaction(Payment payment) {
        paymentPersistencePort.savePayment(payment);
    }

    @Override
    public void createPaymentDebt(Payment payment) {
        if(!paymentPersistencePort.clientExists(payment.getClientId())){
            throw new UserDoNoExists(ExceptionConstants.USER_DO_NOT_EXISTS);
        }
        if(!debtServicePort.existsAndActiveByDebtAndClientId(payment.getDebtId(), payment.getClientId())){
            throw new DebtDoNotExists(ExceptionConstants.DEBT_DO_NOT_EXISTS);
        }
        paymentPersistencePort.savePayment(payment);
        debtServicePort.updateTotalRemainingAmount(BigDecimal.valueOf(payment.getAmount()), payment.getDebtId());
    }
}

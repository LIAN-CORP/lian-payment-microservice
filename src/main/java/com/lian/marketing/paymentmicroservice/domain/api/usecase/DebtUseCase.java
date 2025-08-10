package com.lian.marketing.paymentmicroservice.domain.api.usecase;

import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import com.lian.marketing.paymentmicroservice.domain.model.Debt;
import com.lian.marketing.paymentmicroservice.domain.model.StatusDebt;
import com.lian.marketing.paymentmicroservice.domain.spi.IDebtPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class DebtUseCase implements IDebtServicePort {

    private final IDebtPersistencePort debtPersistencePort;

    @Override
    public boolean createDebtFromTransaction(Debt debt) {
        Optional<Debt> activeDebt = debtPersistencePort.findActiveDebtByClientId(debt.getClientId());
        if(activeDebt.isEmpty()){
            debt.setRemainingAmount(debt.getTotalAmount());
            debt.setStatus(StatusDebt.PENDING);
            debtPersistencePort.saveDebt(debt);
            return true;
        }
        debt.setId(activeDebt.get().getId());
        debt.setTotalAmount(debt.getTotalAmount() + activeDebt.get().getTotalAmount());
        debt.setStatus(StatusDebt.PENDING);
        debt.setCreatedAt(activeDebt.get().getCreatedAt());
        debt.setUpdatedAt(LocalDateTime.now());
        debtPersistencePort.saveDebt(debt);
        return true;
    }
}

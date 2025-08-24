package com.lian.marketing.paymentmicroservice.domain.api.usecase;

import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import com.lian.marketing.paymentmicroservice.domain.constant.ExceptionConstants;
import com.lian.marketing.paymentmicroservice.domain.exception.DebtDoNotExists;
import com.lian.marketing.paymentmicroservice.domain.exception.RemainingAmountIsOverTheLimitException;
import com.lian.marketing.paymentmicroservice.domain.model.Debt;
import com.lian.marketing.paymentmicroservice.domain.model.StatusDebt;
import com.lian.marketing.paymentmicroservice.domain.spi.IDebtPersistencePort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DebtUseCase implements IDebtServicePort {

    private final IDebtPersistencePort debtPersistencePort;

    @Override
    public void createDebtFromTransaction(Debt debt) {
        Optional<Debt> activeDebt = debtPersistencePort.findActiveDebtByClientId(debt.getClientId());
        if(activeDebt.isEmpty()){
            debt.setRemainingAmount(debt.getTotalAmount());
            debt.setStatus(StatusDebt.PENDING);
            debt.setCreatedAt(LocalDateTime.now());
            debt.setUpdatedAt(LocalDateTime.now());
            debtPersistencePort.saveDebt(debt);
            return;
        }
        debt.setId(activeDebt.get().getId());
        debt.setRemainingAmount(activeDebt.get().getRemainingAmount().add(debt.getTotalAmount()));
        debt.setTotalAmount(debt.getTotalAmount().add(activeDebt.get().getTotalAmount()));
        debt.setStatus(StatusDebt.PENDING);
        debt.setCreatedAt(activeDebt.get().getCreatedAt());
        debt.setUpdatedAt(LocalDateTime.now());
        debtPersistencePort.saveDebt(debt);
    }

    @Override
    public boolean existsAndActiveByDebtAndClientId(UUID debtId, UUID clientId) {
        return debtPersistencePort.existsAndActiveByDebtAndClientId(debtId, clientId);
    }

    @Override
    public void updateTotalRemainingAmount(BigDecimal remainingAmount, UUID debtId) {
        Optional<Debt> debt = debtPersistencePort.findById(debtId);
        if(debt.isEmpty()){
            throw new DebtDoNotExists(ExceptionConstants.DEBT_DO_NOT_EXISTS);
        }
        if(debt.get().getRemainingAmount().compareTo(remainingAmount) < 0){
            throw new RemainingAmountIsOverTheLimitException(ExceptionConstants.REMAINING_AMOUNT_IS_OVER_THE_LIMIT);
        }
        Debt updatedDebt = debt.get();
        updatedDebt.setUpdatedAt(LocalDateTime.now());
        updatedDebt.setRemainingAmount(updatedDebt.getRemainingAmount().subtract(remainingAmount));
        debtPersistencePort.saveDebt(updatedDebt);
    }
}

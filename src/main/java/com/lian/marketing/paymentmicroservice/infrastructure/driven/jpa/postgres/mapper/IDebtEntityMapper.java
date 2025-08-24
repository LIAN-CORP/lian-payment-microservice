package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper;

import com.lian.marketing.paymentmicroservice.domain.model.Debt;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.DebtEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDebtEntityMapper {
    DebtEntity toEntityFromModel(Debt debt);
    Debt toModelFromEntity(DebtEntity debtEntity);
    List<Debt> toModeListFromEntityList(List<DebtEntity> debtEntityList);
}

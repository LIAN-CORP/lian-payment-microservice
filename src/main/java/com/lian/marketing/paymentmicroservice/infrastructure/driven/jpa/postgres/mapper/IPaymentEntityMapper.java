package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPaymentEntityMapper {
    PaymentEntity toEntityFromModel(Payment payment);
}

package com.lian.marketing.paymentmicroservice.application.mapper;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreatePaymentRequest;
import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paymentDate", expression = "java(java.time.LocalDateTime.now())")
    Payment toModelFromRequest(CreatePaymentRequest request);

}

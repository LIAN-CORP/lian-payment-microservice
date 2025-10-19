package com.lian.marketing.paymentmicroservice.domain.constant;

public class ExceptionConstants {
    private ExceptionConstants() {}

    public static final String DEBT_DO_NOT_EXISTS = "Debt do not exists or is not active";
    public static final String USER_DO_NOT_EXISTS = "User do not exists";
    public static final String REMAINING_AMOUNT_IS_OVER_THE_LIMIT = "The payment amount exceeds the remaining debt amount";
    public static final String CLIENT_DO_NOT_EXISTS = "Client do not exists";
}

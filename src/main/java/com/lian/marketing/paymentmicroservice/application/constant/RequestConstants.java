package com.lian.marketing.paymentmicroservice.application.constant;

public class RequestConstants {
    private RequestConstants() {}

    // PAYMENT
    public static final String PAYMENT_AMOUNT_MUST_BE_VALID_NUMBER = "Payment amount must be a valid number";
    public static final String PAYMENT_METHOD_MUST_BE_NOT_EMPTY = "Payment method must be not empty";
    public static final String PAYMENT_CLIENT_ID_MUST_BE_NOT_EMPTY = "Payment client id must be not empty";
    public static final String PAYMENT_TRANSACTION_ID_MUST_BE_NOT_EMPTY = "Payment transaction id must be not empty";

    //Debt
    public static final String DEBT_TOTAL_AMOUNT_MUST_BE_VALID_NUMBER = "Debt total amount must be a valid number";
    public static final String DEBT_CLIENT_ID_MUST_BE_NOT_EMPTY = "Debt client id must be not empty";
    public static final String DEBT_TRANSACTION_ID_MUST_BE_NOT_EMPTY = "Debt transaction id must be not empty";
}

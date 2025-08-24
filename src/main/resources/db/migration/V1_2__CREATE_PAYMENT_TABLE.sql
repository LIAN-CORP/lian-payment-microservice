CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.Payment(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    amount DECIMAL(10,2) NOT NULL,
    payment_date DATE NOT NULL,
    payment_method VARCHAR NOT NULL,
    client_id UUID NOT NULL,
    transaction_id UUID NOT NULL,
    debt_id UUID,
    CONSTRAINT fk_payment_debt FOREIGN KEY (debt_id) REFERENCES public.Debt(id)
);
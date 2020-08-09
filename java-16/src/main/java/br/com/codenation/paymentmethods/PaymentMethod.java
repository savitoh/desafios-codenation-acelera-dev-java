package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new PriceCalculateCashPaymentMethod()),
    DEBIT_CARD(new PriceCalculateDebitCardPaymentMethod()),
    CREDIT_CARD(new PriceCalculateCreditCardPaymentMethod()),
    TRANSFER(new PriceCalculateTransferPaymentMethod());

    private final PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}
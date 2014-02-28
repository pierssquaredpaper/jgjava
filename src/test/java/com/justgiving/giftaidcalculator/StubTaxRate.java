package com.justgiving.giftaidcalculator;

/**
 * A stub implementation of {@link TaxRate}
 *
 * @author piers
 */
public class StubTaxRate implements TaxRate {

    private double rate;

    @Override
    public double getRate() {
        return rate;
    }

    public StubTaxRate(double rate) {
        this.rate = rate;
    }
}

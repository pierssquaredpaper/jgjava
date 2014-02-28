package com.justgiving.giftaidcalculator;

/**
 * This enumeration represents different event types. The different types provide
 * different gift aid supplements.
 *
 * @author piers
 */
public enum EventType {
    RUNNING (5),
    SWIMMING (3),
    OTHER (0);

    private double supplement;

    private EventType(double supplement) {
        this.supplement = supplement;
    }

    public double getSupplement() {
        return supplement;
    }

}

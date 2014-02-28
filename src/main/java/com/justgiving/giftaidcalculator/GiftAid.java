package com.justgiving.giftaidcalculator;

import java.text.DecimalFormat;

/**
 * This class provides methods to calculate gift aid. The general principle is
 * to set the donation and retrieve the giftAid.
 *
 * @author piers
 */



public class GiftAid {

    private TaxRate taxRate;
    private double donation;
    private double giftAid;
    private EventType eventType = EventType.OTHER;

    /*
     * Calculates the gift aid from the provided taxRate, donation and eventType. The result
     * is then put into the giftAid variable.
     */
    private void calculateGiftAid() {
        double giftAidRatio = taxRate.getRate() / (100 - taxRate.getRate());
        giftAid = (donation * giftAidRatio);

        double supplement = (giftAid / 100) * eventType.getSupplement();
        giftAid = giftAid + supplement;
    }

    /**
     * Returns the calculated gift aid as a decimal to 2 decimal points
     * @return A string representation of the giftAid.
     */
    public String asDecimal() {
        DecimalFormat df2 = new DecimalFormat("#.00");
        return df2.format(giftAid);
    }

    /**
     * Sets the taxRate and then calculates the giftAid putting the result in giftAid.
     *
     * @param taxRate taxRate to set
     */
    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
        calculateGiftAid();
    }

    /**
     * Sets the donation and then calculates the giftAid putting the result in giftAid.
     *
     * @param donation donation as a double, negative donations throw an IllegalArgumentException
     */
    public void setDonation(double donation) {
        if (donation > 0) {
            this.donation = donation;
            calculateGiftAid();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the eventType and then calculates the giftAid putting the result in giftAid.
     *
     * @param eventType eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
        calculateGiftAid();
    }

    /**
     *
     * @return current giftAid
     */
    public double getGiftAid() {
        return giftAid;
    }
}

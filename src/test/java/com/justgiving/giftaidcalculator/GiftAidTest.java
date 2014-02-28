package com.justgiving.giftaidcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link GiftAid}
 *
 * @author piers
 */

@RunWith(JUnit4.class)
public class GiftAidTest {
    private static final double EPSILON = 0.01;

    private GiftAid giftAid;

    @Before
    public void runBeforeEveryTest() {
        giftAid = new GiftAid();
        giftAid.setTaxRate(new StubTaxRate(20));
    }

    @Test
    public void story1CalculateGiftAidNoDonation() {
        Assert.assertEquals(0, giftAid.getGiftAid(), EPSILON);
    }

    @Test
    public void story1CalculateGiftAid() {
        giftAid.setDonation(100);
        Assert.assertEquals(25, giftAid.getGiftAid(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void story1CalculateGiftAidIllegalArgs() {
        giftAid.setDonation(-100);
    }

    @Test
    public void story2ChangeGiftAidTaxRate() {
        giftAid.setDonation(100);
        Assert.assertEquals(25, giftAid.getGiftAid(), EPSILON);

        giftAid.setTaxRate(new StubTaxRate(10));
        Assert.assertEquals(11.11, giftAid.getGiftAid(), EPSILON);
    }

    @Test
    public void story3DisplayGiftAid() {
        giftAid.setDonation(10);
        Assert.assertEquals("2.50", giftAid.asDecimal());

        giftAid.setDonation(123456);
        Assert.assertEquals("30864.00", giftAid.asDecimal());
    }

    @Test
    public void story4CheckSupplements() {
        giftAid.setDonation(100);
        giftAid.setEventType(EventType.SWIMMING);
        Assert.assertEquals(25.75, giftAid.getGiftAid(), EPSILON);

        giftAid.setEventType(EventType.RUNNING);
        Assert.assertEquals(26.25, giftAid.getGiftAid(), EPSILON);

        giftAid.setEventType(EventType.OTHER);
        Assert.assertEquals(25, giftAid.getGiftAid(), EPSILON);
    }
}

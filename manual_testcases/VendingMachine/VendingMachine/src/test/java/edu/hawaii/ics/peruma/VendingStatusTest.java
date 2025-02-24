package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingStatusTest {

    private VendingStatus successStatus;
    private VendingStatus failureStatus;

    @Before
    public void setUp() {
        successStatus = new VendingStatus(true, 1.00, VendingStatus.VendingMessage.SUCCESS);
        failureStatus = new VendingStatus(false, 0.00, VendingStatus.VendingMessage.INSUFFICIENT_FUNDS);
    }

    @Test
    public void isSuccess() {
        assertTrue("Expected success status", successStatus.isSuccess());
        assertFalse("Expected failure status", failureStatus.isSuccess());
    }

    @Test
    public void getMessage() {
        assertEquals("Expected SUCCESS message", VendingStatus.VendingMessage.SUCCESS, successStatus.getMessage());
        assertEquals("Expected INSUFFICIENT_FUNDS message", VendingStatus.VendingMessage.INSUFFICIENT_FUNDS, failureStatus.getMessage());
    }

}

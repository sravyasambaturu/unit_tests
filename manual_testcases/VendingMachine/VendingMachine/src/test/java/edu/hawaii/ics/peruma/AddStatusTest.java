package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddStatusTest {

    private AddStatus successStatus;
    private AddStatus failureStatus;

    @Before
    public void setUp() {
        successStatus = new AddStatus(true, AddStatus.AddMessage.SUCCESS);
        failureStatus = new AddStatus(false, AddStatus.AddMessage.INSUFFICIENT_SPACE);
    }

    @Test
    public void isSuccess() {
        assertTrue("success status", successStatus.isSuccess());
        assertFalse("failure status", failureStatus.isSuccess());
    }

    @Test
    public void getAddMessage() {
        assertEquals("expect SUCCESS message", AddStatus.AddMessage.SUCCESS, successStatus.getAddMessage());
        assertEquals("expected INSUFFICIENT_SPACE message", AddStatus.AddMessage.INSUFFICIENT_SPACE, failureStatus.getAddMessage());
    }
}

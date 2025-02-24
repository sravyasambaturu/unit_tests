package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessStatusTest {

    private ProcessStatus status;

    @Before
    public void setUp() {
        status = new ProcessStatus(true, ProcessStatus.ProcessMessage.SUCCESS);
    }

    @Test
    public void isSuccess() {
        assertTrue("Process should be successful", status.isSuccess());
    }

    @Test
    public void getMessage() {
        assertEquals("Message should be SUCCESS", ProcessStatus.ProcessMessage.SUCCESS, status.getMessage());
    }

    @Test
    public void failedStatus() {
        status = new ProcessStatus(false, ProcessStatus.ProcessMessage.FAILED);
        assertFalse("Process should fail", status.isSuccess());
        assertEquals("Message should be FAILED", ProcessStatus.ProcessMessage.FAILED, status.getMessage());
    }

    @Test
    public void insufficientFunds() {
        status = new ProcessStatus(false, ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS);
        assertFalse("process fails due to insufficient funds", status.isSuccess());
        assertEquals("message should be INSUFFICIENT_FUNDS", ProcessStatus.ProcessMessage.INSUFFICIENT_FUNDS, status.getMessage());
    }

    @Test
    public void invalidAccount() {
        status = new ProcessStatus(false, ProcessStatus.ProcessMessage.INVALID_ACCOUNT);
        assertFalse("process fail due to invalid account", status.isSuccess());
        assertEquals("message should be INVALID_ACCOUNT", ProcessStatus.ProcessMessage.INVALID_ACCOUNT, status.getMessage());
    }
}


package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    private Location location1;
    private Location location3;

    @Before
    public void setUp() {
        location1 = new Location(1, 1);
        location3 = new Location(2, 2);
    }

    @Test
    public void getRow() {
        assertEquals("row should be 1", 1, location1.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals("column should be 1", 1, location1.getColumn());
    }

    @Test
    public void equals_WithNull() {
        assertNotEquals("location should not be equal to null", location1.equals(null));
    }

}



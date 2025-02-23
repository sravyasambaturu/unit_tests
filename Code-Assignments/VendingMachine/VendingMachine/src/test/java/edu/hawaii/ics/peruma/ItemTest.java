package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() {
        item = new Item("Soda", 1.50, 5, new Location(1, 1));
    }

    @Test
    public void getName() {
        assertEquals(" name of item", "Soda", item.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("price of item", 1.50, item.getPrice(), 0.01);
    }

    @Test
    public void getQuantity() {
        assertEquals("expected quantity of item", 5, item.getQuantity());
    }

    @Test
    public void setQuantity() {
        item.setQuantity(10);
        assertEquals("expected updated quantity of item", 10, item.getQuantity());
    }
}

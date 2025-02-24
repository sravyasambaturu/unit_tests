//*******************************************************************
//  __description__ = "Assignment 01 - Unit Testing"
//  __course__ = "ics615"
//  __organization__ = "Information and Computer Sciences Department, University of Hawai‘i at Mānoa"
//  __author__ = "Anthony Peruma"
//  __email__ = "peruma@hawaii.edu"
//  __web__ = "https://www.peruma.me"
//  __version__ = "1.0"
//  __created__ = "2022-08-01"
//  __modified__ = "2023-03-01"
//  __maintainer__ = "Anthony Peruma"
//*******************************************************************
package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
        vendingMachine.addItem(new Item("Soda", 1.25, 10, new Location(1, 1)));
        vendingMachine.addItem(new Item("Chips", 1.50, 5, new Location(1, 2)));
    }

    @Test
    public void addItem_Successful() {
        AddStatus addStatus = vendingMachine.addItem(new Item("Apple Juice", 2.25, 10, new Location(3, 1)));
        assertTrue("Could not add item", addStatus.isSuccess());
    }

    // this test checks what happens when we try to add an item to a location that is already taken.
    // The vending machine should not allow two different items in the same location.
    @Test
    public void addItem_Failure_LocationOccupied() {
        AddStatus addStatus = vendingMachine.addItem(new Item("Candy", 1.00, 3, new Location(1, 1)));
        assertFalse("Adding should fail because location is occupied", addStatus.isSuccess());
    }

    @Test
    public void vendItem_Successful() {
        // This test verifies a successful purchase from the vending machine.
        // customer has enough money and an item is available at the requested location.
        // test also checks that the correct amount of balance amount is returned.
        VendingStatus vendingStatus = vendingMachine.vendItem(new Location(1, 1), 2.00);
        assertTrue("vending should be successful", vendingStatus.isSuccess());
        assertEquals("change", 0.75, vendingStatus.getChange(), 0.01);
    }

    // checks what happens when a customer tries to buy an item without enough money and the vending  machine should
    // not allow the purchase.
    @Test
    public void vendItem_Failure_InsufficientFunds() {
        VendingStatus vendingStatus = vendingMachine.vendItem(new Location(1, 1), 1.00);
        assertFalse("vending fails due to insufficient funds", vendingStatus.isSuccess());
    }

    @Test
    public void vendItem_Failure_UnknownLocation() {
        // test checks what happens when a customer tries to buy an item from an invalid location.
        // as no item exists at (5,5) the vending machine should reject the purchase.
        VendingStatus vendingStatus = vendingMachine.vendItem(new Location(5, 5), 2.00);
        assertFalse("vending fails because of location unknown", vendingStatus.isSuccess());
    }

    @Test
    public void vendItem_Failure_NegativeAmountInserted() {
        // test ensures that inserting a negative amount of money doesn't allow a purchase.
        // The vending machine should reject the transaction immediately.
//hackers might try using a negative amount to fool the machine into giving free items or extra change. the system should block such attempts.
        VendingStatus vendingStatus = vendingMachine.vendItem(new Location(1, 1), -1.00);
        assertFalse("vending should fail for negative values typed ", vendingStatus.isSuccess());
    }

    @Test
    public void vendItem_Failure_NoItemAtLocation() {
        // This test checks if the machine stops a purchase when no item is at the location even if enough money is inserted.
        VendingStatus vendingStatus = vendingMachine.vendItem(new Location(3, 3), 1.25);
        assertFalse("vending fails because no item exists at this location", vendingStatus.isSuccess());
    }

    @Test
    public void addItem_InsufficientSpace() {
        Item item = new Item("Candy", 1.00, 11, new Location(11, 1));
        AddStatus addStatus = vendingMachine.addItem(item);

        assertFalse("adding an item with insufficient space should fail", addStatus.isSuccess());
        assertEquals("error message indicates insufficient space", AddStatus.AddMessage.INSUFFICIENT_SPACE, addStatus.getAddMessage());
    }

}




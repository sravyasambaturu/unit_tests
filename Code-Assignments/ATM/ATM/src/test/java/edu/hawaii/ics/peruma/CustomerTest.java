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

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer(1234, 1234, 100.00f);
    }

    @Test
    public void getPin() {
        assertEquals("Did not obtain the correct PIN",1234, customer.getPin());
    }

    @Test
    public void setPin() {
        int newPin = 4321;
        customer.setPin(newPin);
        assertEquals("Did not set the correct PIN", newPin, customer.getPin());
    }

    @Test
    public void getBalance() {
        assertEquals("Balance is not correct", 100.00f, customer.getBalance(), 0.01);
    }

    @Test
    public void setBalance() {
        customer.setBalance(200.00f);
        assertEquals("balance is not updated correctly", 200.00f, customer.getBalance(), 0.01);
    }

    @Test
    public void getAccountNumber() {
        assertEquals("account number is incorrect", 1234, customer.getAccountNumber());
    }
}
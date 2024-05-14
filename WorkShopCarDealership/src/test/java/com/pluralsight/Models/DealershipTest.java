package com.pluralsight.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    private Dealership dealership;
    private Vehicle vehicle1;
    private Vehicle vehicle2;


    void setUp() {
        dealership = new Dealership("Test Dealership", "123 Main St", "123-456-7890");
        vehicle1 = new Vehicle(12232,2011,"Toyota", "Camry", "Sedan","Red",120000,5000);
        vehicle2 = new Vehicle(15672,2016,"Honda", "Accord", "Sedan","Blue",87000,14000);
    }





    @Test
    void testAddVehicle() {
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        assertEquals(2, dealership.getAllVehicles().size());
    }

    @Test
    void testRemoveVehicle() {
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.removeVehicle(vehicle1);
        assertEquals(1, dealership.getAllVehicles().size());
        assertFalse(dealership.getAllVehicles().contains(vehicle1));
    }
}
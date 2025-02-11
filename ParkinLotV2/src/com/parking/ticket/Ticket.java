package com.parking.ticket;

import java.time.Instant;

import com.parking.VehicleType;

public class Ticket {
    private VehicleType vehicleType;
    private Instant inTime;

    public Ticket(VehicleType vehicleType, Instant inTime) {
        this.vehicleType = vehicleType;
        this.inTime = inTime;
    }
    
    public VehicleType getVehicleType() {
    	return this.vehicleType;
    }
    
    public Instant getInTime() {
    	return this.inTime;
    }

    public void printTicket() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("In Time: " + inTime);
    }
}

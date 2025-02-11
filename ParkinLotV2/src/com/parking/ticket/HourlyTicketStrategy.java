package com.parking.ticket;

import java.time.Instant;

import com.parking.VehicleType;

public class HourlyTicketStrategy implements ITicketStrategy {
	
    public HourlyTicketStrategy() {
    }

	@Override
	public Ticket generateTicket(VehicleType vehicleType) {
		// TODO Auto-generated method stub
		 return new Ticket(vehicleType, Instant.now());
	}

}
 
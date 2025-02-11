package com.parking.ticket;

import com.parking.VehicleType;

public class FlatTicketStategy implements ITicketStrategy {
	

    public FlatTicketStategy() {
    }
 
	@Override
	public Ticket generateTicket(VehicleType vehicleType) {
		// TODO Auto-generated method stub
		return new Ticket(vehicleType, null);
	}

}

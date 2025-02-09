package com.parking.ticket;

import java.time.LocalDateTime;

import com.parking.VehicleType;

public class TicketV1 extends TicketType{
	
	public TicketV1(LocalDateTime now, VehicleType vehicleType) {
		super(now, vehicleType);
	}

	public TicketV1() {
		super();
	}

	@Override
	public TicketType generateTicket(VehicleType vehicleType) {
		// TODO Auto-generated method stub
		return new TicketV1(LocalDateTime.now(), vehicleType);
	}
	
	
} 

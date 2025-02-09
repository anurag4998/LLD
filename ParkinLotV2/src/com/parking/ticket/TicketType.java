package com.parking.ticket;

import java.time.LocalDateTime;

import com.parking.VehicleType;

public abstract class TicketType {
	private LocalDateTime inTime;
	private VehicleType vehicleType;
	
	public TicketType(LocalDateTime inTime, VehicleType vehicleType) {
		this.inTime = inTime;
		this.vehicleType = vehicleType;
	}
	public TicketType() {
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getInTime() {
		return inTime;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public abstract TicketType generateTicket(VehicleType vehicleType);

}

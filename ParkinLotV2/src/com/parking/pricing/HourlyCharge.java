package com.parking.pricing;

import java.time.Instant;

import com.parking.ticket.Ticket;

public class HourlyCharge implements PricingStrategy {

	@Override
	public double calculateCost(Ticket ticket) {
		// TODO Auto-generated method stub
		final int MILLI_TO_HOUR = 1000 * 60 * 60;
		int hours = (int) (Instant.now().toEpochMilli() - ticket.getInTime().toEpochMilli())/MILLI_TO_HOUR;
		
		return switch(ticket.getVehicleType()) {
			case MOTORCYCLE -> {
				yield hours * 50;
			}
			case CAR -> {
				yield hours * 100;
			}
			case TRUCK -> {
				yield hours * 150;
			}
		};
	}

}

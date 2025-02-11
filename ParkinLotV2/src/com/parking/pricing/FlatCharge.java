package com.parking.pricing;

import com.parking.VehicleType;
import com.parking.ticket.Ticket;

public class FlatCharge implements PricingStrategy {

	private static final double CHARGE_PER_HOUR = 50;
	@Override
	public double calculateCost(Ticket ticket) {
		return switch(ticket.getVehicleType()) {
			case MOTORCYCLE -> {
				yield CHARGE_PER_HOUR * 1;
			}
			case CAR -> {
				yield CHARGE_PER_HOUR * 2;
			}
			case TRUCK -> {
				yield CHARGE_PER_HOUR * 3;
			}
		};
	}

}

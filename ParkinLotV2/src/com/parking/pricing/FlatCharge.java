package com.parking.pricing;

import com.parking.VehicleType;

public class FlatCharge implements PricingStrategy {

	private static final double CHARGE_PER_HOUR = 50;
	@Override
	public double calculateCost(VehicleType vehicleType) {
		return switch(vehicleType) {
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

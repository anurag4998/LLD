package com.parking.pricing;

import com.parking.VehicleType;

public interface PricingStrategy {
	public double calculateCost(VehicleType vehicleType);
}

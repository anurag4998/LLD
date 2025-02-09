package com.parking.slots;

import com.parking.VehicleType;

public class CarSlot extends AbstractSlot {
	public CarSlot(String slotNumber) {
		super(VehicleType.CAR, slotNumber);
	}
}

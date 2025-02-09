package com.parking.slots;

import com.parking.VehicleType;

public class MotorcycleSlot extends AbstractSlot {
	public MotorcycleSlot(String slotNumber) {
		super(VehicleType.MOTORCYCLE, slotNumber);
	}
}

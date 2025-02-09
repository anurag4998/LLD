package com.parking.slots;

import com.parking.VehicleType;

public class TruckSlot extends AbstractSlot {
	public TruckSlot(String slotNumber) {
		super(VehicleType.TRUCK, slotNumber);
	}
}

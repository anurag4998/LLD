package com.parking.slots;

import com.parking.VehicleType;

public class SlotFactory {
	
	public static AbstractSlot createSlot(VehicleType vehicleType, String slotNumber) {
		return switch(vehicleType) {
			case CAR -> {
				yield new CarSlot(slotNumber);
			}
			case TRUCK -> {
				yield new TruckSlot(slotNumber);
			}
			case MOTORCYCLE -> {
				yield new MotorcycleSlot(slotNumber);
			}
		};
	}
}

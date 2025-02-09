package com.parking.slots;

import com.parking.Vehicle;
import com.parking.VehicleType;

public abstract class AbstractSlot {
	private final VehicleType slotType;
	private Vehicle vehicle;
	private final String slotNumber;
	public AbstractSlot(VehicleType vehicleType, String slotNumber) {
		this.slotType = vehicleType;
		this.slotNumber = slotNumber;
	}

	public VehicleType getSlotType() {
		return this.slotType;
	}
	
	public boolean isEmpty() {
		return this.vehicle == null;
	}
	
	public void setSlotEmpty() {
		this.vehicle = null;
	}
	
	public String getSlotNumber() {
		return this.slotNumber;
	}
	
	public void markSlotAsOccupied(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
}

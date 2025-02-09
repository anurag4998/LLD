package com.parking;

import java.util.ArrayList;
import java.util.List;

import com.parking.slots.AbstractSlot;
import com.parking.slots.SlotFactory;

public class ParkingLevel {
	
	private static final int DEFAULT_SIZE = 2;
	
	private final List<AbstractSlot> parkingSlots = new ArrayList<AbstractSlot>();
	private int levelNumber;
	
	
	public ParkingLevel(int levelNumber) {
		this.levelNumber = levelNumber;
		List<VehicleType> listOfVehicleTypes = List.of(VehicleType.values());
		listOfVehicleTypes.forEach(vehicleType -> {
			for(int i = 0; i < DEFAULT_SIZE; i++) {
				//TODO: Change to StringBuffer
				createSlot(levelNumber, vehicleType);
			}
		});
	}

	private void createSlot(int levelNumber, VehicleType vehicleType) {
		String slotNumber = String.valueOf(levelNumber) + "-" + String.valueOf(parkingSlots.size() + 1);
		AbstractSlot slot = SlotFactory.createSlot(vehicleType, slotNumber);
		parkingSlots.add(slot);
	}
	
	public void addSlot(VehicleType vehicleType) {
		createSlot(levelNumber, vehicleType);
	}
	
	public void addMultipleSlots(VehicleType vehicleType , int nuberOfSlots) {
		for(int i = 0 ; i < nuberOfSlots; i++) {
			createSlot(levelNumber, vehicleType);
		}
	}
	
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	//do not return mutable lists
	public List<AbstractSlot> getSlots() {
		return List.copyOf(parkingSlots);
	}
	
	public List<AbstractSlot> getSlotsByVehicleType(VehicleType vehicleType) {
		return this.parkingSlots.stream().filter(slot -> slot.getSlotType().equals(vehicleType)).toList();
	}
	
	public List<AbstractSlot> getFreeSlotsByVehicleType(VehicleType vehicleType) {
		return this.parkingSlots.stream().filter(slot -> slot.getSlotType().equals(vehicleType) && 
				slot.isEmpty() == true).toList();
	}

	
}

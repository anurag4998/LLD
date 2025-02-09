package com.parking;

public class Vehicle {
	//use final
	private final VehicleType vehicleType;
	private final String vehicleNumber;
	
	public Vehicle(String vehicleNumber, VehicleType vehicleType) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
}

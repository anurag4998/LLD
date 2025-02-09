package com.parking;

import com.parking.slots.SlotNotFoundException;
import com.parking.ticket.TicketType;

public class ParkingLotDriver {

	public static void main(String[] args) throws SlotNotFoundException {
		// TODO Auto-generated method stub
		
		//generate some vehicles
		
		Vehicle car1 = new Vehicle("Dfdjfj", VehicleType.CAR);
		Vehicle car2 = new Vehicle("Dfdjfj34", VehicleType.CAR);
		Vehicle truck1 = new Vehicle("Terecds", VehicleType.TRUCK);
		Vehicle truck2 = new Vehicle("dfdfdf", VehicleType.TRUCK);
		
		ParkingLot parkingLot = ParkingLot.getInstance();
		parkingLot.addLevel();
		parkingLot.addLevel();
		
		TicketType ticket = parkingLot.park(truck1);
		System.out.println(ticket.toString());
		
		double unpark = parkingLot.unpark(ticket, truck1 );
		System.out.println(unpark);
	}

}

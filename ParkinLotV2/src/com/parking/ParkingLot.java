package com.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.parking.pricing.FlatCharge;
import com.parking.pricing.PricingStrategy;
import com.parking.slots.AbstractSlot;
import com.parking.slots.SlotNotFoundException;
import com.parking.ticket.FlatTicketStategy;
import com.parking.ticket.ITicketStrategy;
import com.parking.ticket.Ticket;
import com.parking.ticket.TicketType;
import com.parking.ticket.TicketV1;

public class ParkingLot {
	
	private static int parkingLevelCount = 0;
	private PricingStrategy pricingStrategy;
	private List<Ticket> tickets;
	private ITicketStrategy ticketingStrategy;
	final List<ParkingLevel> parkingLevels = new ArrayList<ParkingLevel>();
    private static ParkingLot instance;

	
	public ParkingLot(PricingStrategy pricingStrategy, ITicketStrategy ticketingStrategy) {
		this.pricingStrategy = pricingStrategy;
		this.ticketingStrategy = ticketingStrategy;
		tickets = new ArrayList<Ticket>();
	}
	
	public void addLevel() {
		ParkingLevel parkingLevel = new ParkingLevel(parkingLevelCount);
		parkingLevels.add(parkingLevel);
		parkingLevelCount += 1;
	}
	
	public void addSlotsToLevel(int parkingLevelNumber, VehicleType vehicleType, int numberOfSlots) {
		try {	
			Optional<ParkingLevel> parkingLevelOpt = parkingLevels.stream().filter(parkingLevel -> parkingLevel.getLevelNumber() == parkingLevelNumber).findFirst();
			ParkingLevel parkingLevel = parkingLevelOpt.orElseThrow();
			parkingLevel.addMultipleSlots(vehicleType, numberOfSlots);
		}
		catch(Exception e) {	
		}
	}
	
	public void setPricingStrategy(PricingStrategy pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}
	
	public Ticket park(Vehicle vehicle) throws SlotNotFoundException {
		//check if slot is free if not throw an exception
		//markTheSlotAsOccupied
		//generateTicket
			
			Optional<AbstractSlot> firstAvailableSlot = getFirstAvailableSlot(vehicle.getVehicleType());
			AbstractSlot slotFound = firstAvailableSlot.orElseThrow();
			slotFound.markSlotAsOccupied(vehicle);
			Ticket ticket = ticketingStrategy.generateTicket(vehicle.getVehicleType());
			this.tickets.add(ticket);
			return ticket;
	}
	
	public double unpark(Ticket ticket, Vehicle vehicle) {	
		double cost = pricingStrategy.calculateCost(ticket);
		unParkVehicle(vehicle);
		return cost;
	}
	
	private Optional<AbstractSlot> getFirstAvailableSlot (VehicleType vehicleType) {
		List<AbstractSlot> list = this.parkingLevels.stream().map(parkingLevel -> {
			Optional<AbstractSlot> slotOpt = parkingLevel.getSlots().stream().filter(slot -> slot.isEmpty() && slot.getSlotType().equals(vehicleType)).findFirst();
			if(slotOpt.isPresent()) {
				return slotOpt.orElseThrow();
			}
			return null;
		}).filter(x ->  x != null).toList();
		
		if(list.size() > 0) {
			return Optional.of(list.get(0));
		}
		return Optional.empty();
	}
	
	private void unParkVehicle(Vehicle vehicle) {
		parkingLevels.forEach(parkingLevel -> {
			parkingLevel.getSlots().forEach(slot -> {
				if( slot.getVehicle() != null && slot.getVehicle().equals(vehicle)) {
					slot.setSlotEmpty();
				}
			});
		});
	}
	
	//Thread safe but has performance issues
	public static synchronized ParkingLot getInstance() {
        if (instance == null) {
	            instance = new ParkingLot(new FlatCharge(), new FlatTicketStategy());
        }
        return instance;
    }

}

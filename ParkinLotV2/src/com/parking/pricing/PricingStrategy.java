package com.parking.pricing;

import com.parking.ticket.Ticket;

public interface PricingStrategy {
	public double calculateCost(Ticket ticket);
}

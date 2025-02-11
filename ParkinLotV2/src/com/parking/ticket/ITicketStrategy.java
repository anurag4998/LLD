package com.parking.ticket;

import com.parking.VehicleType;

public interface ITicketStrategy {
    Ticket generateTicket(VehicleType vehicleType);
}

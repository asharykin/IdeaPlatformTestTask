package ru.idea.platform.service;

import ru.idea.platform.model.Ticket;

import java.util.*;

public class TicketService {

    public Map<String, Long> getMinFlightDurationByCarrier(List<Ticket> tickets) {
        Map<String, Long> minFlightDurations = new HashMap<>();
        for (Ticket ticket : tickets) {
            minFlightDurations.merge(ticket.getCarrier(), ticket.getFlightDuration(), Math::min);
        }
        return minFlightDurations;
    }

    public double getAvgPrice(List<Ticket> tickets) {
        double sum = 0.0;
        for (Ticket ticket : tickets) {
            sum += ticket.getPrice();
        }
        return sum / tickets.size();
    }

    public double getMedianPrice(List<Ticket> tickets) {
        Comparator<Ticket> comparator = Comparator.comparingInt(Ticket::getPrice);
        List<Ticket> sortedTickets = new ArrayList<>(tickets);
        sortedTickets.sort(comparator);

        int size = tickets.size();
        if (size % 2 == 1) {
            return sortedTickets.get(size / 2).getPrice();
        }
        return (sortedTickets.get(size / 2 - 1).getPrice() + sortedTickets.get(size / 2).getPrice()) / 2.0;
    }
}

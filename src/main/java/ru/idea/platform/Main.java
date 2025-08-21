package ru.idea.platform;

import ru.idea.platform.model.Ticket;
import ru.idea.platform.service.TicketParser;
import ru.idea.platform.service.TicketService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        TicketParser parser = new TicketParser();

        List<Ticket> tickets = parser.parseJson(args[0]);
        List<Ticket> filteredTickets = tickets.stream()
                .filter(ticket -> ticket.getOriginName().equals("Владивосток"))
                .filter(ticket -> ticket.getDestinationName().equals("Тель-Авив"))
                .toList();

        TicketService ticketService = new TicketService();

        System.out.println("Минимальное время полета между Владивостоком и Тель-Авивом для каждого авиаперевозчика: ");
        Map<String, Long> minFlightDurations = ticketService.getMinFlightDurationByCarrier(filteredTickets);
        for (Map.Entry<String, Long> entry : minFlightDurations.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "мин");
        }

        System.out.println();
        double avgPrice = ticketService.getAvgPrice(filteredTickets);
        double medianPrice = ticketService.getMedianPrice(filteredTickets);
        System.out.println("Разницу между средней и медианной ценой для полета между Владивостоком и Тель-Авивом: " + Math.abs(avgPrice - medianPrice));
    }
}

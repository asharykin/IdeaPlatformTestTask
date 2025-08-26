package ru.idea.platform.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.idea.platform.model.Ticket;
import ru.idea.platform.model.TicketComposite;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TicketParser {

    private ObjectMapper mapper;

    public TicketParser() {
        this.mapper = new ObjectMapper();
    }

    public List<Ticket> parseJson(String fileName) throws IOException {
        File file = new File(fileName);
        TicketComposite ticketComposite = mapper.readValue(file, TicketComposite.class);
        return ticketComposite.getTickets();
    }
}

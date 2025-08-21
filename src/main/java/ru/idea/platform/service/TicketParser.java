package ru.idea.platform.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.idea.platform.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TicketParser {

    public List<Ticket> parseJson(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String ticketsJsonList = mapper.readTree(new File(fileName)).get("tickets").toString();
        return mapper.readValue(ticketsJsonList, new TypeReference<>() {});
    }
}

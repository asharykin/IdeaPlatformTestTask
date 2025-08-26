package ru.idea.platform.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.idea.platform.model.TicketComposite;

import java.io.File;
import java.io.IOException;

public class TicketParser {

    private ObjectMapper mapper;

    public TicketParser() {
        this.mapper = new ObjectMapper();
    }

    public TicketComposite parseJson(String fileName) throws IOException {
        File file = new File(fileName);
        return mapper.readValue(file, TicketComposite.class);
    }
}

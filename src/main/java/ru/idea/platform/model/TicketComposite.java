package ru.idea.platform.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketComposite {

    private List<Ticket> tickets;
}

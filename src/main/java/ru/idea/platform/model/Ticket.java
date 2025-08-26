package ru.idea.platform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

@Getter
@Setter
@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    public String departureDate;
    public String departureTime;
    public String arrivalDate;
    public String arrivalTime;
    private String carrier;
    private int stops;
    private int price;

    public long getFlightDuration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy [H][HH]:mm");
        LocalDateTime departure = LocalDateTime.parse(this.departureDate + " " + this.departureTime, formatter);
        LocalDateTime arrival = LocalDateTime.parse(this.arrivalDate + " " + this.arrivalTime, formatter);
        return Duration.between(departure, arrival).toMinutes();
    }
}

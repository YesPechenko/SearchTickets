package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class FlightTicketOffer implements Comparable <FlightTicketOffer> {
    private int id;
    private int value;
    private String airportFrom;
    private String airportTo;
    private int travelTime;


    @Override
    public int compareTo(FlightTicketOffer o) {
        return value - o.value;
    }
}



package ru.netology.manager;

import ru.netology.domain.FlightTicketOffer;
import ru.netology.repository.FlightTicketOfferRepository;

import java.util.Arrays;


public class FlightTicketOfferManager {
    private FlightTicketOfferRepository repository;

    public FlightTicketOfferManager() {

    }

    public FlightTicketOfferManager(FlightTicketOfferRepository repository) {
        this.repository = repository;
    }

    public void add(FlightTicketOffer item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public FlightTicketOffer [] findAll(String from, String to) {
        FlightTicketOffer[] result = new FlightTicketOffer[0];
        for (FlightTicketOffer ticket : repository.findAll()) {
            if (from.equals( ticket.getAirportFrom()) && to.equals(ticket.getAirportTo())) {

                FlightTicketOffer[] tmp = new FlightTicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
    }
            Arrays.sort(result);
            return result;
    }
}






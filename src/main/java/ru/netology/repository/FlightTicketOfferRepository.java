package ru.netology.repository;

import ru.netology.domain.FlightTicketOffer;

public class FlightTicketOfferRepository {
    private FlightTicketOffer[] items  = new FlightTicketOffer[0];



    public void save(FlightTicketOffer item) {
        int length = items.length + 1;
        FlightTicketOffer[] tmp = new FlightTicketOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public FlightTicketOffer[] findAll() {
        return items;
    }

    public FlightTicketOffer findById(int id) {
        for (FlightTicketOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
            int length = items.length - 1;
        FlightTicketOffer[] tmp = new FlightTicketOffer[length];
            int index = 0;
            for (FlightTicketOffer item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
}


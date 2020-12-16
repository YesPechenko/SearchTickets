package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightTicketOffer;
import ru.netology.repository.FlightTicketOfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class FlightTicketOfferManagerTest {
    FlightTicketOfferRepository repository = new FlightTicketOfferRepository();
    FlightTicketOfferManager manager = new FlightTicketOfferManager(repository);
    FlightTicketOffer first = new FlightTicketOffer(1, 999, "LED", "DME", 90);
    FlightTicketOffer second = new FlightTicketOffer(2, 2_999, "LED", "GOJ", 150);
    FlightTicketOffer third = new FlightTicketOffer(3, 999, "VKO", "LED", 90);
    FlightTicketOffer fourth = new FlightTicketOffer (4, 999, "VKO", "LED", 90);
    FlightTicketOffer fifth = new FlightTicketOffer(5, 1_999, "DME", "LED", 90);
    FlightTicketOffer sixth = new FlightTicketOffer(6, 5_999, "KUF", "LED", 180);


    @Test
    public void shouldSearchSome() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        repository.removeById(6);
        FlightTicketOffer[] actual = repository.findAll();
        FlightTicketOffer[] expected = new FlightTicketOffer[] {first, second,third, fourth,fifth};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchValue() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        FlightTicketOffer[] actual = manager.findAll("VKO", "LED");
        FlightTicketOffer[] expected = new FlightTicketOffer[] {third, fourth};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void shouldSearchAlone() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        FlightTicketOffer[] actual = manager.findAll("DME", "LED");
        FlightTicketOffer[] expected = new FlightTicketOffer[] {fifth};
        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSearchSame() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        FlightTicketOffer[] actual = manager.findAll("VKO", "LED");
        FlightTicketOffer[] expected = new FlightTicketOffer[] {third, fourth};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNoFlights() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        FlightTicketOffer[] actual = manager.findAll("GOJ", "LED");
        FlightTicketOffer[] expected = new FlightTicketOffer[] {};
        assertArrayEquals(expected, actual);

    }

}
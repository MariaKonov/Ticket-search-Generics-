package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, "Moscow", "Volgograd", 200);
    Ticket ticket2 = new Ticket(2, "Moscow", "Volgograd", 100);
    Ticket ticket3 = new Ticket(3, "Moscow", "SPB", 200);
    Ticket ticket4 = new Ticket(4, "Moscow", "Volgograd", 400);
    Ticket ticket5 = new Ticket(5, "SPB", "Volgograd", 800);
    Ticket ticket6 = new Ticket(6, "Moscow", "Volgograd", 200);
    Ticket ticket7 = new Ticket(10, "LA", "SPB", 300);
    Ticket ticket8 = new Ticket(8, "Moscow", "Volgograd", 500);

    @Test
    public void searchingForOneFromTo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.findAll("LA", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = manager.findAll("Moscow", "Volgograd");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAndGetAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void weDoNotFindFromTo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Moscow", "RRR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void weDoNotFindToFrom() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("RRR", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkingForIncorrectFromTo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("RRR", "EEE");

        Assertions.assertArrayEquals(expected, actual);
    }
}
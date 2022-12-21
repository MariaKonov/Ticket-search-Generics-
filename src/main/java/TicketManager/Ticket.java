package TicketManager;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private String from;
    private String to;
    private int price;

    public Ticket(int id, String from, String to, int price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (this.getPrice() < otherTicket.getPrice()) {
            return -1;
        }
        if (this.getPrice() > otherTicket.getPrice()) {
            return 1;
        }
        return 0;
    }
}

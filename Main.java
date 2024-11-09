// Main.java
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer('A', "Ayesha");
        Agent agent = new Agent(101, "Agent Smith");
        BookingCounter counter = new BookingCounter();

        customer.searchTicket("Karachi", "Islamabad", "2024-11-04");
        counter.processBooking(customer, "Karachi", "Islamabad", "2024-11-04", "10:00 AM", 'B', '5');
        customer.makePayment(150.0f);
        customer.cancelTicket();

        Refund refund = new Refund(150.0f);
        refund.processRefund();
    }
}

interface CommonFunctions {
    boolean searchTicket(String source, String destination, String dateOfJourney);
    Ticket bookTicket(String source, String destination, String dateOfJourney, String time, char busNo, char seatNo);
    boolean cancelTicket();
    boolean makePayment(float amount);
}

class Customer implements CommonFunctions {
    private char customerId;
    private String name;
    private Ticket currentTicket;

    public Customer(char customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    @Override
    public boolean searchTicket(String source, String destination, String dateOfJourney) {
        System.out.println("Searching tickets from " + source + " to " + destination + " on " + dateOfJourney);
        return true;
    }

    @Override
    public Ticket bookTicket(String source, String destination, String dateOfJourney, String time, char busNo, char seatNo) {
        currentTicket = new Ticket(source, destination, dateOfJourney, time, busNo, seatNo);
        System.out.println("Ticket booked for " + name);
        return currentTicket;
    }

    @Override
    public boolean cancelTicket() {
        if (currentTicket != null) {
            System.out.println("Ticket canceled for " + name);
            currentTicket = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean makePayment(float amount) {
        System.out.println("Payment of $" + amount + " made for " + name);
        return true;
    }
}

class Agent implements CommonFunctions {
    private int id;
    private String name;

    public Agent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean searchTicket(String source, String destination, String dateOfJourney) {
        System.out.println("Agent " + name + " searches tickets from " + source + " to " + destination);
        return true;
    }

    @Override
    public Ticket bookTicket(String source, String destination, String dateOfJourney, String time, char busNo, char seatNo) {
        System.out.println("Agent " + name + " books a ticket.");
        return new Ticket(source, destination, dateOfJourney, time, busNo, seatNo);
    }

    @Override
    public boolean cancelTicket() {
        System.out.println("Agent " + name + " cancels a ticket.");
        return true;
    }

    @Override
    public boolean makePayment(float amount) {
        System.out.println("Agent " + name + " processes payment of $" + amount);
        return true;
    }
}

class Ticket {
    private String source;
    private String destination;
    private String dateOfJourney;
    private String time;
    private char busNo;
    private char seatNo;

    public Ticket(String source, String destination, String dateOfJourney, String time, char busNo, char seatNo) {
        this.source = source;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.time = time;
        this.busNo = busNo;
        this.seatNo = seatNo;
    }

    public void display() {
        System.out.println("Ticket Info: " + source + " to " + destination + " on " + dateOfJourney + " at " + time);
    }
}

class Refund {
    private float amount;

    public Refund(float amount) {
        this.amount = amount;
    }

    public void processRefund() {
        System.out.println("Refunded $" + amount);
    }
}

class BookingCounter {
    public void processBooking(Customer customer, String source, String destination, String dateOfJourney, String time, char busNo, char seatNo) {
        Ticket ticket = customer.bookTicket(source, destination, dateOfJourney, time, busNo, seatNo);
        ticket.display();
    }
}

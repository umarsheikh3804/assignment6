package assignment6;

import assignment6.Seat.SeatType;
import assignment6.Seat.SeatLetter;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTheater {

    private int printDelay;
    private SalesLogs log;
    private Map<SeatType, List<Seat>> seats;

    
    /**
     * Constructs a MovieTheater, where there are a set number of rows per seat type.
     *
     * @param rumbleNum the number of rows with rumble seats.
     * @param comfortNum the number of rows with comfort seats.
     * @param standardNum the number of rows with standard seats.
     */
    public MovieTheater(int rumbleNum, int comfortNum, int standardNum){
        printDelay = 10;
        log = new SalesLogs();
        // TODO: Finish implementing this constructor.
        seats = new HashMap<>();
        initSeats(seats, rumbleNum, SeatType.RUMBLE, 0);
        initSeats(seats, comfortNum, SeatType.COMFORT, rumbleNum);
        initSeats(seats, standardNum, SeatType.STANDARD, comfortNum + rumbleNum);

    }

    public boolean theaterEmpty() {
        return (seats.get(SeatType.RUMBLE).isEmpty()) && (seats.get(SeatType.COMFORT).isEmpty()) && (seats.get(SeatType.STANDARD).isEmpty());
    }

    private void initSeats(Map<SeatType, List<Seat>> seats, int rows, SeatType type, int startRow) {
        List<Seat> list = new ArrayList<>();
        for (int i = 1; i < rows + 1; i++) {
            list.add(new Seat(type, startRow + i, SeatLetter.A));
            list.add(new Seat(type, startRow + i, SeatLetter.B));
            list.add(new Seat(type, startRow + i, SeatLetter.C));
            list.add(new Seat(type, startRow + i, SeatLetter.D));
            list.add(new Seat(type, startRow + i, SeatLetter.E));
            list.add(new Seat(type, startRow + i, SeatLetter.F));
        }
        seats.put(type, list);
    }

    public void checkMovieTheater() {
        int rumbles = 0;
        int comforts = 0;
        int standards = 0;
        for (SeatType t : seats.keySet()) {
            for (Seat s : seats.get(t)) {
                if (s.getSeatType() == SeatType.RUMBLE) {
                    rumbles++;
                } else if (s.getSeatType() == SeatType.COMFORT) {
                    comforts++;
                } else {
                    standards++;
                }
//                System.out.println(s);
            }
        }
        System.out.println("# of Rumble Seats: " + rumbles);
        System.out.println("# of Comfort Seats: " + comforts);
        System.out.println("# of Standard Seats: " + standards);
    }

    /**
     * Returns the next available seat not yet reserved for a given seat type.
     *
     * @param seatType the type of seat (RUMBLE, COMFORT, STANDARD).
     * @return the next available seat or null if the theater is full.
     */
    public Seat getNextAvailableSeat(SeatType seatType) {
        // TODO: Implement this method.
//        List<Seat> sl = log.getSeatLog();
//        the theater is full
        if (theaterEmpty()) {
            return null;
        }

        Seat nextSeat = dfsHelper(seatType);
        if (nextSeat != null) {
            log.addSeat(nextSeat);
        }
        return nextSeat;

    }

    private Seat dfsHelper(SeatType type) {
        if (type == null) {
            return null;
        }
        if (seats.get(type).isEmpty()) {
            return dfsHelper(nextType(type));
        }
        return seats.get(type).remove(0);
    }

    private SeatType nextType(SeatType type) {
        if (type == SeatType.RUMBLE) {
            return SeatType.COMFORT;
        } else if (type == SeatType.COMFORT) {
            return SeatType.STANDARD;
        } else {
            return null;
        }
    }

    /**
     * Prints a ticket to the console for the customer after they reserve a seat.
     *
     * @param boothId id of the ticket booth.
     * @param seat a particular seat in the theater.
     * @return a movie ticket or null if a ticket booth failed to reserve the seat.
     */
    public Ticket printTicket(String boothId, Seat seat, int customer) {
        // TODO: Implement this method.
        Object lock = new Object();
        if (boothId == null || seat == null) {
            return null;
        }

        Ticket t = new Ticket(boothId, seat, customer);
//        synchronize only on this part because the console and log (shared resources) are affected
//        we don't want to synchronize the whole method because different threads should be able to call this method at the same time
        synchronized (lock) {
            log.addTicket(t);
//            log.addSeat(seat);
            System.out.println(t);
        }

        try {
            Thread.sleep(printDelay);
        } catch (InterruptedException ie) {}

        return t;

    }
    
    /**
     * Lists all seats sold for the movie in the order of reservation.
     *
     * @return list of seats sold.
     */
    public List<Seat> getSeatLog() {
        // TODO: Implement this method.
        return log.getSeatLog();
    }

    /**
     * Lists all tickets sold for the movie in order of printing.
     *
     * @return list of tickets sold.
     */
    public List<Ticket> getTransactionLog() {
        // TODO: Implement this method.
        return log.getTicketLog();
    }

    static class SalesLogs {

        private ArrayList<Seat> seatLog;
        private ArrayList<Ticket> ticketLog;

        private SalesLogs() {
            seatLog = new ArrayList<Seat>();
            ticketLog = new ArrayList<Ticket>();
        }

        public List<Seat> getSeatLog() {
            return (List<Seat>)(seatLog.clone());
        }

        public List<Ticket> getTicketLog() {
            return (List<Ticket>)(ticketLog.clone());
        }

        public void addSeat(Seat s) {
            seatLog.add(s);
        }

        public void addTicket(Ticket t) {
            ticketLog.add(t);
        }
    }
}

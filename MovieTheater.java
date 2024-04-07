package assignment6;

import assignment6.Seat.SeatType;
import assignment6.Seat.SeatLetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieTheater {

    private int printDelay;
    private SalesLogs log;
    private Seat[][] seats;
    private int rumbleNum, comfortNum, standardNum;
    
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
        seats = new Seat[rumbleNum + comfortNum + standardNum][6];
        int currRow = 0;
        this.rumbleNum = rumbleNum;
        this.comfortNum = comfortNum;
        this.standardNum = standardNum;
        initSeats(seats, this.rumbleNum, SeatType.RUMBLE, currRow);
        initSeats(seats, this.comfortNum, SeatType.COMFORT, currRow);
        initSeats(seats, this.standardNum, SeatType.STANDARD, currRow);

    }

    private void initSeats(Seat[][] seats, int rows, SeatType type, int currRow) {
        while (currRow < currRow + rows) {
            seats[currRow][0] = new Seat(type, currRow, SeatLetter.A);
            seats[currRow][1] = new Seat(type, currRow, SeatLetter.B);
            seats[currRow][2] = new Seat(type, currRow, SeatLetter.C);
            seats[currRow][3] = new Seat(type, currRow, SeatLetter.D);
            seats[currRow][4] = new Seat(type, currRow, SeatLetter.E);
            seats[currRow][5] = new Seat(type, currRow, SeatLetter.F);
            currRow += 1;
        }
    }

    /**
     * Returns the next available seat not yet reserved for a given seat type.
     *
     * @param seatType the type of seat (RUMBLE, COMFORT, STANDARD).
     * @return the next available seat or null if the theater is full.
     */
    public Seat getNextAvailableSeat(SeatType seatType) {
        // TODO: Implement this method.
        List<Seat> sl = log.getSeatLog();
//        the theater is full
        if (sl.size() == seats.length * seats[0].length) {
            return null;
        }

//        traverse seat log backwards to find most recent seat sold of type seatType
        for (int i = sl.size() - 1; i >= 0; i--) {
            if (sl.get(i).getSeatType() == seatType) {
//                get most recent seat
                Seat previous = sl.get(i);
                int next = (previous.getRow() * 6) + (previous.getLetter().getIntValue() + 1);
                return seats[next / 6][next % 6];
            }
        }
//        no seat of type seatType sold -> return first seat of type seatType
        if (seatType == SeatType.RUMBLE.) {
            return seats[0][0];
        } else if (seatType == SeatType.COMFORT) {
            return seats[rumbleNum][0];
        } else {
            return seats[rumbleNum + comfortNum][0];
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
        Ticket t = new Ticket(boothId, seat, customer);
        System.out.println(t);
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

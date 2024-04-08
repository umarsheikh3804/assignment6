package assignment6;

import assignment6.Seat.SeatType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class Cinema {

    private MovieTheater movieTheater;
    private final Map<String, SeatType[]> booths;

    /**
     * Constructor to initilize the simulation based on starter parameters. 
     * 
     * @param booths maps ticket booth id to seat type preferences of customers in line.
     * @param movieTheater the theater for which tickets are sold.
     */
    public Cinema(Map<String, SeatType[]> booths, MovieTheater movieTheater) {
        // TODO: Implement this constructor
        this.booths = booths;
        this.movieTheater = movieTheater;

    }

    /**
     * Starts the ticket office simulation by creating (and starting) threads
     * for each ticket booth to sell tickets for the given movie.
     *
     * @return list of threads used in the simulation,
     *   should have as many threads as there are ticket booths.
     */
    public List<Thread> simulate() {
        List<Thread> threads = new ArrayList<>();
        Object lock1 = new Object();
        AtomicInteger customerID = new AtomicInteger(0);
        // TODO: Implement this method.
        for (final String s : booths.keySet()) {
            final SeatType[] customers = booths.get(s);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Seat next;
                    for (int index = 0; index < customers.length && !movieTheater.theaterEmpty(); index++) {
//                        want to avoid having 2 threads getNextAvailableSeat() at the same time
                        synchronized (lock1) {
                            next = movieTheater.getNextAvailableSeat(customers[index]);
                            customerID.getAndIncrement();
                        }

//                        can print tickets simultaneously
//                        this is guaranteed to happen after the synchronized blocks
                        movieTheater.printTicket(s, next, customerID.intValue());

                    }
                }

            });
            t.start();
            threads.add(t);
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException ie) {};

        return threads;
    }

    public static void main(String[] args) {
        // For your testing purposes. We will not call this method.
        Map < String , SeatType [] > booths = new HashMap< String , SeatType [] >();
        booths . put ( "TO1" , new SeatType [] { SeatType . COMFORT , SeatType . COMFORT , SeatType . COMFORT });
        booths . put ( "TO3" , new SeatType [] { SeatType . COMFORT , SeatType . STANDARD , SeatType . STANDARD });
        booths . put ( "TO2" , new SeatType [] { SeatType . RUMBLE , SeatType . COMFORT ,
                SeatType . STANDARD , SeatType . STANDARD });
        booths . put ( "TO5" , new SeatType [] { SeatType . COMFORT , SeatType . COMFORT , SeatType . COMFORT });
        booths . put ( "TO4" , new SeatType [] { SeatType . STANDARD , SeatType . STANDARD , SeatType . STANDARD });
        Cinema client = new Cinema ( booths , new MovieTheater (1 , 1 , 1));
        client . simulate ();
        client.movieTheater.checkMovieTheater();
    }
}

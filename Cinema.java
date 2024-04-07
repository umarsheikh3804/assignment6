package assignment6;

import assignment6.Seat.SeatType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cinema {

    private MovieTheater movieTheater;
    private Map<String, SeatType[]> booths;

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
        // TODO: Implement this method.
        for (String s : booths.keySet()) {
            final SeatType[] customers = booths.get(s);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int current = 0;
                    while (current < customers.length && movieTheater.) {
                        if (movieTheater.getNextAvailableSeat(customers[current]) != null) {

                        }
                    }
                }

            });
            t.start();
        }

        return threads;
    }

    public static void main(String[] args) {
        // For your testing purposes. We will not call this method.        
    }
}

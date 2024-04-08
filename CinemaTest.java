package assignment6;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CinemaTest {

    // Write your JUnit tests here
//    also need to check if there is unique IDs and seats sold
    @Test
    public void test1() {
        // For your testing purposes. We will not call this method.
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 2;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        assertArrayEquals(getExpectedRemaining(booths, rumbleRows, comfortRows, standardRows), getActualRemaining(theater.getSeatLog(), rumbleRows, comfortRows, standardRows));

    }

    @Test
    public void seatCheck1() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 2;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Seat> seatLog = theater.getSeatLog();
        Set<Seat> set = new HashSet<>();
        boolean unique = true;
        for (Seat s : seatLog) {
            if (set.contains(s)) {
                unique = false;
            }
            set.add(s);
        }

        assertTrue(unique);
    }

    @Test
    public void idCheck1() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 2;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Ticket> ticketLog = theater.getTransactionLog();
        Set<Integer> set = new HashSet<>();
        boolean unique = true;
        for (Ticket t : ticketLog) {
            if (set.contains(t.getCustomer())) {
                unique = false;
            }
            set.add(t.getCustomer());
        }

        assertTrue(unique);
    }

    @Test
    public void test2() {
        // For your testing purposes. We will not call this method.
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 1;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        assertArrayEquals(getExpectedRemaining(booths, rumbleRows, comfortRows, standardRows), getActualRemaining(theater.getSeatLog(), rumbleRows, comfortRows, standardRows));

    }

    @Test
    public void seatCheck2() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 1;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Seat> seatLog = theater.getSeatLog();
        Set<Seat> set = new HashSet<>();
        boolean unique = true;
        for (Seat s : seatLog) {
            if (set.contains(s)) {
                unique = false;
            }
            set.add(s);
        }

        assertTrue(unique);
    }

    @Test
    public void idCheck2() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 1;
        int comfortRows = 1;
        int standardRows = 1;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.STANDARD, Seat.SeatType.STANDARD});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Ticket> ticketLog = theater.getTransactionLog();
        Set<Integer> set = new HashSet<>();
        boolean unique = true;
        for (Ticket t : ticketLog) {
            if (set.contains(t.getCustomer())) {
                unique = false;
            }
            set.add(t.getCustomer());
        }

        assertTrue(unique);
    }

    @Test
    public void test3() {
        // For your testing purposes. We will not call this method.
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO7", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO8", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO9", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("T10", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("T11", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("T12", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        assertArrayEquals(getExpectedRemaining(booths, rumbleRows, comfortRows, standardRows), getActualRemaining(theater.getSeatLog(), rumbleRows, comfortRows, standardRows));

    }

    @Test
    public void seatCheck3() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO7", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO8", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO9", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("T10", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("T11", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("T12", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Seat> seatLog = theater.getSeatLog();
        Set<Seat> set = new HashSet<>();
        boolean unique = true;
        for (Seat s : seatLog) {
            if (set.contains(s)) {
                unique = false;
            }
            set.add(s);
        }

        assertTrue(unique);
    }

//    for some reason this check is failing
    @Test
    public void idCheck3() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO2", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO3", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO4", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("TO5", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO6", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("TO7", new Seat.SeatType[]{Seat.SeatType.COMFORT});
        booths.put("TO8", new Seat.SeatType[]{Seat.SeatType.RUMBLE, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("TO9", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE});
        booths.put("T10", new Seat.SeatType[]{Seat.SeatType.STANDARD});
        booths.put("T11", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});
        booths.put("T12", new Seat.SeatType[]{Seat.SeatType.STANDARD, Seat.SeatType.RUMBLE, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Ticket> ticketLog = theater.getTransactionLog();
        Set<Integer> set = new HashSet<>();
        boolean unique = true;
        for (Ticket t : ticketLog) {
            if (set.contains(t.getCustomer())) {
                unique = false;
            }
            set.add(t.getCustomer());
        }

        assertTrue(unique);
    }

    @Test
    public void test4() {
        // For your testing purposes. We will not call this method.
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        assertArrayEquals(getExpectedRemaining(booths, rumbleRows, comfortRows, standardRows), getActualRemaining(theater.getSeatLog(), rumbleRows, comfortRows, standardRows));

    }

    @Test
    public void seatCheck4() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Seat> seatLog = theater.getSeatLog();
        Set<Seat> set = new HashSet<>();
        boolean unique = true;
        for (Seat s : seatLog) {
            if (set.contains(s)) {
                unique = false;
            }
            set.add(s);
        }

        assertTrue(unique);
    }

    @Test
    public void idCheck4() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 3;
        int comfortRows = 5;
        int standardRows = 6;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Ticket> ticketLog = theater.getTransactionLog();
        Set<Integer> set = new HashSet<>();
        boolean unique = true;
        for (Ticket t : ticketLog) {
            if (set.contains(t.getCustomer())) {
                unique = false;
            }
            set.add(t.getCustomer());
        }

        assertTrue(unique);
    }


    @Test
    public void test5() {
        // For your testing purposes. We will not call this method.
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 0;
        int comfortRows = 0;
        int standardRows = 0;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        assertArrayEquals(getExpectedRemaining(booths, rumbleRows, comfortRows, standardRows), getActualRemaining(theater.getSeatLog(), rumbleRows, comfortRows, standardRows));

    }

    @Test
    public void seatCheck5() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 0;
        int comfortRows = 0;
        int standardRows = 0;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Seat> seatLog = theater.getSeatLog();
        Set<Seat> set = new HashSet<>();
        boolean unique = true;
        for (Seat s : seatLog) {
            if (set.contains(s)) {
                unique = false;
            }
            set.add(s);
        }

        assertTrue(unique);
    }

    @Test
    public void idCheck5() {
        Map<String, Seat.SeatType[]> booths = new HashMap< String , Seat.SeatType[] >();
        int rumbleRows = 0;
        int comfortRows = 0;
        int standardRows = 0;

        booths.put("TO1", new Seat.SeatType[]{Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT,
                Seat.SeatType.COMFORT, Seat.SeatType.COMFORT, Seat.SeatType.COMFORT});

        MovieTheater theater = new MovieTheater(rumbleRows, comfortRows, standardRows);
        Cinema client = new Cinema(booths, theater);
        client.simulate();

        List<Ticket> ticketLog = theater.getTransactionLog();
        Set<Integer> set = new HashSet<>();
        boolean unique = true;
        for (Ticket t : ticketLog) {
            if (set.contains(t.getCustomer())) {
                unique = false;
            }
            set.add(t.getCustomer());
        }

        assertTrue(unique);
    }

    private int[] getActualRemaining(List<Seat> seatLog, int rumbleRows, int comfortRows, int standardRows) {
        int[] remaining = new int[]{rumbleRows * 6, comfortRows * 6, standardRows * 6};
        for (Seat s : seatLog) {
            if (s.getSeatType() == Seat.SeatType.RUMBLE) {
                remaining[0]--;
            } else if (s.getSeatType() == Seat.SeatType.COMFORT) {
                remaining[1]--;
            } else {
                remaining[2]--;
            }
        }
        return remaining;
    }

//    private helper methods to make testing easier
    private int[] getExpectedRemaining(Map<String, Seat.SeatType[]> booths, int rumbleRows, int comfortRows, int standardRows) {
        int[] remaining = new int[]{rumbleRows * 6, comfortRows * 6, standardRows * 6};
        for (String s : booths.keySet()) {
            for (Seat.SeatType type : booths.get(s)) {
                if (type == Seat.SeatType.RUMBLE) {
                    remaining[0]--;
                } else if (type == Seat.SeatType.COMFORT) {
                    remaining[1]--;
                } else {
                    remaining[2]--;
                }
            }
        }

//        adjust negatives by sliding to the right
        for (int i = 0; i < remaining.length-1; i++) {
            if (remaining[i] < 0) {
                remaining[i+1] += remaining[i];
                remaining[i] = 0;
            }
        }
        if (remaining[remaining.length-1] < 0) {
            remaining[remaining.length - 1] = 0;
        }
        return remaining;
    }




}

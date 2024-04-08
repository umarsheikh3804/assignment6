package assignment6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CinemaTest {

    // Write your JUnit tests here
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

        Cinema client = new Cinema(booths, new MovieTheater(rumbleRows, comfortRows, standardRows));
        client.simulate();
        assertArrayEquals(getRemaining(booths, rumbleRows, comfortRows, standardRows), client.returnNumberSeats());

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

        Cinema client = new Cinema(booths, new MovieTheater(rumbleRows, comfortRows, standardRows));
        client.simulate();
        assertArrayEquals(getRemaining(booths, rumbleRows, comfortRows, standardRows), client.returnNumberSeats());

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

        Cinema client = new Cinema(booths, new MovieTheater(rumbleRows, comfortRows, standardRows));
        client.simulate();
        assertArrayEquals(getRemaining(booths, rumbleRows, comfortRows, standardRows), client.returnNumberSeats());

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

        Cinema client = new Cinema(booths, new MovieTheater(rumbleRows, comfortRows, standardRows));
        client.simulate();
        assertArrayEquals(getRemaining(booths, rumbleRows, comfortRows, standardRows), client.returnNumberSeats());

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

        Cinema client = new Cinema(booths, new MovieTheater(rumbleRows, comfortRows, standardRows));
        client.simulate();
        assertArrayEquals(getRemaining(booths, rumbleRows, comfortRows, standardRows), client.returnNumberSeats());

    }


//    private helper methods to make testing easier

    private int[] getRemaining(Map<String, Seat.SeatType[]> booths, int rumbleRows, int comfortRows, int standardRows) {
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
        adjustNegatives(remaining);
        return remaining;
    }

    private void adjustNegatives(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < 0) {
                arr[i+1] += arr[i];
                arr[i] = 0;
            }
        }
        if (arr[arr.length-1] < 0) {
            arr[arr.length - 1] = 0;
        }
    }


}

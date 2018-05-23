package solution1;

import helper.CalendarEntry;

import java.util.ArrayList;

/**
 * This coding interview question gave me some difficulty, so I worked it
 * to repair my wounded pride
 *
 * PROBLEM
 * Take a list of calendar appointments and mark the appointments with conflicts.
 * Be as efficient as possible.
 *
 *
 * ASSUMPTIONS
 * Calendar entries are sorted by start time in increasing order.
 * Conflict occurs when
 * a.start <= b.start and a.start < b.end
 * OR
 * b.start <= a.start and b.start < a.end
 *
 *
 * DESIGN
 *
 * The key issue to contend with is that the end times are not sorted.  Start times can be searched
 * in O(log n) time, but not end times.
 *
 * Here we realize a truth that gives us an edge:
 * we can test
 *      b.start is between a.start and b.end
 *          separately from
 *      a.start is between b.start and a.end
 *
 *  This gives the advantage that when testing for conflicts with b, we do not need to search for end times in a
 *
 *  This relationship works because conflicted appointments are commutative
 *
 *  So, we can run through entries and test for conflicts by closest start time only,
 *  which is the next entry
 *
 *
 */



public class main {

    public static void main(String[] args){

        //assume data exists
        ArrayList<CalendarEntry> arr = new ArrayList<>();



    }

    int binarySearchNextHighestStartTime(int myIndex, ArrayList<CalendarEntry> arr, long startTime){
        //avoid overflow by dividing by 2 first
        long diff = startTime / 2 + endTime /2;
        int index = binarySearchClosest(arr, diff);


    }

    private int binarySearchClosest(ArrayList<CalendarEntry> arr, long target) {

        //want to find minimum difference, return leftmost if equal
        int left = 0;
        int right = arr.size() - 1;
        long difference = Long.MAX_VALUE;
        long tempDiff;


        // to prevent overflow;
        // (left%2 + right%2)/2  this adds one to division iff both are odd
        // which overcomes truncation of both odd numbers when divided by 2
        int next = (left + right)/2 + (left%2 + right%2)/2;

        int closest = next;

        tempDiff = arr.get(next).getStart() - target;




    }

    boolean isStartIn(long start, CalendarEntry ce){
        return (ce.getStart() <= start && start < ce.getEnd());
    }

}

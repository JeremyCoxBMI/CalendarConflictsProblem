package solution1;

import helper.CalendarEntry;

import java.util.ArrayList;

/**
 * This coding interview question gave me some difficulty, so I worked it
 * to repair my wounded pride
 *
 * PROBLEM
 * Take a list of calendar appointments and mark the appointments with conflicts (i.e. overlapping time).
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
 *  This relationship works because conflicted appointments are commutative.
 *  In otherwords, if we test a vs b and then b vs a,
 *
 *
 *  So, we can run through entries and test for conflicts by closest start time only,
 *  which is the next entry in the sorted list.
 *
 *
 */



public class main {

    public static void main(String[] args){

        //assume data exists
        ArrayList<CalendarEntry> arr = new ArrayList<>();

        for (int k=0; k < arr.size()-1; k++){
            if ( isStartIn(arr.get(k+1).getStart(),arr.get(k))){
                arr.get(k).setConflict(true);
                arr.get(k+1).setConflict(true);
            }
        }
    }

    static boolean isStartIn(long start, CalendarEntry ce){
        return (ce.getStart() <= start && start < ce.getEnd());
    }

}

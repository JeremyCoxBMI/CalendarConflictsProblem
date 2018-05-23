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

 * if we parse over the array using adjacent pairs, we know we have the
 * second entr (b) y is the closest start time after the first entry (a)
 *
 * Thus
 *      a.start is between b.start and b.end is always FALSE
 *
 *      so we need only test
 *
 *      b.start is between a.start and a.end
 *
 *  What if we loop and just check the next entry as a conflict?
 *      Is it possible that out of three entries, a, b, and c that c conflicts with a, but not b?
 *
 *  if b does not conflict with c,
 *      then c.start >= b.end
 *  if c conflicts with a,
 *      then a.start <= c.start and c.start < a.end
 *
 *  if b.end < a.end, this case is entirely possible
 *  therefore, we cannot strictly just do the next comparison
 *
 * Strictyly speaking, this runs in O(n^2) time,
 * but because P(conflict between and b) is very small, we expect much better average time
 *
 *
 */



public class main {

    public static void main(String[] args){

        //assume data exists
        ArrayList<CalendarEntry> arr = new ArrayList<>();

        for (int k=0; k < arr.size()-1; k++){
            //we already know that arr.get(k).getStart() <= arr.get(j).getStart()
            for (int j = k + 1; arr.get(j).getStart() < arr.get(k).getEnd() && j < arr.size() ; j++) {
                    arr.get(k).setConflict(true);
                    arr.get(j).setConflict(true);
            }
        }
    }

    static boolean isStartIn(long start, CalendarEntry ce){
        return (ce.getStart() <= start && start < ce.getEnd());
    }

}

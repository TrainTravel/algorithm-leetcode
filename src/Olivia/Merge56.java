package Olivia;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Merge56 {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }}

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        for(int i=0;i<intervals.size();i++){
            if(i>0&&intervals.get(i).start>=result.get(result.size()-1).start&&intervals.get(i).start<=result.get(result.size()-1).end){
                Interval cur  = new Interval(Math.min(result.get(result.size()-1).start,intervals.get(i).start),Math.max(result.get(result.size()-1).end,intervals.get(i).end));
                result.remove(result.size()-1);
                result.add(cur);
            }
            else{
                result.add(intervals.get(i));
            }
        }
        return result;

    }
}

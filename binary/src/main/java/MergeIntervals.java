import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruimin Wu
 * @date 2021-06-04 23:21
 **/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1],intervals[i][1]) ;
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}

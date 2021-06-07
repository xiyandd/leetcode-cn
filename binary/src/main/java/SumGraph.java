import java.util.*;

/**
 * @author Ruimin Wu
 * @date 2021-06-07 22:25
 **/
public class SumGraph {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ints = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            ints[prerequisite[0]]++;
            if (map.containsKey(prerequisite[1])) {
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = map.get(poll);
            if (list != null) {
                for (Integer integer : list) {
                    ints[integer]--;
                    if (ints[integer] == 0) {
                        queue.add(integer);
                    }
                }
            }

        }
        boolean flag = true;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                flag =  false;
            }
        }
        return flag;
    }
}

import java.util.TreeMap;

/**
 * @author Ruimin Wu
 * @date 2021-05-29 18:43
 **/
public class RangeModule {

    public static void main(String[] args) {

    }

    TreeMap<Integer, Integer> treeMap;

    public RangeModule() {
        this.treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (left > right) {
            return;
        }
        Integer start = treeMap.floorKey(left);
        if (start == null) {
            start = treeMap.ceilingKey(left);
        }
        while (start != null&&start<right) {
            Integer end = treeMap.get(start);
            if (end >= left) {
                treeMap.remove(start);
                if (start<left) left = start;
                if (end>right) right = end;
            }
            start=treeMap.ceilingKey(end);
        }
        treeMap.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer floorKey = treeMap.floorKey(left);
        if (floorKey == null) {
            return false;
        }
        Integer end = treeMap.get(floorKey);
        return end >= right;
    }

    public void removeRange(int left, int right) {
        if (left > right) {
            return;
        }
        Integer start = treeMap.floorKey(left);
        if (start == null) {
            start = treeMap.ceilingKey(left);
        }
        while (start != null&&start<right) {
            Integer end = treeMap.get(start);
            if (end >= left) {
                treeMap.remove(start);
                if (start<left) treeMap.put(start,left);
                if (end>right) treeMap.put(right,end);
            }
            start=treeMap.ceilingKey(end);
        }
    }
}


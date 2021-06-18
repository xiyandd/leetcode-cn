/**
 * @author Ruimin Wu
 * @date 2021-06-17 22:27
 **/
public class removeElement27 {

    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}

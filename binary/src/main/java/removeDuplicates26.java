/**
 * @author Ruimin Wu
 * @date 2021-06-17 23:16
 **/
public class removeDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                start++;
                nums[start] = nums[i];
            }
        }
        return start;
    }

}

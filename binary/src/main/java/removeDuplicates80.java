/**
 * @author Ruimin Wu
 * @date 2021-06-17 23:22
 **/
public class removeDuplicates80 {
    public int removeDuplicates(int[] nums) {
        int start = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[start-2] != nums[i]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}

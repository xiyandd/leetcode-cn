/**
 * @author Ruimin Wu
 * @date 2021-06-17 23:04
 **/
public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }
        for (int i = start+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

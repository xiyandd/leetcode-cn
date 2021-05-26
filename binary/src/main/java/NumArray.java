//给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
//
// 实现 NumArray 类：
//
//
//
//
// NumArray(int[] nums) 用整数数组 nums 初始化对象
// void update(int index, int val) 将 nums[index] 的值更新为 val
// int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] +
//nums[left + 1], ..., nums[right]）
//
//
//
//
// 示例：
//
//
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// 0 <= index < nums.length
// -100 <= val <= 100
// 0 <= left <= right < nums.length
// 最多调用 3 * 104 次 update 和 sumRange 方法
//
//
//
// Related Topics 树状数组 线段树
// 👍 270 👎 0


import org.jeasy.random.EasyRandom;

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    private SegmentTreeNode root;

    public static void main(String[] args) {

        EasyRandom easyRandom = new EasyRandom();
        int[] ints = easyRandom.nextObject(int[].class);
        NumArray numArray = new NumArray(ints);

        int i = numArray.sumRange(numArray.root, 1, 4);
        System.out.println(i);

    }

    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(SegmentTreeNode root,int i, int val) {
        if (root.start == root.end) {
            root.val = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i < mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.val = root.left.val + root.right.val;
    }

    public int sumRange(SegmentTreeNode root,int start, int end) {
        if (root.end == end && root.start == start) {
            return root.val;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start >= mid + 1) {
            return sumRange(root.right, start, end);
        } else {
            return sumRange(root.right, mid + 1, end)+ sumRange(root.left, start, mid)  ;
        }
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.val = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.val = node.left.val + node.right.val;
        }
        return node;
    }

    class SegmentTreeNode{
        int start;
        int end;
        int val;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.val = 0;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

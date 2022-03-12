import java.util.LinkedList;
import java.util.List;

public class Solution315 {
    // -10^4 <= nums[i] <= 10^4
    private static final int OFFSET = 10001;

    public List<Integer> countSmaller(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int len = nums.length;
        LinkedList<Integer> resList = new LinkedList<>();
        BinaryIndexedTree bit = new BinaryIndexedTree(max + OFFSET);
        for (int i = len - 1; i >= 0; i--) {
            bit.update(nums[i] + OFFSET);
            // 头插法
            resList.offerFirst(bit.query(nums[i] - 1 + OFFSET));
        }
        return resList;
    }

    private static class BinaryIndexedTree {
        private final int n;
        private final int[] tree;

        public BinaryIndexedTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
315. 计算右侧小于当前元素的个数
https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/

给定一个整数数组 nums，按要求返回一个新数组counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

树状数组。
nums = [3,9,5,2,6,1,3] 后往前遍历，转化为前缀和
桶 1 2 3 4 5 6 7 8 9
   0 0 1 0 0 0 0 0 0 [0]
   1 0 1 0 0 0 0 0 0 [0,0]
   1 0 1 0 0 1 0 0 0 [2,0,0]
   1 1 1 0 0 1 0 0 0 [1,2,0,0]
   1 1 1 0 1 1 0 0 0 [3,1,2,0,0]
   1 1 1 0 1 1 0 0 1 [5,3,1,2,0,0]
   1 1 2 0 1 1 0 0 1 [2,5,3,1,2,0,0]
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 剑指 Offer 51. 数组中的逆序对
https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
import java.util.Arrays;

public class SolutionO51 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
        return ans;
    }

    private static class BIT {
        private int[] tree;
        private int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public int query(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowbit(x);
            }
            return ret;
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }
    }
}
/*
剑指 Offer 51. 数组中的逆序对
https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
输入: [7,5,6,4]
输出: 5

离散化树状数组。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */
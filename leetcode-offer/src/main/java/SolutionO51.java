import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionO51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        // 离散化 去重+排序
//        int[] discretization = Arrays.stream(nums).distinct().sorted().toArray();
        int[] discretization = discretization(nums);

        int cnt = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(discretization.length);
        for (int i = len - 1; i >= 0; i--) {
            int discretizedId = Arrays.binarySearch(discretization, nums[i]) + 1;
            bit.update(discretizedId);
            cnt += bit.query(discretizedId - 1);
        }
        return cnt;
    }

    private int[] discretization(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int size = hashSet.size();
        int[] res = new int[size];
        int idx = 0;
        for (int num : hashSet) {
            res[idx++] = num;
        }
        Arrays.sort(res);
        return res;
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
剑指 Offer 51. 数组中的逆序对
https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
输入: [7,5,6,4]
输出: 5
限制：
0 <= 数组长度 <= 50000

离散化树状数组。注意本题没有给出 nums[i] 的范围，有可能存在负数，因此需要用到离散化。
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 315. 计算右侧小于当前元素的个数
https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionO51 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        // 离散化
        int[] yArr = getDiscrete(nums);

        int res = 0;
        Fenwick fenwick = new Fenwick(yArr.length);
        for (int i = n - 1; i >= 0; i--) {
            int yId = getId(yArr, nums[i]);
            fenwick.add(yId, 1);
            res += fenwick.getSum(yId - 1);
        }
        return res;
    }

    private int[] getDiscrete(int[] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & -x;
        }

        public void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        public int getSum(int x) {
            int ans = 0;
            while (x >= 1) {
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
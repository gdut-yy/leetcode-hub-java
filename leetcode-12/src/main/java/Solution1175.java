public class Solution1175 {
    public int numPrimeArrangements(int n) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int rightIdx = binarySearchRightBound(primes, n);
        // 质数个数
        int cntPrime = rightIdx + 1;

        // 全排列 cntPrime! * (n-cntPrime)!
        long mod = 1000000007;
        long ans = 1;
        int a = cntPrime;
        int b = n - cntPrime;
        while (a > 1) {
            ans = ans * a % mod;
            a--;
        }
        while (b > 1) {
            ans = ans * b % mod;
            b--;
        }
        return (int) ans;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
1175. 质数排列
https://leetcode-cn.com/problems/prime-arrangements/

请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
提示：
1 <= n <= 100
 */
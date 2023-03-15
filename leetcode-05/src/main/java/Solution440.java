public class Solution440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                cur = cur * 10;
                k--;
            }
        }
        return cur;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
/*
440. 字典序的第K小数字
https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/

给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
提示:
1 <= k <= n <= 10^9
 */
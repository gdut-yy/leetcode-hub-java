public class Solution3751 {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int x = num1; x <= num2; x++) {
            ans += getAns(x);
        }
        return ans;
    }

    private int getAns(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        if (n < 3) return 0;
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int mid = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';
            if (mid > left && mid > right) {
                cnt++;
            } else if (mid < left && mid < right) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
3751. 范围内总波动值 I
https://leetcode.cn/problems/total-waviness-of-numbers-in-range-i/description/

第 170 场双周赛 T2。

给你两个整数 num1 和 num2，表示一个 闭 区间 [num1, num2]。
一个数字的 波动值 定义为该数字中 峰 和 谷 的总数：
- 如果一个数位 严格大于 其两个相邻数位，则该数位为 峰。
- 如果一个数位 严格小于 其两个相邻数位，则该数位为 谷。
- 数字的第一个和最后一个数位 不能 是峰或谷。
- 任何少于 3 位的数字，其波动值均为 0。
返回范围 [num1, num2] 内所有数字的波动值之和。
提示：
1 <= num1 <= num2 <= 10^5

暴力模拟。
时间复杂度 O(n)。
 */
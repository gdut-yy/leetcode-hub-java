public class Solution3870 {
    public int countCommas(int n) {
        int ans = 0;
        for (int i = 1000; i <= n; i++) {
            ans += String.valueOf(i).length() / 4;
        }
        return ans;
    }
}
/*
3870. 统计范围内的逗号
https://leetcode.cn/problems/count-commas-in-range/description/

第 493 场周赛 T1。

给你一个整数 n。
返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
在 标准 格式中：
- 从右边开始，每 三位 数字后插入一个逗号。
- 位数 少于四位 的数字不包含逗号。
提示：
1 <= n <= 10^5

暴力。
相似题目: 3871. 统计范围内的逗号 II
https://leetcode.cn/problems/count-commas-in-range-ii/description/
 */
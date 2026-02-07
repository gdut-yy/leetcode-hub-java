public class SolutionP3687 {
    public int lateFee(int[] daysLate) {
        int ans = 0;
        for (int days : daysLate) {
            ans += getFee(days);
        }
        return ans;
    }

    private int getFee(int days) {
        if (days == 1) return 1;
        else if (days <= 5) return 2 * days;
        else return 3 * days; // days > 5
    }
}
/*
$3687. 图书馆逾期罚款计算器
https://leetcode.cn/problems/library-late-fee-calculator/description/

给定一个整数数组 daysLate，其中 daysLate[i] 表示第 i 书的归还日期晚了几天。
罚款计算如下：
- 如果 daysLate[i] == 1，罚款为 1。
- 如果 2 <= daysLate[i] <= 5，罚款为 2 * daysLate[i]。
- 如果 daysLate[i] > 5，罚款为 3 * daysLate[i]。
返回所有书的总罚款。
提示：
1 <= daysLate.length <= 100
1 <= daysLate[i] <= 100

模拟。
时间复杂度 O(n)。
 */
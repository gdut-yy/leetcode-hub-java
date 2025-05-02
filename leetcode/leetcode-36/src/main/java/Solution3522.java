public class Solution3522 {
    public long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        boolean[] vis = new boolean[n];
        long ans = 0;
        int i = 0;
        while (i >= 0 && i < n) {
            if (vis[i]) break;
            vis[i] = true;
            if ("add".equals(instructions[i])) {
                ans += values[i];
                i++;
            } else {
                i += values[i];
            }
        }
        return ans;
    }
}
/*
3522. 执行指令后的得分
https://leetcode.cn/problems/calculate-score-after-performing-instructions/description/

第 446 场周赛 T1。

给你两个数组：instructions 和 values，数组的长度均为 n。
你需要根据以下规则模拟一个过程：
- 从下标 i = 0 的第一个指令开始，初始得分为 0。
- 如果 instructions[i] 是 "add"：
  - 将 values[i] 加到你的得分中。
  - 移动到下一个指令 (i + 1)。
如果 instructions[i] 是 "jump"：
移动到下标为 (i + values[i]) 的指令，但不修改你的得分。
当以下任一情况发生时，过程会终止：
- 越界（即 i < 0 或 i >= n），或
- 尝试再次执行已经执行过的指令。被重复访问的指令不会再次执行。
返回过程结束时的得分。
提示：
n == instructions.length == values.length
1 <= n <= 10^5
instructions[i] 只能是 "add" 或 "jump"。
-10^5 <= values[i] <= 10^5

中国时间 2025-04-20 周日 10:30
广州·中肿。前1天。
模拟。
时间复杂度 O(n)。
 */
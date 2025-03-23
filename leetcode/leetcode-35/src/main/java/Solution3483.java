public class Solution3483 {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int v : digits) cnt[v]++;

        int ans = 0;
        for (int num = 100; num <= 999; num += 2) {
            int a = num / 100;
            int b = num / 10 % 10;
            int c = num % 10;
            int[] temp = new int[10];
            temp[a]++;
            temp[b]++;
            temp[c]++;
            boolean valid = true;
            for (int i = 0; i < 10; i++) {
                if (temp[i] > cnt[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) ans++;
        }
        return ans;
    }
}
/*
3483. 不同三位偶数的数目
https://leetcode.cn/problems/unique-3-digit-even-numbers/description/

第 152 场双周赛 T1。

给你一个数字数组 digits，你需要从中选择三个数字组成一个三位偶数，你的任务是求出 不同 三位偶数的数量。
注意：每个数字在三位偶数中都只能使用 一次 ，并且 不能 有前导零。
提示：
3 <= digits.length <= 10
0 <= digits[i] <= 9

枚举 [100,999] 的每个偶数。
时间复杂度 O(1000)。
 */
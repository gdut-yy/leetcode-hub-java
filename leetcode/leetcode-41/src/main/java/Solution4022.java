public class Solution4022 {
    public int kthDigit(long k) {
        k--; // k 改成从 0 开始，方便计算

        // 十进制长为 length 的正整数有 cnt = 9 * 10^(length-1) 个
        long cnt = 9;
        int length = 1;
        while (cnt * length <= k) {
            k -= cnt * length; // 这里减小了 k
            cnt *= 10;
            length++;
        }

        // 答案在正整数 x 中
        long x = cnt / 9 + k / length;
        if (x / 10 % 2 > 0) {
            // 改成递减顺序，例如 10 变成 19，11 变成 18 ……
            x += 9 - x % 10 * 2;
        }

        // 计算 x 从高到低第 k%length（从 0 开始）个数字
        for (int i = 0; i < length - k % length - 1; i++) {
            x /= 10;
        }
        return (int) (x % 10);
    }
}
/*
4022. 无限字符串里第 K 个数字
https://leetcode.cn/problems/k-th-digit-in-infinite-string/description/

第 189 场双周赛 T3。

给你一个整数 k 。
一个 无限 字符串是通过将所有 正 整数的 十进制 表示不添加任何分隔符 拼接 而成的字符串。
对于每个非负整数 b ，块 b 包含从 10 * b 到 10 * b + 9 的 正 整数。每个块中的整数按以下方式附加：
- 如果 b 是偶数，则按 递增 顺序附加整数。
- 如果 b 是奇数，则按 递减 顺序附加整数。
因此，字符串以整数 1 到 9 开始，接着是 19 到 10 ，然后是 20 到 29 ，接着是 39 到 30 ，依此类推。
返回该字符串的第 k 位数字（下标从 1 开始）。
提示：
1 <= k <= 10^15

数学。
时间复杂度 O(logk)。
 */
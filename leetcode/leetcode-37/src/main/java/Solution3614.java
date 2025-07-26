public class Solution3614 {
    public char processStr(String S, long k) {
        char[] s = S.toCharArray();
        int n = s.length;
        long[] size = new long[n];
        long sz = 0;
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == '*') {
                sz = Math.max(sz - 1, 0);
            } else if (c == '#') {
                sz *= 2; // 题目保证 sz <= 1e15
            } else if (c != '%') { // c 是字母
                sz++;
            }
            size[i] = sz;
        }

        if (k >= size[n - 1]) { // 下标越界
            return '.';
        }

        // 迭代
        for (int i = n - 1; ; i--) {
            char c = s[i];
            sz = size[i];
            if (c == '#') {
                if (k >= sz / 2) { // k 在复制后的右半边
                    k -= sz / 2;
                }
            } else if (c == '%') {
                k = sz - 1 - k; // 反转前的下标为 sz-1-k 的字母就是答案
            } else if (c != '*' && k == sz - 1) { // 找到答案
                return c;
            }
        }
    }
}
/*
3614. 用特殊操作处理字符串 II
https://leetcode.cn/problems/process-string-with-special-operations-ii/description/

第 458 场周赛 T3。

给你一个字符串 s，由小写英文字母和特殊字符：'*'、'#' 和 '%' 组成。
同时给你一个整数 k。
请根据以下规则从左到右处理 s 中每个字符，构造一个新的字符串 result：
- 如果字符是 小写 英文字母，则将其添加到 result 中。
- 字符 '*' 会 删除 result 中的最后一个字符（如果存在）。
- 字符 '#' 会 复制 当前的 result 并追加到其自身后面。
- 字符 '%' 会 反转 当前的 result。
返回最终字符串 result 中第 k 个字符（下标从 0 开始）。如果 k 超出 result 的下标索引范围，则返回 '.'。
提示:
1 <= s.length <= 10^5
s 只包含小写英文字母和特殊字符 '*'、'#' 和 '%'。
0 <= k <= 10^15
处理 s 后得到的 result 的长度不超过 10^15。

逆向思维。
相似题目: 3307. 找出第 K 个字符 II
https://leetcode.cn/problems/find-the-k-th-character-in-string-game-ii/description/
1545. 找出第 N 个二进制字符串中的第 K 位
https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/
rating 2022 (clist.by)
 */
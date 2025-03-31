public class Solution2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false; // 奇数不可能

        // 只需要关注 1 的位
        int cnt1 = 0, cnt0 = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
                cnt1++;
                if (cnt1 > cnt0) return false;
            } else {
                cnt0++;
            }
        }

        cnt1 = 0;
        cnt0 = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                cnt1++;
                if (cnt1 > cnt0) return false;
            } else {
                cnt0++;
            }
        }
        return true;
    }
}
/*
2116. 判断一个括号字符串是否有效
https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid/

第 68 场双周赛 T3。

一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的：
- 字符串为 ().
- 它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。
- 它可以表示为 (A) ，其中 A 是一个有效括号字符串。
给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 locked 中 每一个 下标 i ：
- 如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。
- 如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。
如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。
提示：
n == s.length == locked.length
1 <= n <= 10^5
s[i] 要么是 '(' 要么是 ')' 。
locked[i] 要么是 '0' 要么是 '1' 。

范围 10^5
看到括号以为要用 Stack，其实是个陷阱。
由于只需判断 true/false
把 false 的情况列举出来即可，剩余的为 true
因为为 '1' 的不能变，因此要看它前面有没有足够的 '0' 来抵消。
正向和反向各遍历一遍。
时间复杂度 O(n)
 */
import java.util.ArrayList;
import java.util.List;

public class Solution3703 {
    public String removeSubstring(String s, int k) {
        List<int[]> st = new ArrayList<>(); // 字符, 连续出现次数
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.getLast()[0] == c) {
                st.getLast()[1]++;
            } else {
                st.add(new int[]{c, 1});
            }

            // 栈顶的 k 个右括号与栈顶下面的 k 个左括号抵消
            if (c == ')' && st.size() >= 2 && st.getLast()[1] == k && st.get(st.size() - 2)[1] >= k) {
                st.removeLast();
                st.getLast()[1] -= k;
                if (st.getLast()[1] == 0) {
                    st.removeLast();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int[] p : st) {
            ans.repeat(p[0], p[1]);
        }
        return ans.toString();
    }
}
/*
3703. 移除K-平衡子字符串
https://leetcode.cn/problems/remove-k-balanced-substrings/description/

第 470 场周赛 T3。

给你一个只包含 '(' 和 ')' 的字符串 s，以及一个整数 k。
如果一个 字符串 恰好是 k 个 连续 的 '(' 后面跟着 k 个 连续 的 ')'，即 '(' * k + ')' * k ，那么称它是 k-平衡 的。
例如，如果 k = 3，k-平衡字符串是 "((()))"。
你必须 重复地 从 s 中移除所有 不重叠 的 k-平衡子串，然后将剩余部分连接起来。持续这个过程直到不存在 k-平衡 子串 为止。
返回所有可能的移除操作后的最终字符串。
子串 是字符串中 连续 的 非空 字符序列。
提示:
2 <= s.length <= 10^5
s 仅由 '(' 和 ')' 组成。
1 <= k <= s.length / 2

栈模拟。
 */
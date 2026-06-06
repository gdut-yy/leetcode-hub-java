import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3900 {
    public int longestBalanced(String S) {
        char[] s = S.toCharArray();
        int total0 = 0;
        for (char c : s) {
            if (c == '0') {
                total0++;
            }
        }
        int total1 = s.length - total0;

        Map<Integer, List<Integer>> pos = new HashMap<>();
        pos.computeIfAbsent(0, e -> new ArrayList<>()).add(-1); // 见 525 题

        int ans = 0;
        int sum = 0; // 前缀和

        for (int i = 0; i < s.length; i++) {
            sum += (s[i] - '0') * 2 - 1;

            List<Integer> p = pos.computeIfAbsent(sum, e -> new ArrayList<>());
            if (p.size() < 2) {
                p.add(i);
            }

            // 不交换
            ans = Math.max(ans, i - p.get(0));

            // 交换子串内的一个 1 和子串外的一个 0
            p = pos.get(sum - 2);
            if (p != null) {
                if ((i - p.get(0) - 2) / 2 < total0) {
                    ans = Math.max(ans, i - p.get(0));
                } else if (p.size() > 1) {
                    ans = Math.max(ans, i - p.get(1));
                }
            }

            // 交换子串内的一个 0 和子串外的一个 1
            p = pos.get(sum + 2);
            if (p != null) {
                if ((i - p.get(0) - 2) / 2 < total1) {
                    ans = Math.max(ans, i - p.get(0));
                } else if (p.size() > 1) {
                    ans = Math.max(ans, i - p.get(1));
                }
            }
        }

        return ans;
    }
}
/*
3900. 一次交换后的最长平衡子串
https://leetcode.cn/problems/longest-balanced-substring-after-one-swap/description/

第 497 场周赛 T3。

给你一个仅由字符 '0' 和 '1' 组成的二进制字符串 s。
如果一个字符串中 0 和 1 的数量 相等，则称该字符串是 平衡 字符串。
你最多可以让 s 中任意两个字符进行 一次 交换。之后，从 s 中选出一个 平衡 子串。
返回一个整数，表示你能够选取的 平衡 子串的 最大 长度。
子串 是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 10^5
s 仅由字符 '0' 和 '1' 组成。

前缀和 + 记录前两次出现位置。
如果不允许交换，本题就是 525. 连续数组。
如果把子串中的一个 1 和外面的一个 0 交换后，子串变成平衡的，那么交换前，子串中的 1 的个数恰好比 0 的个数多 2。用 525 题的做法来说，就是子串的元素和恰好等于 2。
用前缀和表示，就是 sum[i]−sum[j]=2。枚举 i，为了让子串长度 i−j 尽量长，我们需要找到 sum[i]−2 的最小的出现位置 j。所以要用哈希表（或者数组）记录每个前缀和首次出现的位置。
但如果子串外面没有 0 呢？设 s 一共有 total0 个 0，分类讨论：
子串长度为 i−j，其中有 (i−j−2)/2 个 0。
如果 (i−j−2)/2 < total0，那么子串外面还有 0，可以交换。
如果 (i−j−2)/2 = total0，那么子串外面没有 0，无法交换。
https://leetcode.cn/problems/longest-balanced-substring-after-one-swap/solutions/3949900/qian-zhui-he-ji-lu-qian-liang-ci-chu-xia-524r/
时间复杂度 O(n)。
相似题目: 525. 连续数组
https://leetcode.cn/problems/contiguous-array/
 */
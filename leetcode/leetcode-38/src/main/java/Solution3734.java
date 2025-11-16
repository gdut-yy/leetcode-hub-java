public class Solution3734 {
    public String lexPalindromicPermutation(String s, String target) {
        int[] left = new int[26];
        for (char b : s.toCharArray()) {
            left[b - 'a']++;
        }
        if (!valid(left)) {
            return "";
        }

        String midCh = "";
        for (int i = 0; i < 26; i++) {
            int c = left[i];
            if (c % 2 == 0) {
                continue;
            }
            // s 不能有超过一个字母出现奇数次
            if (!midCh.isEmpty()) {
                return "";
            }
            // 记录填在正中间的字母
            midCh = "" + (char) ('a' + i);
            left[i]--;
        }

        int n = s.length();
        // 先假设答案左半与 target 的左半（不含正中间）相同
        for (int i = 0; i < n / 2; i++) {
            left[target.charAt(i) - 'a'] -= 2;
        }

        if (valid(left)) {
            // 特殊情况：把 target 左半翻转到右半，能否比 target 大？
            String leftS = target.substring(0, n / 2);
            String rightS = midCh + new StringBuilder(leftS).reverse();
            if (rightS.compareTo(target.substring(n / 2)) > 0) { // 由于左半是一样的，所以只需比右半
                return leftS + rightS;
            }
        }

        for (int i = n / 2 - 1; i >= 0; i--) {
            int b = target.charAt(i) - 'a';
            left[b] += 2; // 撤销消耗
            if (!valid(left)) { // [0,i-1] 无法做到全部一样
                continue;
            }

            // 把 target[i] 增大到 j
            for (int j = b + 1; j < 26; j++) {
                if (left[j] == 0) {
                    continue;
                }

                // 找到答案（下面的循环在整个算法中只会跑一次）
                left[j] -= 2;
                StringBuilder ans = new StringBuilder(target.substring(0, i + 1));
                ans.setCharAt(i, (char) ('a' + j));

                // 中间可以随便填
                for (int k = 0; k < 26; k++) {
                    ans.repeat('a' + k, left[k] / 2);
                }

                // 镜像翻转
                StringBuilder rightS = new StringBuilder(ans).reverse();
                return ans.append(midCh).append(rightS).toString();
            }
            // 增大失败，继续枚举
        }
        return "";
    }

    private boolean valid(int[] left) {
        for (int c : left) {
            if (c < 0) {
                return false;
            }
        }
        return true;
    }
}
/*
3734. 大于目标字符串的最小字典序回文排列
https://leetcode.cn/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/description/

第 474 场周赛 T4。

给你两个长度均为 n 的字符串 s 和目标字符串 target，它们都由小写英文字母组成。
返回 字典序最小的字符串 ，该字符串 既 是 s 的一个 回文排列 ，又是字典序 严格 大于 target 的。如果不存在这样的排列，则返回一个空字符串。
如果字符串 a 和字符串 b 长度相同，在它们首次出现不同的位置上，字符串 a 处的字母在字母表中的顺序晚于字符串 b 处的对应字母，则字符串 a 在 字典序上严格大于 字符串 b。
排列 是指对字符串中所有字符的重新排列。
如果一个字符串从前向后读和从后向前读都一样，则该字符串是 回文 的。
提示:
1 <= n == s.length == target.length <= 300
s 和 target 仅由小写英文字母组成。

O(n) 倒序贪心
https://leetcode.cn/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/solutions/3821437/on-dao-xu-tan-xin-pythonjavacgo-by-endle-zips/
rating 2351 (clist.by)
 */
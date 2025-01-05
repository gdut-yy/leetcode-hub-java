import java.util.Arrays;

public class Solution899 {
    public String orderlyQueue(String S, int k) {
        char[] s = S.toCharArray();
        if (k == 1) {
            int i = minimalString(s, true);
            return S.substring(i) + S.substring(0, i);
        } else {
            Arrays.sort(s);
            return new String(s);
        }
    }

    // 最小表示法
    private int minimalString(char[] s, boolean isMin) {
        int n = s.length;
        int k = 0, i = 0, j = 1;
        while (k < n && i < n && j < n) {
            int d = chr(s, i + k, isMin) - chr(s, j + k, isMin);
            if (d == 0) {
                k++;
            } else {
                if (d > 0 == isMin) i = i + k + 1;
                else j = j + k + 1;
                if (i == j) i++;
                k = 0;
            }
        }
        i = Math.min(i, j);
        return i;
    }

    private int chr(char[] s, int i, boolean isMin) {
        int n = s.length;
        if (i >= n) return isMin ? s[i % n] : 0;
        return s[i];
    }
}
/*
899. 有序队列
https://leetcode.cn/problems/orderly-queue/

给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
提示：
1 <= k <= S.length <= 1000
s 只由小写字母组成。

最小表示法
https://oi-wiki.org/string/minimal-string/
相似题目: 3403. 从盒子中找出字典序最大的字符串 I
https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/
 */
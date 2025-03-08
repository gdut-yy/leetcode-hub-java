import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution3455 {
    public int shortestMatchingSubstring(String s, String p) {
        int a = p.indexOf('*');
        int b = p.lastIndexOf('*');
        char[] txt = s.toCharArray();
        char[] p1 = p.substring(0, a).toCharArray();
        char[] p2 = p.substring(a + 1, b).toCharArray();
        char[] p3 = p.substring(b + 1).toCharArray();

//        char[] txt = s.toCharArray();
//        String[] sp = p.split("\\*", -1);
//        char[] p1 = sp[0].toCharArray();
//        char[] p2 = sp[1].toCharArray();
//        char[] p3 = sp[2].toCharArray();

        // 三段各自在 s 中的所有匹配位置
        List<Integer> pos1 = getStartIds(txt, p1, prefix_function(p1));
        List<Integer> pos2 = getStartIds(txt, p2, prefix_function(p2));
        List<Integer> pos3 = getStartIds(txt, p3, prefix_function(p3));

        int ans = Integer.MAX_VALUE;
        int i = 0;
        int k = 0;
        // 枚举中间（第二段），维护最近的左右（第一段和第三段）
        for (int j : pos2) {
            // 右边找离 j 最近的子串（但不能重叠）
            while (k < pos3.size() && pos3.get(k) < j + p2.length) {
                k++;
            }
            if (k == pos3.size()) { // 右边没有
                break;
            }
            // 左边找离 j 最近的子串（但不能重叠）
            while (i < pos1.size() && pos1.get(i) <= j - p1.length) {
                i++;
            }
            // 循环结束后，pos1.get(i-1) 是左边离 j 最近的子串下标（首字母在 s 中的下标）
            if (i > 0) {
                ans = Math.min(ans, pos3.get(k) + p3.length - pos1.get(i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private List<Integer> getStartIds(char[] txt, char[] pat, int[] pi) {
        if (pat.length == 0) {
            return IntStream.range(0, txt.length + 1).boxed().toList();
        }

        List<Integer> res = new ArrayList<>();
        int n = txt.length, m = pat.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == m) {
                res.add(i - j + 1);
                j = pi[j - 1];
            }
        }
        return res;
    }

    private int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
3455. 最短匹配子字符串
https://leetcode.cn/problems/shortest-matching-substring/description/

第 150 场双周赛 T4。

给你一个字符串 s 和一个模式字符串 p，其中 p 恰好 包含 两个 '*'  字符。
p 中的 '*' 匹配零个或多个字符的任何序列。
返回 s 中与 p 匹配的 最短 子字符串的长度。如果没有这样的子字符串，返回 -1。
子字符串 是字符串中的一个连续字符序列（空子字符串也被认为是合法字符串）。
提示：
1 <= s.length <= 10^5
2 <= p.length <= 10^5
s 仅包含小写英文字母。
p 仅包含小写英文字母，并且恰好包含两个 '*'。

KMP + 枚举中间 + 三指针
时间复杂度 O(n + m)。
相似题目: 3008. 找出数组中的美丽下标 II
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/description/
rating 2290 (clist.by)
 */
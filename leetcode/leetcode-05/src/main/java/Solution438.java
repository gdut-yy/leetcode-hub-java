import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (n < m) return ans;

        int[] cnt_window = new int[26];
        int[] cnt_p = new int[26];
        // [0, m-1]
        for (int i = 0; i < m; i++) {
            cnt_window[s.charAt(i) - 'a']++;
            cnt_p[p.charAt(i) - 'a']++;
        }
        if (check(cnt_window, cnt_p)) {
            ans.add(0);
        }

        // [m, n-1]
        for (int i = m; i < n; i++) {
            int add = s.charAt(i) - 'a';
            int rm = s.charAt(i - m) - 'a';
            cnt_window[add]++;
            cnt_window[rm]--;
            if (check(cnt_window, cnt_p)) {
                ans.add(i - m + 1);
            }
        }
        return ans;
    }

    private boolean check(int[] cnt_window, int[] cnt_p) {
        for (int i = 0; i < 26; i++) {
            if (cnt_window[i] < cnt_p[i]) return false;
        }
        return true;
    }
}
/*
438. 找到字符串中所有字母异位词
https://leetcode.cn/problems/find-all-anagrams-in-a-string/

给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
提示:
1 <= s.length, p.length <= 3 * 10^4
s 和 p 仅包含小写字母

双指针 滑动窗口。
时间复杂度 O(26n)
相似题目: 567. 字符串的排列
https://leetcode.cn/problems/permutation-in-string/
 */
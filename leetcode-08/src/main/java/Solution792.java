import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution792 {
    private Map<Character, List<Integer>> idxListMap;

    public int numMatchingSubseq(String s, String[] words) {
        idxListMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            idxListMap.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }

        int res = 0;
        for (String word : words) {
            if (check2(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check2(String s, String word) {
        int p = -1;
        int q = 0;
        while (p < s.length() && q < word.length()) {
            if (!idxListMap.containsKey(word.charAt(q))) {
                return false;
            }
            List<Integer> idxList = idxListMap.get(word.charAt(q));
            int left = 0;
            int right = idxList.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (idxList.get(mid) > p) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left >= idxList.size()) {
                return false;
            }
            p = idxList.get(left);
            q++;
        }
        return q == word.length();
    }

    // 暴力，TLE
    public int numMatchingSubseq2(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (check(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String s, String word) {
        int p = 0;
        int q = 0;
        while (p < s.length() && q < word.length()) {
            if (s.charAt(p) == word.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        return q == word.length();
    }
}
/*
792. 匹配子序列的单词数
https://leetcode.cn/problems/number-of-matching-subsequences/

给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
例如， “ace” 是 “abcde” 的子序列。
提示:
1 <= s.length <= 5 * 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 50
words[i]和 s 都只由小写字母组成。

暴力 时间复杂度 O(n·m·|s|) 其中 n = s.length, m = words.length
考虑二分 时间复杂度 O(logn·m·|s|)
 */
import java.util.Arrays;

public class Solution3816 {
    public String lexSmallestAfterDeletion(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        int[] cnt = new int[26];
        for (char c : s) cnt[c - 'a']++;
        int[][] pos = new int[26][];
        int[] fill = new int[26];
        for (int c = 0; c < 26; c++) {
            pos[c] = new int[cnt[c]];
        }
        for (int i = 0; i < n; i++) {
            int c = s[i] - 'a';
            pos[c][fill[c]++] = i;
        }
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        boolean[] need = new boolean[26];
        int needCount = 0;
        for (int c = 0; c < 26; c++) {
            if (cnt[c] > 0) {
                lastPos[c] = pos[c][pos[c].length - 1];
                need[c] = true;
                needCount++;
            }
        }
        int[] ptr = new int[26];
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (needCount > 0) {
            int end = Integer.MAX_VALUE;
            for (int c = 0; c < 26; c++) {
                if (need[c]) end = Math.min(end, lastPos[c]);
            }
            int chooseChar = -1;
            int choosePos = -1;
            for (int c = 0; c < 26; c++) {
                int[] list = pos[c];
                int p = ptr[c];
                while (p < list.length && list[p] < i) p++;
                ptr[c] = p;
                if (p < list.length && list[p] <= end) {
                    chooseChar = c;
                    choosePos = list[p];
                    break;
                }
            }
            ans.append((char) ('a' + chooseChar));
            i = choosePos + 1;
            if (need[chooseChar]) {
                need[chooseChar] = false;
                needCount--;
            }
        }
        return ans.toString();
    }
}
/*
3816. 删除重复字符后的字典序最小字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-deleting-duplicate-characters/description/

第 485 场周赛 T4。

给你一个字符串 s，它由小写英文字母组成。
你可以进行如下操作任意次（可能为零次）：
- 选择当前字符串 s 中 至少出现两次 的任意一个字母并删除其中的一次出现。
返回可以通过这种方式形成的 字典序最小 的结果字符串。
如果字符串 a 的某个位置与字符串 b 不同，且 a 在该位置的字母比 b 对应位置的字母在字母表中更靠前，则 a 被认为是 字典序更小 的字符串。如果 a 的前 min(a.length, b.length) 个字符都与 b 相同，则较短的字符串字典序更小。
提示：
1 <= s.length <= 10^5
s 仅包含小写英文字母。

单调栈。
时间复杂度 O(n)。
rating 2400 (clist.by)
 */
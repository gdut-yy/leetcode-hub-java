import java.util.Arrays;

public class Solution3545 {
    public int minDeletion(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = s.length();
        for (int i = 0; i < k; i++) {
            int j = 25 - i;
            ans -= cnt[j];
        }
        return ans;
    }
}
/*
3545. 不同字符数量最多为 K 时的最少删除数
https://leetcode.cn/problems/minimum-deletions-for-at-most-k-distinct-characters/description/

第 449 场周赛 T1。

给你一个字符串 s（由小写英文字母组成）和一个整数 k。
你的任务是删除字符串中的一些字符（可以不删除任何字符），使得结果字符串中的 不同字符数量 最多为 k。
返回为达到上述目标所需删除的 最小 字符数量。
提示：
1 <= s.length <= 16
1 <= k <= 16
s 仅由小写英文字母组成。

贪心。
时间复杂度 O(ClogC)。其中 C = 26。
 */
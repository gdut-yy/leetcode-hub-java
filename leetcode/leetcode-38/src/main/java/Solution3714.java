import java.util.HashMap;
import java.util.Map;

public class Solution3714 {
    private int ans = 0;

    public int longestBalanced(String s) {
        int n = s.length();
        Map<Long, Integer> mp_abc = newHashMap(); // (preA - preB, preA - preC)
        Map<Long, Integer> mp_ab = newHashMap(); // (preA - preB, preC)
        Map<Long, Integer> mp_ac = newHashMap(); // (preA - preC, preB)
        Map<Long, Integer> mp_bc = newHashMap(); // (preB - preC, preA)
        Map<Long, Integer> mp_a = newHashMap(); // (preB, preC)
        Map<Long, Integer> mp_b = newHashMap(); // (preA, preC)
        Map<Long, Integer> mp_c = newHashMap(); // (preA, preB)

        int preA = 0, preB = 0, preC = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') preA++;
            else if (c == 'b') preB++;
            else preC++;

            updateAns(i, mp_abc, preA - preB, preA - preC);
            updateAns(i, mp_ab, preA - preB, preC);
            updateAns(i, mp_ac, preA - preC, preB);
            updateAns(i, mp_bc, preB - preC, preA);
            updateAns(i, mp_a, preB, preC);
            updateAns(i, mp_b, preA, preC);
            updateAns(i, mp_c, preA, preB);
        }

        return ans;
    }

    private static Map<Long, Integer> newHashMap() {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, -1);
        return mp;
    }

    private void updateAns(int i, Map<Long, Integer> mp, int d1, int d2) {
        long key = getHash(d1, d2);
        if (mp.containsKey(key)) ans = Math.max(ans, i - mp.get(key));
        else mp.put(key, i);
    }

    private long getHash(long x, int y) {
        return x * 100005 + y;
    }
}
/*
3714. 最长的平衡子串 II
https://leetcode.cn/problems/longest-balanced-substring-ii/description/

第 471 场周赛 T3。

给你一个只包含字符 'a'、'b' 和 'c' 的字符串 s。
如果一个 子串 中所有 不同 字符出现的次数都 相同，则称该子串为 平衡 子串。
请返回 s 的 最长平衡子串 的 长度 。
子串 是字符串中连续的、非空 的字符序列。
提示：
1 <= s.length <= 10^5
s 仅包含字符 'a'、'b' 和 'c'。

枚举右维护左。分类讨论。
情况 1：a=b=c
情况 2：a=b且c=0
情况 3：a=c且b=0
情况 4：b=c且a=0
情况 5：只有a，那么b和c为0
情况 6：只有b
情况 7：只有c
https://chat.deepseek.com/a/chat/s/18a4597f-9196-4512-aa7e-3bce55cbb299
时间复杂度 O(n)。
rating 2226 (clist.by)
 */
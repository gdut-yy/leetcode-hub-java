import java.util.HashMap;
import java.util.Map;

public class Solution3714 {
    public int longestBalanced(String s) {
        int n = s.length();
        Map<Long, Integer> map1 = new HashMap<>(); // (preA - preB, preA - preC)
        Map<Long, Integer> map2 = new HashMap<>(); // (preA - preB, preC)
        Map<Long, Integer> map3 = new HashMap<>(); // (preA - preC, preB)
        Map<Long, Integer> map4 = new HashMap<>(); // (preB - preC, preA)
        Map<Long, Integer> map5 = new HashMap<>(); // (preB, preC)
        Map<Long, Integer> map6 = new HashMap<>(); // (preA, preC)
        Map<Long, Integer> map7 = new HashMap<>(); // (preA, preB)

        int preA = 0, preB = 0, preC = 0;

        map1.put(0L, -1);
        map2.put(0L, -1);
        map3.put(0L, -1);
        map4.put(0L, -1);
        map5.put(0L, -1);
        map6.put(0L, -1);
        map7.put(0L, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') preA++;
            else if (c == 'b') preB++;
            else preC++;

            int d1 = preA - preB;
            int d2 = preA - preC;
            int d3 = preB - preC;

            long key = getHash(d1, d2);
            if (map1.containsKey(key)) {
                int start = map1.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map1.put(key, i);
            }

            key = getHash(d1, preC);
            if (map2.containsKey(key)) {
                int start = map2.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map2.put(key, i);
            }

            key = getHash(d2, preB);
            if (map3.containsKey(key)) {
                int start = map3.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map3.put(key, i);
            }

            key = getHash(d3, preA);
            if (map4.containsKey(key)) {
                int start = map4.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map4.put(key, i);
            }

            key = getHash(preB, preC);
            if (map5.containsKey(key)) {
                int start = map5.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map5.put(key, i);
            }

            key = getHash(preA, preC);
            if (map6.containsKey(key)) {
                int start = map6.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map6.put(key, i);
            }

            key = getHash(preA, preB);
            if (map7.containsKey(key)) {
                int start = map7.get(key);
                ans = Math.max(ans, i - start);
            } else {
                map7.put(key, i);
            }
        }

        return ans;
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

枚举右维护左。
条件1：a=b=c
条件2：a=b且c=0
条件3：a=c且b=0
条件4：b=c且a=0
条件5：只有a，那么b和c为0
条件6：只有b
条件7：只有c
https://chat.deepseek.com/a/chat/s/18a4597f-9196-4512-aa7e-3bce55cbb299
时间复杂度 O(n)。
rating 2226 (clist.by)
 */
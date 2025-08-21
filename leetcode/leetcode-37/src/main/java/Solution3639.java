import java.util.Map;
import java.util.TreeMap;

public class Solution3639 {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long total = ((long) n * (n + 1)) / 2;
        if (k > total) {
            return -1;
        }
        TreeMap<Integer, Integer> segs = new TreeMap<>();
        segs.put(0, n - 1);
        long currentSum = total;

        for (int t = 0; t < order.length; t++) {
            int p = order[t];
            Map.Entry<Integer, Integer> seg = segs.floorEntry(p);
            if (seg == null || seg.getValue() < p) {
                return -1;
            }
            int l = seg.getKey();
            int r = seg.getValue();
            segs.remove(l);
            long len = r - l + 1;
            currentSum -= (len * (len + 1)) / 2;

            if (l < p) {
                int newL = l;
                int newR = p - 1;
                segs.put(newL, newR);
                long len1 = newR - newL + 1;
                currentSum += (len1 * (len1 + 1)) / 2;
            }
            if (p < r) {
                int newL = p + 1;
                int newR = r;
                segs.put(newL, newR);
                long len2 = newR - newL + 1;
                currentSum += (len2 * (len2 + 1)) / 2;
            }

            long validCount = total - currentSum;
            if (validCount >= k) {
                return t;
            }
        }
        return -1;
    }
}
/*
3639. 变为活跃状态的最小时间
https://leetcode.cn/problems/minimum-time-to-activate-string/description/

第 461 场周赛 T3。

给你一个长度为 n 的字符串 s 和一个整数数组 order，其中 order 是范围 [0, n - 1] 内数字的一个 排列 。
从时间 t = 0 开始，在每个时间点，将字符串 s 中下标为 order[t] 的字符替换为 '*'。
如果 子字符串 包含 至少 一个 '*' ，则认为该子字符串有效。
如果字符串中 有效子字符串 的总数大于或等于 k，则称该字符串为 活跃 字符串。
返回字符串 s 变为 活跃 状态的最小时间 t。如果无法变为活跃状态，返回 -1。
注意：
- 排列 是一个集合中所有元素的重新排列。
- 子字符串 是字符串中的连续非空字符序列。
提示:
1 <= n == s.length <= 10^5
order.length == n
0 <= order[i] <= n - 1
s 由小写英文字母组成。
order 是从 0 到 n - 1 的整数排列。
1 <= k <= 10^9

贡献法。平衡树维护未被替换的连续段。
时间复杂度 O(nlogn)。
两种方法：二分答案 / 逆向思维+双向链表 https://leetcode.cn/problems/minimum-time-to-activate-string/solutions/3741028/er-fen-da-an-pythonjavacgo-by-endlessche-6s8n/
https://yuanbao.tencent.com/chat/naQivTmsDa/dce3b3ee-ac0a-4308-b996-ba27799cd353
 */
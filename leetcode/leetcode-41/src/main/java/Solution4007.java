import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4007 {
    public int maximumWidth(int[] planks) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (int p : planks) {
            cnt.merge((long) p, 1, Integer::sum);
        }

        Map<Long, Integer> best = new HashMap<>();
        for (Map.Entry<Long, Integer> e : cnt.entrySet()) {
            best.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        for (Map.Entry<Long, Integer> e : cnt.entrySet()) {
            long h = e.getKey() * 2;
            int add = e.getValue() / 2;
            if (add > 0) {
                best.merge(h, add, Integer::sum);
            }
        }
        List<Long> keys = new ArrayList<>(cnt.keySet());
        for (int i = 0; i < keys.size(); i++) {
            long a = keys.get(i);
            int ca = cnt.get(a);
            for (int j = i + 1; j < keys.size(); j++) {
                long b = keys.get(j);
                best.merge(a + b, Math.min(ca, cnt.get(b)), Integer::sum);
            }
        }

        int ans = 0;
        for (int v : best.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}
/*
4007. 栅栏的最宽宽度
https://leetcode.cn/problems/widest-possible-fence/description/

第 188 场双周赛 T2。

给你一个整数数组 planks，其中 planks[i] 表示第 i 块木板的高度。每块木板的宽度为 1 个单位。
你想要用木板建造一个栅栏，栅栏中的所有木板必须具有 相同 的高度。
你可以直接使用原本的木板，或者将两块不同的原始木板组合成一块新木板，其高度 等于 这两块木板的高度之和。每块原始木板 最多 只能使用一次，并且不需要使用所有的原始木板。
返回可以建造的栅栏的 最大可能宽度。
提示：
1 <= planks.length <= 1000
1 <= planks[i] <= 10^9

枚举 + 两个哈希表。
时间复杂度 O(n^2)。
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3572 {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> x_maxy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x_i = x[i];
            int y_i = y[i];
            x_maxy.merge(x_i, y_i, Math::max);
        }
        List<Integer> a = new ArrayList<>(x_maxy.values());
        int sz = a.size();
        if (sz < 3) return -1;
        a.sort(null);
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += a.get(sz - 1 - i);
        }
        return ans;
    }
}
/*
3572. 选择不同 X 值三元组使 Y 值之和最大
https://leetcode.cn/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/description/

第 158 场双周赛 T1。

给你两个整数数组 x 和 y，长度均为 n。你必须选择三个 不同 的下标 i ，j 和 k，满足以下条件：
- x[i] != x[j]
- x[j] != x[k]
- x[k] != x[i]
你的目标是在满足这些条件下 最大化 y[i] + y[j] + y[k] 的值。返回通过选择这样一组三元组下标所能获得的 最大 可能和。
如果不存在这样的三元组，返回 -1。
提示：
n == x.length == y.length
3 <= n <= 10^5
1 <= x[i], y[i] <= 10^6

贪心。
 */
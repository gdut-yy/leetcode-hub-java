import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3668 {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendsSet = new HashSet<>();
        for (int v : friends) {
            friendsSet.add(v);
        }
        List<Integer> ans = new ArrayList<>();
        for (int v : order) {
            if (friendsSet.contains(v)) ans.add(v);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
3668. 重排完成顺序
https://leetcode.cn/problems/restore-finishing-order/description/

第 465 场周赛 T1。

给你一个长度为 n 的整数数组 order 和一个整数数组 friends。
- order 包含从 1 到 n 的每个整数，且 恰好出现一次 ，表示比赛中参赛者按照 完成顺序 的 ID。
- friends 包含你朋友们的 ID，按照 严格递增 的顺序排列。friends 中的每个 ID 都保证出现在 order 数组中。
请返回一个数组，包含你朋友们的 ID，按照他们的 完成顺序 排列。
提示：
1 <= n == order.length <= 100
order 包含从 1 到 n 的每个整数，且恰好出现一次
1 <= friends.length <= min(8, n)
1 <= friends[i] <= n
friends 是严格递增的

哈希表。
时间复杂度 O(n)。
 */
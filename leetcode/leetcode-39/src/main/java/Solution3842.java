import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3842 {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : bulbs) cnt.merge(v, 1, Integer::sum);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() % 2 > 0) {
                ans.add(e.getKey());
            }
        }
        ans.sort(null);
        return ans;
    }
}
/*
3842. 切换打开灯泡
https://leetcode.cn/problems/toggle-light-bulbs/description/

第 489 场周赛 T1。

给你一个整数数组 bulbs，其中每个元素的取值范围为 1 到 100。
有 100 个电灯泡，按从 1 到 100 编号，初始时所有灯泡均为关闭状态。
对于数组 bulbs 中的每一个元素 bulbs[i]，执行以下操作：
- 如果第 bulbs[i] 个灯泡当前是关闭状态，将其打开。
- 如果第 bulbs[i] 个灯泡当前是打开状态，将其关闭。
返回一个整数列表，表示最终处于打开状态的灯泡编号，按升序排列。如果没有灯泡是打开的，返回一个空列表。
提示：
1 <= bulbs.length <= 100
1 <= bulbs[i] <= 100

中国时间 2026-02-15 周日 10:30
归家。春节假期第一天。
哈希表计数。
时间复杂度 O(nlogn)。
 */
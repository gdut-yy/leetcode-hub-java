import java.util.HashMap;
import java.util.Map;

public class Solution1711 {
    private static final int MOD = (int) (1e9 + 7);

    public int countPairs(int[] deliciousness) {
        long ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : deliciousness) {
            for (int k = 0; k < 31; k++) {
                int target = 1 << k;
                if (mp.containsKey(target - v)) {
                    ans += mp.get(target - v);
                }
            }
            mp.merge(v, 1, Integer::sum);
        }
        return (int) (ans % MOD);
    }
}
/*
1711. 大餐计数
https://leetcode.cn/problems/count-good-meals/description/

大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
你可以搭配 任意 两道餐品做一顿大餐。
给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
提示：
1 <= deliciousness.length <= 10^5
0 <= deliciousness[i] <= 2^20

两数之和变种。
时间复杂度 O(nlogU)。
 */
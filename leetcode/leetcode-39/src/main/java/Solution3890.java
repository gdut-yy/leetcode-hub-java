import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3890 {
    private static final int MX = (int) 1e9;
    private static final List<Integer> goodIntegers = new ArrayList<>();

    static {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a = 1; a * a * a <= MX / 2; a++) {
            for (int b = a; a * a * a + b * b * b <= MX; b++) {
                cnt.merge(a * a * a + b * b * b, 1, Integer::sum);
            }
        }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() > 1) {
                goodIntegers.add(e.getKey());
            }
        }
        Collections.sort(goodIntegers);
    }

    public List<Integer> findGoodIntegers(int n) {
        int i = lowerBound(goodIntegers, n + 1);
        return goodIntegers.subList(0, i);
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3890. 可由多种立方和构造的整数
https://leetcode.cn/problems/integers-with-multiple-sum-of-two-cubes/description/

第 496 场周赛 T2。

给你一个整数 n。
当存在 至少 两组不同的整数对 (a, b) 满足以下条件时，整数 x 被称为 好整数：
- a 和 b 是正整数。
- a <= b
- x = a^3 + b^3
返回一个数组，其中包含所有小于等于 n 的好整数，并按升序排序。
提示：
1 <= n <= 10^9

预处理 + 二分。
时间复杂度 O(logG)，其中 G=1554 是好整数的个数。
 */
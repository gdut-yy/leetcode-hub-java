import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int card : deck) {
            cntMap.put(card, cntMap.getOrDefault(card, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(cntMap.values());
        int gcd = values.get(0);
        for (int value : values) {
            gcd = getGCD(gcd, value);
        }
        return gcd >= 2;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
914. 卡牌分组
https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/

第 104 场周赛 T1。
统计各数字频次。然后判断频次的最大公约数是否 >= 2 即可。

时间复杂度：O(NlogC)，其中 N 是卡牌的个数，C 是数组 deck 中数的范围，在本题中 C 的值为 10000。求两个数最大公约数的复杂度是 O(logC)
空间复杂度：O(N+C) 或 O(N)。
 */
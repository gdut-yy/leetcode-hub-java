import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xPowerList = getPowerList(x, bound);
        List<Integer> yPowerList = getPowerList(y, bound);
        // 枚举
        Set<Integer> ans = new HashSet<>();
        for (int xPower : xPowerList) {
            for (int yPower : yPowerList) {
                int sum = xPower + yPower;
                if (sum <= bound) {
                    ans.add(sum);
                } else {
                    // 两个 List 都是有序的，后面的可以直接剪枝掉
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private List<Integer> getPowerList(int num, int bound) {
        // 1 的任意次方都等于 1，需单独处理，否则死循环
        if (num == 1) {
            return List.of(1);
        }
        int pow = 0;
        List<Integer> powerList = new ArrayList<>();
        while (Math.pow(num, pow) < bound) {
            powerList.add((int) Math.pow(num, pow));
            pow++;
        }
        return powerList;
    }
}
/*
970. 强整数
https://leetcode-cn.com/problems/powerful-integers/

第 118 场周赛 T1。
根据题意枚举即可。
 */
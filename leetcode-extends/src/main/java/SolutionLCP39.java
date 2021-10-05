import java.util.HashMap;
import java.util.Map;

public class SolutionLCP39 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int[] sourc : source) {
            for (int sour : sourc) {
                cntMap.put(sour, cntMap.getOrDefault(sour, 0) + 1);
            }
        }
        int cnt = 0;
        for (int[] targe : target) {
            for (int targ : targe) {
                if (cntMap.containsKey(targ)) {
                    cntMap.put(targ, cntMap.get(targ) - 1);
                    if (cntMap.get(targ) == 0) {
                        cntMap.remove(targ);
                    }
                } else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
LCP 39. 无人机方阵
https://leetcode-cn.com/problems/0jQkd0/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T1。
注意： 调整无人机的位置布局时无人机的位置可以随意变动。
看着题目的动图还以为是矩阵行列变换。
HashMap 统计频次即可。
 */
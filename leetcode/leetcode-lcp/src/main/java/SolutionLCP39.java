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
https://leetcode.cn/problems/0jQkd0/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T1。

在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
- 调整无人机的位置布局
- 切换无人机展示的灯光颜色
给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
注意： 调整无人机的位置布局时无人机的位置可以随意变动。
提示：
n == source.length == target.length
m == source[i].length == target[i].length
1 <= n, m <=100
1 <= source[i][j], target[i][j] <=10^4

看着题目的动图还以为是矩阵行列变换。
HashMap 统计频次即可。
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionLCP46 {
    /**
     * 一元一次方程法
     */
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        Map<Integer, Set<Integer>> fromToMap = buildFromToMap(edges);
        // 第 1 ~ n-1 个场馆
        int n = finalCnt.length + 1;
        // f(x) = a * x + b
        int[] ai = new int[n];
        ai[0] = 1;
        int[] bi = new int[n];
        System.arraycopy(finalCnt, 0, bi, 1, n - 1);

        // 反推
        int plansLen = plans.length;
        for (int i = plansLen - 1; i >= 0; i--) {
            // 第 i 天对编号 idx 的场馆执行了第 num 种调配方案
            int num = plans[i][0];
            int idx = plans[i][1];
            if (num == 1) {
                // 将编号为 idx 的场馆内的志愿者人数减半；
                ai[idx] *= 2;
                bi[idx] *= 2;
            } else {
                Set<Integer> tos = fromToMap.getOrDefault(idx, new HashSet<>());
                for (int to : tos) {
                    if (num == 2) {
                        // 将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
                        ai[to] -= ai[idx];
                        bi[to] -= bi[idx];
                    } else {
                        // 将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
                        ai[to] += ai[idx];
                        bi[to] += bi[idx];
                    }
                }
            }
        }
        // sumA * x = totalNum - sumB
        long sumA = 0;
        for (int i = 0; i < n; i++) {
            sumA += ai[i];
            totalNum -= bi[i];
        }
        int x = (int) (totalNum / sumA);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ai[i] * x + bi[i];
        }
        return res;
    }

    private Map<Integer, Set<Integer>> buildFromToMap(int[][] edges) {
        Map<Integer, Set<Integer>> fromToMap = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            // 相邻 有向图的两条边
            Set<Integer> set1 = fromToMap.getOrDefault(from, new HashSet<>());
            set1.add(to);
            fromToMap.put(from, set1);
            Set<Integer> set2 = fromToMap.getOrDefault(to, new HashSet<>());
            set2.add(from);
            fromToMap.put(to, set2);
        }
        return fromToMap;
    }

    /**
     * 二分查找法
     */
    public int[] volunteerDeployment2(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        Map<Integer, Set<Integer>> fromToMap = buildFromToMap(edges);
        // 第 1 ~ n-1 个场馆
        int n = finalCnt.length + 1;
        long[] curCnt = new long[n];
        long[] finalCntLong = new long[finalCnt.length];
        for (int i = 0; i < finalCnt.length; i++) {
            finalCntLong[i] = finalCnt[i];
        }
        // 二分？
        int left = 0;
        int right = 1000000000;
        // 单调性
        long leftSum = getOriginTotal(plans, fromToMap, finalCntLong, curCnt, left);
        long rightSum = getOriginTotal(plans, fromToMap, finalCntLong, curCnt, right);
        boolean isAsc = leftSum < rightSum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = getOriginTotal(plans, fromToMap, finalCntLong, curCnt, mid);
            if (sum == totalNum) {
                int[] res = new int[curCnt.length];
                for (int i = 0; i < curCnt.length; i++) {
                    res[i] = (int) curCnt[i];
                }
                return res;
            } else if (sum > totalNum) {
                if (isAsc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (isAsc) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{};
    }

    private long getOriginTotal(int[][] plans, Map<Integer, Set<Integer>> fromToMap, long[] finalCntLong,
                                long[] curCnt, int idx0) {
        System.arraycopy(finalCntLong, 0, curCnt, 1, curCnt.length - 1);
        curCnt[0] = idx0;
        // 反推
        int plansLen = plans.length;
        for (int i = plansLen - 1; i >= 0; i--) {
            // 第 i 天对编号 idx 的场馆执行了第 num 种调配方案
            int num = plans[i][0];
            int idx = plans[i][1];
            if (num == 1) {
                // 将编号为 idx 的场馆内的志愿者人数减半；
                curCnt[idx] *= 2;
            } else {
                Set<Integer> tos = fromToMap.getOrDefault(idx, new HashSet<>());
                for (int to : tos) {
                    if (num == 2) {
                        // 将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
                        curCnt[to] -= curCnt[idx];
                    } else {
                        // 将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
                        curCnt[to] += curCnt[idx];
                    }
                }
            }
        }
        long sum = 0;
        for (long num : curCnt) {
            sum += num;
        }
        return sum;
    }
}
/*
LCP 46. 志愿者调配
https://leetcode-cn.com/problems/05ZEDJ/

LCCUP 力扣杯 2021 秋季编程大赛战队赛 T3。

「力扣挑战赛」中 N*M 大小的自行车炫技赛场的场地由一片连绵起伏的上下坡组成，场地的高度值记录于二维数组 terrain 中，场地的减速值记录于二维数组 obstacle 中。
- 若选手骑着自行车从高度为 h1 且减速值为 o1 的位置到高度为 h2 且减速值为 o2 的相邻位置（上下左右四个方向），速度变化值为 h1-h2-o2（负值减速，正值增速）。
选手初始位于坐标 position 处且初始速度为 1，请问选手可以刚好到其他哪些位置时速度依旧为 1。请以二维数组形式返回这些位置。
若有多个位置则按行坐标升序排列，若有多个位置行坐标相同则按列坐标升序排列。
注意： 骑行过程中速度不能为零或负值
提示：
n == terrain.length == obstacle.length
m == terrain[i].length == obstacle[i].length
1 <= n <= 100
1 <= m <= 100
0 <= terrain[i][j], obstacle[i][j] <= 100
position.length == 2
0 <= position[0] < n
0 <= position[1] < m

设比赛结束后场馆 0 志愿者人数为 x 进行反推
由于三种方案都是一元操作，所以可以反推一元一次线性方程求解。设每个场馆人数为 f(x) = ax + b
初始状态
a[0] = 1
b[1...n-1] = finalCnt[0...n-2]
由于一元一次线性方程单调性，也可以使用二分查找求解。
 */
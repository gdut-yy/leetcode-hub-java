import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionLCP46 {
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
                if (num == 2) {
                    // 将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
                    for (int to : tos) {
                        ai[to] -= ai[idx];
                        bi[to] -= bi[idx];
                    }
                } else {
                    // 将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
                    for (int to : tos) {
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

    public int[] volunteerDeployment2(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        Map<Integer, Set<Integer>> fromToMap = buildFromToMap(edges);
        // 第 1 ~ n-1 个场馆
        int n = finalCnt.length + 1;
        int[] curCnt = new int[n];
        // 二分？
        int left = 0;
        int right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.arraycopy(finalCnt, 0, curCnt, 1, n - 1);
            long sum = extracted(plans, fromToMap, curCnt, mid);
            if (sum == totalNum) {
                return curCnt;
            } else if (sum < totalNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 二分？
        left = 0;
        right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.arraycopy(finalCnt, 0, curCnt, 1, n - 1);
            long sum = extracted(plans, fromToMap, curCnt, mid);
            if (sum == totalNum) {
                return curCnt;
            } else if (sum < totalNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
//        System.arraycopy(finalCnt, 0, curCnt, 1, n - 1);
//        long sum = extracted(plans, fromToMap, curCnt, 46909233);
        return new int[]{};
    }

    private long extracted(int[][] plans, Map<Integer, Set<Integer>> fromToMap, int[] curCnt, int idx0) {
        curCnt[0] = idx0;
        // 反推
        int plansLen = plans.length;
        for (int i = plansLen - 1; i >= 0; i--) {
            int[] plan = plans[i];
            // 第 i 天对编号 idx 的场馆执行了第 num 种调配方案
            int num = plan[0];
            int idx = plan[1];
            if (num == 1) {
                // 将编号为 idx 的场馆内的志愿者人数减半；
                curCnt[idx] *= 2;
            } else {
                Set<Integer> tos = fromToMap.getOrDefault(idx, new HashSet<>());
                if (num == 2) {
                    // 将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
                    for (int to : tos) {
                        curCnt[to] -= curCnt[idx];
                    }
                } else {
                    // 将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
                    for (int to : tos) {
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

1.将编号为 idx 的场馆内的志愿者人数减半；
2.将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
3.将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。

设比赛结束后场馆 0 志愿者人数为 x 进行反推
由于三种方案都是一元操作，所以可以反推一元一次线性方程求解。设每个场馆人数为 f(x) = ax + b
初始状态
a[0] = 1
b[1...n-1] = finalCnt[0...n-2]
由于一元一次线性方程单调性，也可以使用二分查找求解。
 */
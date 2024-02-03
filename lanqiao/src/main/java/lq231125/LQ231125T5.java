package lq231125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ231125T5 {
    static int n, m, q;
    static int[] s;
    static int[][] pk;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        s = new int[m];
        for (int i = 0; i < m; i++) {
            s[i] = scanner.nextInt();
        }
        pk = new int[q][2];
        for (int i = 0; i < q; i++) {
            pk[i][0] = scanner.nextInt();
            pk[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 种类, 区间
        Map<Integer, List<int[]>> ranges = new HashMap<>();
        for (int[] tuple : pk) {
            int p = tuple[0], k = tuple[1];
            int l = k - 1, r = Math.min(l + s[p - 1] - 1, n - 1);
            ranges.computeIfAbsent(p, e -> new ArrayList<>()).add(new int[]{l, r});
        }

        int[] diff = new int[n + 1];
        for (List<int[]> val : ranges.values()) {
            List<int[]> merged = merge(val);
            for (int[] p : merged) {
                int l = p[0], r = p[1];
                diff[l]++;
                diff[r + 1]--;
            }
        }

        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static List<int[]> merge(List<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int l = p[0], r = p[1];
            if (!ans.isEmpty() && l <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], r);
            } else {
                ans.add(new int[]{l, r});
            }
        }
        return ans;
    }
}
/*
充能计划【算法赛】

本题可以看成：
给定 n 个线段（闭区间），每个线段有颜色 ci，有 q 次询问，每次询问给定一个点 p，包含当前点的线段颜色有多少种。
稍作转换即可看成上述模型。
考虑将所有相同颜色的线段放在一块桶里，对于每一个桶，将所有的区间并起来。
然后维护一个全局的能量值数组，对于每个颜色，做区间加法即可，由于是对于每一个颜色操作，所以颜色是独立的，只要保证同一个颜色不会重复累加即可。
这就是区间并的一个模型。
 */
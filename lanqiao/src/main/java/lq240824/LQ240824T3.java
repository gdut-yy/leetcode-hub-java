package lq240824;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240824T3 {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : a) {
            cnt.merge(v, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> list = new java.util.ArrayList<>(cnt.entrySet().stream().collect(Collectors.toList()));
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        int ans = 0;
        int cur = 0;
        int m = list.size();
        for (int i = 0; i < m; i++) {
            if (cur + (m - i) >= k) {
                ans = Math.min(k, m - i);
                break;
            }
            cur += list.get(i).getValue();
        }
        return String.valueOf(ans);
    }
}
/*
挑选武将【算法赛】

题意不是十分清晰，有好几种理解。
统计频次，然后按频次倒序排序后，枚举即可。
 */
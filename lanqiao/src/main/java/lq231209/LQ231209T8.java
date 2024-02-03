package lq231209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LQ231209T8 {
    static int n, k;
    static int[][] pv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        pv = new int[n][2];
        for (int i = 0; i < n; i++) {
            pv[i][0] = scanner.nextInt();
            pv[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int INF = (int) (1e9 + 5);

    private static String solve() {
        Arrays.sort(pv, Comparator.comparingInt(o -> o[0]));
        int left = 0;
        int right = INF;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = left == INF ? -1 : left - 1;
        return String.valueOf(ans);
    }

    static boolean checkMid(long mid) {
        long[] np = new long[n];
        for (int i = 0; i < n; i++) {
            np[i] = mid * pv[i][1] + pv[i][0];
        }
        int len = lengthOfLIS(np);
        return n - len > k;
    }

    static int lengthOfLIS(long[] nums) {
        List<Long> a = new ArrayList<>();
        for (long x : nums) {
            int j = lowerBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
        }
        return a.size();
    }

    static int lowerBound(List<Long> a, long key) {
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
小球碰撞【算法赛】

二分查找 + LIS
 */
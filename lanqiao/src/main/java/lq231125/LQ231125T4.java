package lq231125;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LQ231125T4 {
    static long x, y, z;
    static int q;
    static long[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        q = scanner.nextInt();
        s = new long[q];
        for (int i = 0; i < q; i++) {
            s[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        Set<Long> set = new HashSet<>();
        long tx = 1, ty, tz;
        for (int i = 0; i <= 64; i++) {
            ty = 1;
            for (int j = 0; j <= 64; j++) {
                tz = 1;
                for (int k = 0; k <= 64; k++) {
                    set.add(tx + ty + tz);

                    if ((INF - tx - ty) / tz < z) break;
                    tz *= z;
                }
                if ((INF - tx) / ty < y) break;
                ty *= y;
            }
            if (INF / tx < x) break;
            tx *= x;
        }
        List<Long> t = new ArrayList<>(set);
        t.sort(null);

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int j0 = lowerBound(t, s[i]);
            for (int j = j0; j < t.size(); j++) {
                if (j - j0 != t.get(j) - s[i]) {
                    long a = t.get(j - 1) + 1;
                    long b = t.get(j) - a;
                    ans[i] = a + " " + b;
                    break;
                }
            }
        }
        return String.join(System.lineSeparator(), ans);
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
恒纪元【算法赛】

考察构造、思维
我们尝试去构造所有的乱纪元
具体来说，我们枚举 a,b,c，由于数值不到 10^12，并且 x,y,z 不全为 1，那么我们可以枚举系数，得到所有的乱纪元
之后我们去重，并且排序，每输入一个数，我们在数组中查找这个数，然后不断向后找，最终可以得到 S 后的一个恒纪元。
实测在 10^18 范围内，乱纪元不超过 3000 个，所以查找的时候二分查找或者暴力都可。
近似复杂度：O(3000*q + 64^3)
 */
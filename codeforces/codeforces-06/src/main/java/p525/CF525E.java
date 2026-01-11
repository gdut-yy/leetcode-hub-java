package p525;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF525E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int k;
    static long tar;
    static final int MX = 20;
    static long[] F = new long[MX + 1];

    static {
        F[0] = F[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i;
    }

    private static void solve() {
        int n = scanner.nextInt();
        k = scanner.nextInt();
        tar = scanner.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int mid = n / 2;
        int[] a1 = Arrays.copyOfRange(a, 0, mid);
        int[] a2 = Arrays.copyOfRange(a, mid, n);

        Map<Long, int[]> cnt1 = calc(a1);
        Map<Long, int[]> cnt2 = calc(a2);

        long ans = 0;
        for (Map.Entry<Long, int[]> entry : cnt2.entrySet()) {
            long x = entry.getKey();
            int[] b = entry.getValue();
            long rem = tar - x;
            if (cnt1.containsKey(rem)) {
                int[] c = cnt1.get(rem);
                int s = 0;
                for (int i = k; i >= 0; i--) {
                    s += c[k - i];
                    ans += (long) b[i] * s;
                }
            }
        }
        out.println(ans);
    }

    static Map<Long, int[]> calc(int[] arr) {
        Map<Long, int[]> map = new HashMap<>();
        dfs(arr, 0, 0, 0, map);
        return map;
    }

    static void dfs(int[] arr, int idx, int used, long sum, Map<Long, int[]> map) {
        if (sum > tar) {
            return;
        }
        if (idx == arr.length) {
            if (!map.containsKey(sum)) {
                map.put(sum, new int[k + 1]);
            }
            int[] cntArr = map.get(sum);
            if (used <= k) {
                cntArr[used]++;
            }
            return;
        }

        // Option 1: skip current element
        dfs(arr, idx + 1, used, sum, map);

        // Option 2: take element as is
        if (sum + arr[idx] <= tar) {
            dfs(arr, idx + 1, used, sum + arr[idx], map);
        }

        // Option 3: take factorial if possible
        if (used < k && arr[idx] < F.length) {
            long nextSum = sum + F[arr[idx]];
            if (nextSum <= tar) {
                dfs(arr, idx + 1, used + 1, nextSum, map);
            }
        }
    }
}
/*
E. Anya and Cubes
https://codeforces.com/contest/525/problem/E

灵茶の试炼 2025-08-14
题目大意：
输入 n(1≤n≤25) k(0≤k≤n) S(1≤S≤1e16) 和长为 n 的数组 a(1≤a[i]≤1e9)。
从 a 中选一个子序列 b。（子序列不一定连续）
你可以把 b 中的至多 k 个数 x 变成 x!，即 x 的阶乘。每个数只能操作一次。
设 b 操作后变成 b'。
有多少个子序列 b 满足 sum(b') = S？

rating 2100
折半枚举。
枚举 a 的前 n/2 个元素的所有组合情况：
a[i] 不选。
a[i] 选，但不算阶乘。
a[i] 选，算阶乘。
我们可以得到一个哈希表，key 是元素和，value 是列表，列表第 i 项表示用了恰好 i 个阶乘时的方案数。
这需要 O(3^(n/2)) 时间。
后 n/2 个元素同理，得到另一个哈希表。
然后遍历第一个哈希表的 key，去第二个哈希表找 S-key。
得到两个列表，第一个列表用了恰好 i 个阶乘，第二个列表可以用 <= k-i 个阶乘。可以用前缀和加速。
代码 https://codeforces.com/problemset/submission/525/332294446
代码备份（上面打不开的同学看这个）
======

Input
2 2 30
4 3
Output
1

Input
2 2 7
4 3
Output
1

Input
3 1 1
1 1 1
Output
6
 */

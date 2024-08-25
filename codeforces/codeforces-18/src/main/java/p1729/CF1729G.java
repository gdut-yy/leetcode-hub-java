package p1729;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1729G {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        while (q-- > 0) {
            s = scanner.next();
            t = scanner.next();
            System.out.println(solve());
        }
    }

    private static final int MOD = (int) (1e9 + 7);
    private static List<Integer> a;
    private static int n, m;
    private static int minMove;
    private static int[][] memo;

    private static String solve() {
        // a := suffixarray.New(s).Lookup(t, -1)
        // sort.Ints(a)
        a = new ArrayList<>();
        int idx = s.indexOf(t);
        while (idx != -1) {
            a.add(idx);
            idx = s.indexOf(t, idx + 1);
        }
        n = a.size();
        m = t.length();

        minMove = 0;
        int i0 = 0;
        while (i0 < n) {
            minMove++;
            int j = searchInts(a, a.get(i0) + m) - 1;
            i0 = searchInts(a, a.get(j) + m);
        }

        memo = new int[n][minMove + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = dfs(0, 0);
        return minMove + " " + ans;
    }

    private static int dfs(int i, int j) {
        if (j > minMove) return 0;
        if (i == n) return 1;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        int r = searchInts(a, a.get(i) + m);
        for (int k = i; k < r; k++) {
            res = (res + dfs(searchInts(a, a.get(k) + m), j + 1)) % MOD;
        }
        return memo[i][j] = res;
    }

    private static int searchInts(List<Integer> a, int key) {
        int left = 0;
        int right = a.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (a.get(mid) >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
G. Cut Substrings
https://codeforces.com/contest/1729/problem/G

灵茶の试炼 2023-06-23
题目大意：
输入 T(≤50) 表示 T 组数据。所有数据的 s 长度之和 ≤500，t 长度之和 ≤500。
每组数据输入两个长度均不超过 500 的字符串 s 和 t，只包含小写字母。
每次操作，从 s 中找到一个等于 t 的子串，然后用点号替换这个子串。
要使 s 中不包含 t，至少要操作多少次？
输出最小操作次数 x。输出操作 x 次使得 s 不包含 t 的方案数，模 1e9+7。
注：子串是连续的。

rating 2100
https://codeforces.com/contest/1729/submission/209145544 记忆化搜索（推荐先看这个）
https://codeforces.com/contest/1729/submission/209145793 递推
先计算最小操作次数，这可以贪心。
找出所有 t 在 s 中的位置，然后贪心替换：如果第一个 t 与第二个 t 没有重叠，那么必须替换第一个 t；否则替换第二个 t ，也能让第一个 t 不在 s 中。具体来说，需要在第一个 t 的【范围】内替换一个最右的 t（这个最右的 t，只要第一个字母的下标在【范围】内即可）。替换后，按同样的方式替换后续的 t。
然后就可以写一个二维 DP 了，dfs(i,j) 表示当前要处理后缀 s[i:]，且已经替换了 j 次。枚举下一个要替换的 t。
你也可以把 t 在 s 中的所有位置都处理出来，设为数组 a，然后在 a 上 DP。具体见代码。
======

input
8
abababacababa
aba
ddddddd
dddd
xyzxyz
xyz
abc
abcd
abacaba
abaca
abc
def
aaaaaaaa
a
aaaaaaaa
aa
output
2 2
1 4
2 1
0 1
1 1
0 1
8 1
3 6
 */

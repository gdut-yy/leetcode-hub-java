package p1841;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CF1841E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            long m = scanner.nextLong();
            System.out.println(solve(n, a, m));
        }
    }

    private static final int MAX_N = (int) (2e5 + 5);

    // https://codeforces.com/contest/1841/submission/209462304
    private static String solve(int n, int[] a, long m) {
        List<List<Integer>> removeList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            removeList.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            if (a[i] > 0) {
                removeList.get(a[i]).add(i);
            }
        }

        long[] cnt = new long[n + 1];
        cnt[n] = n;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        mp.put(1, n);
        mp.put(0, 0);
        mp.put(n + 1, n + 1);
        for (int i = n; i >= 1; i--) {
            for (Integer j : removeList.get(i)) {
                Map.Entry<Integer, Integer> entry = mp.floorEntry(j);
                int L = entry.getKey(), R = entry.getValue();
                cnt[R - L + 1] -= i;
                mp.remove(L);
                if (j > L) {
                    mp.put(L, j - 1);
                    cnt[j - L] += i;
                }
                if (j < R) {
                    mp.put(j + 1, R);
                    cnt[R - j] += i;
                }
            }
        }

        long ans = 0;
        for (int sz = n; sz >= 2; sz--) {
            if (cnt[sz] == 0) continue;
            long usedCnt = Math.min(m / sz, cnt[sz]);
            ans += usedCnt * (sz - 1);
            m -= usedCnt * sz;
            cnt[sz] -= usedCnt;
            if (0 < m && m < sz && cnt[sz] >= 1) {
                ans += m - 1;
                m = 0;
            }
            if (m == 0) break;
        }
        return String.valueOf(ans);
    }
}
/*
E. Fill the Matrix
https://codeforces.com/contest/1841/problem/E

题目大意：
有一个方阵，由 n 行 n 列的单元格组成，编号从 1 到 n。细胞呈白色或黑色。在第 i 列中，从 1 到 ai 的单元格为黑色，从 ai+1 到 n 的单元格为白色。
你想在矩阵中放入 m 个整数，从 1 到 m。这里有两条规则:
- 每个单元格最多只能包含一个整数;
- 黑色单元格不应包含整数。
这个矩阵的美妙之处在于 j+1 被写在同一行的 j 的数量，在 j 的下一列(在右边相邻的单元格中)。
矩阵最大可能的美是什么?

xoxx
xoxo
ooxo
oooo
倒序维护
======

input
6
3
0 0 0
9
4
2 0 3 1
5
4
2 0 3 1
6
4
2 0 3 1
10
10
0 2 2 1 5 10 3 4 1 1
20
1
1
0
output
6
3
4
4
16
0
 */

package c457;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Abc457_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] ls = new ArrayList[n + 1];
        List<Integer>[] rs = new ArrayList[n + 1];
        Arrays.setAll(ls, e -> new ArrayList<>());
        Arrays.setAll(rs, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            ls[r].add(l);
            rs[l].add(r);
        }
        int[] maxL2 = new int[n + 1];
        int mx = 0, mx2 = 0;
        for (int r = 0; r <= n; r++) {
            Collections.sort(ls[r]);
            for (int l : ls[r]) {
                if (l > mx) {
                    mx2 = mx;
                    mx = l;
                } else if (l > mx2) {
                    mx2 = l;
                }
            }
            maxL2[r] = mx2;
            Collections.sort(rs[r]);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int idx = upperBound(rs[l], r) - 1;
            if (idx < 0) {
                out.println("No");
                continue;
            }
            int r1 = rs[l].get(idx);
            if (r1 == r) {
                out.println(maxL2[r] >= l ? "Yes" : "No");
            } else {
                int j = lowerBound(ls[r], l);
                out.println(j < ls[r].size() && ls[r].get(j) <= r1 + 1 ? "Yes" : "No");
            }
        }
    }

    static int upperBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) > key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int lowerBound(List<Integer> a, int key) {
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
E - Crossing Table Cloth
https://atcoder.jp/contests/abc457/tasks/abc457_e

灵茶の试炼 2026-06-10
题目大意：
输入 n(1≤n≤2e5) m(2≤m≤2e5) 和 m 个闭区间 [L,R]，范围 [1,n]。
然后输入 q(1≤q≤2e5) 和 q 个询问，每个询问输入 [S,T]，范围 [1,n]。
对于每个询问，能否从这 m 个区间中恰好选择两个区间，使得这两个区间的并集恰好为 [S,T]？
输出 Yes 或 No。

rating
设询问为 [L,R]。
在左端点恰好等于 L 的区间中，二分找最大的 <= R 的右端点。
在右端点恰好等于 R 的区间中，二分找最小的 >= L 的左端点。
如果这两个区间相交或者相邻，那么满足要求。
但是，如果这两个区间是同一个区间呢？
如果第一个区间的右端点恰好等于 R，那么还需要保证 [L,R] 至少包含两个区间。
换句话说，在右端点 <= R 的区间中，至少有两个区间的左端点 >= L。
维护右端点 <= R 的区间中的第二大左端点，记录在数组 maxL2[R] 中。
如果 maxL2[R] >= L，则说明 [L,R] 至少包含两个区间。
代码 https://atcoder.jp/contests/abc457/submissions/76227528
======

Input 1
4 3
1 3
1 1
2 4
4
1 4
2 4
1 3
1 1
Output 1
Yes
No
Yes
No

Input 2
7 10
2 6
2 5
3 6
1 6
1 2
5 6
2 3
3 7
2 3
1 2
10
1 2
3 5
1 4
1 5
1 5
5 7
1 6
2 3
5 7
2 4
Output 2
Yes
No
No
Yes
Yes
No
Yes
Yes
No
No
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Shopee004 {
    static Scanner scanner;
    static PrintWriter out;

    static int n, K;
    static long[] a, s, f, g;
    static Rec[] q;
    static int l, r;

    static class Rec {
        int l, r, x;

        Rec(int l, int r, int x) {
            this.l = l;
            this.r = r;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        n = scanner.nextInt();
        K = scanner.nextInt();
        a = new long[n + 1];
        s = new long[n + 1];
        f = new long[n + 1];
        g = new long[n + 1];
        q = new Rec[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
            s[i] = s[i - 1] + a[i];
        }

        for (int i = 1; i <= n; i++) {
            f[i] = cal(0, i);
        }

        for (int k = 2; k <= K; k++) {
            l = 0;
            r = 0;
            q[0] = new Rec(1, n, 0);
            for (int i = 1; i <= n; i++) {
                while (l <= r && q[l].r < i) l++;
                q[l].l = i;
                g[i] = cal(q[l].x, i);
                insert(i);
            }
            System.arraycopy(g, 0, f, 0, n + 1);
        }

        out.println(f[n]);
    }

    private static long cal(int left, int right) {
        return f[left] + (s[right] - s[left]) * (right - left);
    }

    private static void insert(int i) {
        int nl = -1;
        while (l <= r && cal(i, q[r].l) <= cal(q[r].x, q[r].l)) {
            nl = q[r--].l;
        }
        if (l <= r && cal(i, q[r].r) < cal(q[r].x, q[r].r)) {
            int L = q[r].l;
            int R = q[r].r;
            while (L < R) {
                int M = (L + R) / 2;
                if (cal(i, M) <= cal(q[r].x, M)) {
                    R = M;
                } else {
                    L = M + 1;
                }
            }
            q[r].r = L - 1;
            nl = L;
        }
        if (nl != -1) {
            q[++r] = new Rec(nl, n, i);
        }
    }
}
/*
Shopee-004. Divider
https://leetcode.cn/problems/VdG6tT/

Shopee has N software engineers. Shopee accommodates them by arranging N tables on a 1D plane. However, many people raise concerns that the work environment is too noisy. To mitigate this issue, Shopee decides to group the engineers into K groups. A group is a non-overlapping segment of contiguous engineers. Shopee will then put dividers between the groups.

The noise value of a group is defined by the following function:

noise(l, r) = sum(A[l], A[l + 1], ..., A[r]) * (r - l + 1)

Where:

noise(l, r) represents the noise value of a group consisting of the l-th engineer up to the r-th engineer.
A[i] represents the noise factor of the i-th engineer.
Shopee wants to minimize the total noise value. Please help Shopee to find the minimum total noise value possible.

Input Format
The first line of input contains 2 integers: N, K (1 <= N <= 10,000; 1 <= K <= min(N, 100)) representing the number of engineers and the number of groups respectively. The next line contains N integers: A[i] (1 <= A[i] <= 10,000) representing the noise factor of the i-th engineer.

Output Format
Output in a line an integer representing the minimum total noise value possible.

Sample Input
4 2
1 3 2 4

Sample Output
20

Explanation
1 | 3 2 4
(1 * 1) + (9 * 3) = 28
1 3 | 2 4
(4 * 2) + (6 * 2) = 20
1 3 2 | 4
(6 * 3) + (4 * 1) = 22

We can see that from all the possibilities, 20 is the minimum total noise value.
 */
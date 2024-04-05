package lq240127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LQ240127T9 {
    static int m;
    static int[] q;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        m = scanner.nextInt();
        q = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            q[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int n = (int) (1e6 + 5);
        int[] lst = new int[n];
        int[] ans = new int[m + 1];
        Fenwick t = new Fenwick(m);
        for (int i = 1; i <= m; i++) {
            if (lst[q[i]] == 0) {
                ans[m]++;
            } else {
                int key = t.getSum(i - 1) - t.getSum(lst[q[i]]);
                ans[key]++;
            }
            t.add(i, 1);
            if (lst[q[i]] != 0) {
                t.add(lst[q[i]], -1);
            }
            lst[q[i]] = i;
        }
        for (int i = m - 1; i >= 0; i--) {
            ans[i] += ans[i + 1];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static class Fenwick {
        private final int N;
        private final int[] tree;

        public Fenwick(int n) {
            this.N = n;
            this.tree = new int[N + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        // nums[x] add k
        public void add(int x, int k) {
            while (x <= N) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        public int getSum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
缺页异常2【算法赛】

考虑你有一个无限大的缓存，缓存里的页按照从上到下最近访问时间依次增加到排布（即每次访问一个已经存在于缓存中的页面的时候就把它提到最上面，每次插入新页面的时候就插入在最上面）。对于任意的页面访问顺序，如果限制了缓存大小为 k，相当于只看这个无限大缓存空间的前 k 个。
因此只需要维护一个无限大的缓存空间，每当出现一个页面访问请求的时候，如果这个页面从未出现，则所有大小的缓存都会出现一次缺页中断，否则假设这个页面出现在从上往下的第 t 个页面中，则缓存大小为 0~t-1 的缓存会出现一个页面中断。
这相当于一次前缀加，由于只有在最后 需要进行一次查询，使用差分数组可以 O(m) 维护中断次数。
---
剩下的问题就是如何知道当前访问的页面的是从上往下的第几个页面中。仔细思考可以发现一个页面被访问的时候仍然存在缓存里的条件是：该页面上一次访问到这次访问之间不同的其他页面数不大于缓存大小。因此只要处理出任意两个相同的数之间的不同的数的个数即可。
这个有许多做法，一个比较经典且快速的做法是从左到右扫数组，每次将每种数字的最后一个设为 1，其他设为 0，这样直接求区间和即可获得不同的数的个数。设置数为 0,1 是一个单点修改，因此只需要树状数组维护单点修改区间求和即可。
复杂度为 O(mlogV)，其中 V 是值域，为 10^6.
 */
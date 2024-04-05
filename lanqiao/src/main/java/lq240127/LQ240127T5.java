package lq240127;

import java.util.Scanner;

public class LQ240127T5 {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            b[x] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Fenwick f = new Fenwick(n);
        Fenwick g = new Fenwick(n);
        for (int i = 1; i <= n; i++) {
            a[i] = b[a[i]];
            long tmp = f.getSum(a[i] - 1);
            long x = g.getSum(a[i] - 1);
            ans += x * i - tmp;
            f.add(a[i], i);
            g.add(a[i], 1);
        }
        return String.valueOf(ans);
    }

    static class Fenwick {
        private final int N;
        private final long[] tree;

        public Fenwick(int n) {
            this.N = n;
            this.tree = new long[N + 1];
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
        public long getSum(int x) {
            long ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
压制二元组的总价值【算法赛】

树状数组。
 */
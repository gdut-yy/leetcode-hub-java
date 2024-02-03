package lq231223;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ231223T7 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        long[][] nums = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            int c = scanner.nextInt();
            nums[i][c - 1] = 1;
        }
        SegmentTreeMat seg = new SegmentTreeMat(n, nums);
        String[] output = new String[m];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int opt = scanner.nextInt();

            int a = scanner.nextInt();
            if (opt == 1) {
                int b = scanner.nextInt();
                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                if (a == 1 && b == 2) {
                    seg.update(l, r, swap1_2);
                }
                if (a == 1 && b == 3) {
                    seg.update(l, r, swap1_3);
                }
                if (a == 2 && b == 3) {
                    seg.update(l, r, swap2_3);
                }
            } else if (opt == 2) {
                int b = scanner.nextInt();
                if (a == 1 && b == 2) seg.update(l, r, change1_2);
                if (a == 1 && b == 3) seg.update(l, r, change1_3);
                if (a == 2 && b == 3) seg.update(l, r, change2_3);
                if (a == 2 && b == 1) seg.update(l, r, change2_1);
                if (a == 3 && b == 1) seg.update(l, r, change3_1);
                if (a == 3 && b == 2) seg.update(l, r, change3_2);
            } else {
                if (a == 1) seg.update(l, r, split1);
                if (a == 2) seg.update(l, r, split2);
                if (a == 3) seg.update(l, r, split3);
            }
            long[] sum = seg.getSum(1, n);
            output[i] = Arrays.stream(sum).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        }
        System.out.println(String.join(System.lineSeparator(), output));
    }

    // 颜色互换
    static final long[][] swap1_2 = {{0, 1, 0}, {1, 0, 0}, {0, 0, 1}};
    static final long[][] swap1_3 = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}};
    static final long[][] swap2_3 = {{1, 0, 0}, {0, 0, 1}, {0, 1, 0}};
    // 染色
    static final long[][] change1_2 = {{0, 1, 0}, {0, 1, 0}, {0, 0, 1}};
    static final long[][] change1_3 = {{0, 0, 1}, {0, 1, 0}, {0, 0, 1}};
    static final long[][] change2_3 = {{1, 0, 0}, {0, 0, 1}, {0, 0, 1}};
    static final long[][] change2_1 = {{1, 0, 0}, {1, 0, 0}, {0, 0, 1}};
    static final long[][] change3_1 = {{1, 0, 0}, {0, 1, 0}, {1, 0, 0}};
    static final long[][] change3_2 = {{1, 0, 0}, {0, 1, 0}, {0, 1, 0}};
    // 分裂
    static final long[][] split1 = {{2, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    static final long[][] split2 = {{1, 0, 0}, {0, 2, 0}, {0, 0, 1}};
    static final long[][] split3 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 2}};

    static class SegmentTreeMat {
        static final int MOD = 998244353;
        static final long[][] ONE = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}; // 单位矩阵
        int n;
        long[][] nums;

        long[][] tree;
        long[][][] lazy;

        public SegmentTreeMat(int n, long[][] nums) {
            this.n = n;
            this.tree = new long[n * 4][3];
            this.lazy = new long[n * 4][3][3];
            for (int i = 0; i < n * 4; i++) {
                lazy[i] = new long[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
            }

            this.nums = nums;
            build(1, 1, n);
        }

        void build(int p, int l, int r) {
            if (l == r) {
                tree[p] = nums[l].clone();
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            pushUp(p);
        }

        void update(int ql, int qr, long[][] val) {
            update(1, 1, n, ql, qr, val);
        }

        void update(int p, int l, int r, int ql, int qr, long[][] val) {
            if (ql <= l && r <= qr) {
                tree[p] = matMul(tree[p], val);
                lazy[p] = matMul(lazy[p], val);
                return;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
            if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long[] getSum(int ql, int qr) {
            return getSum(1, 1, n, ql, qr);
        }

        long[] getSum(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            long[] res = new long[3];
            if (ql <= mid) res = mulAdd(res, getSum(p << 1, l, mid, ql, qr));
            if (qr > mid) res = mulAdd(res, getSum(p << 1 | 1, mid + 1, r, ql, qr));
            return res;
        }

        void pushDown(int p) {
            if (!Arrays.deepEquals(ONE, lazy[p])) {
                tree[p << 1] = matMul(tree[p << 1], lazy[p]);
                tree[p << 1 | 1] = matMul(tree[p << 1 | 1], lazy[p]);
                lazy[p << 1] = matMul(lazy[p << 1], lazy[p]);
                lazy[p << 1 | 1] = matMul(lazy[p << 1 | 1], lazy[p]);
                lazy[p] = new long[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
            }
        }

        void pushUp(int p) {
            tree[p] = mulAdd(tree[p << 1], tree[p << 1 | 1]);
        }

        // 矩阵加法 res[] = a[] + b[]
        long[] mulAdd(long[] a, long[] b) {
            int n = a.length;
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = (a[i] + b[i]) % MOD;
            }
            return res;
        }

        // 矩阵乘法 res[] = a[] * b[][]
        long[] matMul(long[] a, long[][] b) {
            int n = a.length;
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i] += a[j] * b[j][i] % MOD;
                    res[i] %= MOD;
                }
            }
            return res;
        }

        // 矩阵乘法 res[][] = a[][] * b[][]
        long[][] matMul(long[][] a, long[][] b) {
            int n = a.length;
            long[][] res = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        res[i][j] += a[i][k] * b[k][j] % MOD;
                        res[i][j] %= MOD;
                    }
                }
            }
            return res;
        }
    }
}
/*
魔术师【算法赛】

考察数据结构，矩阵线段树。
由于考虑将所有矩阵看成操作序列，维护矩阵乘法进行操作的合并即可。
对于线段树的每一个节点，维护三个值，表示每种颜色的数量。
---
对于颜色互换操作，就是乘以一个交换矩阵。
例如，交换 1,2 号颜色，三种颜色的数量为 a1,a2,a3。
那么就是：
\begin{bmatrix}
a_1 & a_2 & a_3
\end{bmatrix}
\times
\begin{bmatrix}
 0 & 1 & 0\\
 1 & 0 & 0\\
 0 & 0 & 1
\end{bmatrix}
---
对于染色操作：
例如：将 1 染色为 2，三种颜色的数量为 a1,a2,a3。
那么就是：
\begin{bmatrix}
a_1 & a_2 & a_3
\end{bmatrix}
\times
\begin{bmatrix}
 0 & 1 & 0\\
 0 & 1 & 0\\
 0 & 0 & 1
\end{bmatrix}
---
对于分裂操作：
例如：将 2 颜色分裂，三种颜色的数量为 a1,a2,a3。
那么就是：
\begin{bmatrix}
a_1 & a_2 & a_3
\end{bmatrix}
\times
\begin{bmatrix}
 1 & 0 & 0\\
 0 & 2 & 0\\
 0 & 0 & 1
\end{bmatrix}
---
线段树维护区间矩阵乘法即可。
复杂度：O(3^3 * mlogn)，常数略大。
其他方式维护的线段树也能通过，只是维护复杂一些。
 */
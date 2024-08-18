package lq240504;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LQ240504T7 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(a[i], e -> new ArrayList<>()).add(i + 1);
        }

        long ans = 0;
        SegTreeUpd_sum seg = new SegTreeUpd_sum(n * 2);
        for (Map.Entry<Integer, List<Integer>> p : mp.entrySet()) {
            int now = 0, last = 0;
            List<int[]> vec = new ArrayList<>();

            p.getValue().add(n + 1);
            for (Integer x : p.getValue()) {
                int nxt = now - (x - last - 1);
                ans += seg.getSum(nxt - 2 + n, now - 2 + n);
                ans += seg.getSum(nxt - 1 + n, now - 1 + n);
                seg.add(nxt + n, now + n, 1);
                vec.add(new int[]{nxt, now});
                now = nxt + 1;
                last = x;
            }
            for (int[] v : vec) {
                seg.add(v[0] + n, v[1] + n, -1);
            }
        }
        return String.valueOf(ans);
    }

    static class SegTreeUpd_sum {
        int n;
        long[] tree, lazy;

        public SegTreeUpd_sum(int n) {
            this.n = n;
            this.tree = new long[4 * n];
            this.lazy = new long[4 * n];
        }

        void add(int ql, int qr, int val) {
            add(1, 0, n, ql, qr, val);
        }

        void add(int p, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                tree[p] += (r - l + 1L) * val;
                lazy[p] += val;
                return;
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            if (ql <= mid) add(p << 1, l, mid, ql, qr, val);
            if (qr > mid) add(p << 1 | 1, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getSum(int ql, int qr) {
            return getSum(1, 0, n, ql, qr);
        }

        long getSum(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            long sum = 0;
            if (ql <= mid) sum += getSum(p << 1, l, mid, ql, qr);
            if (qr > mid) sum += getSum(p << 1 | 1, mid + 1, r, ql, qr);
            return sum;
        }

        void pushDown(int p, int l, int r) {
            if (lazy[p] != 0) {
                int mid = l + (r - l) / 2;
                tree[p << 1] += lazy[p] * (mid - l + 1);
                tree[p << 1 | 1] += lazy[p] * (r - mid);
                lazy[p << 1] += lazy[p];
                lazy[p << 1 | 1] += lazy[p];
                lazy[p] = 0;
            }
        }

        void pushUp(int p) {
            tree[p] = tree[p << 1] + tree[p << 1 | 1];
        }
    }
}
/*
Yaya 与区间【算法赛】

首先考虑对每一种数单独处理。
假设当前枚举的数是 x，构造序列 b1..n，当 ai=x 时 bi=1，否则 bi=-1，这样我们只需要统计有多少 b 序列的区间和等于 1 或者 2 即可。
那么我们可以发现，当区间长度大于 1 时，连续的段 1 或者一段 -1 是不会对答案产生贡献的。因此，我们只需要考虑 1 和 -1 都出现的情况。
由于统计的是区间和等于 1 的区间个数，因此转化为前缀和后，等价于统计 sumr - suml = 1 的 (l,r) 对数。
对于一段相同的数，我们可以在线段树上先统计以它们作为区间右端点的答案，再就将这些点作为新的左端点加入线段树。
这样只用 O(cnt * logn) 的时间复杂度就可以解决对于一个数的贡献计算。那么对于所有数，段数的总和是 O(n) 的，故总时间复杂度为 O(nlogn)。
@TsReaper
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3901 {
    static int n, q;
    static int[] a;
    static int[][] qs; // l, r, i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        qs = new int[q][3];
        for (int i = 0; i < q; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = scanner.nextInt();
            qs[i][2] = i;
        }
        System.out.println(solve());
    }

    static final int maxn = (int) (1e5 + 5);

    private static String solve() {
        int[] last = new int[maxn];
        int[] Left = new int[maxn];
        int[] Max_Left = new int[maxn];
        for (int i = 1; i <= n; i++) {
            Left[i] = last[a[i]];
            last[a[i]] = i;
            Max_Left[i] = Math.max(Max_Left[i], Left[i]);
            Max_Left[i] = Math.max(Max_Left[i], Max_Left[i - 1]);
        }
        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int l = qs[i][0], r = qs[i][1];
            ans[i] = Max_Left[r] >= l ? "No" : "Yes";
        }
        return Arrays.stream(ans).collect(Collectors.joining(System.lineSeparator()));
    }

//    private static String solve() {
//        Arrays.sort(qs, Comparator.comparingInt(o -> o[1]));
//
//        String[] ans = new String[q];
//        int pow = 1;
//        int[] vis = new int[maxn];
//        BIT tr = new BIT(maxn);
//        for (int i = 0; i < q; i++) {
//            for (int j = pow; j <= qs[i][1]; j++) {
//                if (vis[a[j]] != 0) {
//                    tr.add(vis[a[j]], -1);
//                }
//                tr.add(j, 1);
//                vis[a[j]] = j;
//            }
//            pow = qs[i][1] + 1;
//            ans[qs[i][2]] = (tr.query(qs[i][1]) - tr.query(qs[i][0] - 1) == qs[i][1] - qs[i][0] + 1) ? "Yes" : "No";
//        }
//        return Arrays.stream(ans).collect(Collectors.joining(System.lineSeparator()));
//    }
//
//    static class BIT {
//        int n;
//        int[] tree;
//
//        public BIT(int n) {
//            this.n = n;
//            tree = new int[n + 1];
//        }
//
//        int lb(int x) {
//            return x & -x;
//        }
//
//        void add(int pos, int val) {
//            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
//        }
//
//        int query(int pos) {
//            int ret = 0;
//            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
//            return ret;
//        }
//    }
}
/*
P3901 数列找不同
https://www.luogu.com.cn/problem/P3901

灵茶の试炼 2024-07-08 ext
# 数列找不同

## 题目描述

现有数列 $A_1,A_2,\ldots,A_N$，$Q$ 个询问 $(L_i,R_i)$，询问 $A_{L_i} ,A_{L_i+1},\ldots,A_{R_i}$ 是否互不相同。

## 输入格式

第一行，两个整数$N,Q$。
第二行，$N$ 个整数$A_1, A_2, \ldots , A_N$。
接下来 $Q$ 行，每行两个整数 $L_i,R_i$。

## 输出格式

对每个询问输出一行，`Yes` 或 `No`。

## 样例 #1

### 样例输入 #1

```
4 2
1 2 3 2
1 3
2 4
```

### 样例输出 #1

```
Yes
No
```

## 提示

对于 $50\%$ 的数据，$N,Q  \le 10^3$。
对于 $100\%$ 的数据，$1 \le N,Q \le 10^5$，$1 \le A_i \le N$，$1 \le L_i \le R_i \le N$。
 */
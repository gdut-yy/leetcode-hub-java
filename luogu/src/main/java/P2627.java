import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P2627 {
    static int n, k;
    static long[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        s = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextLong();
            s[i] += s[i - 1];
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] f = new long[n + 2];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        for (int i = 1; i <= n; i++) {
            if (dq.getFirst() < i - k) {
                dq.removeFirst();
            }
            f[i + 1] = Math.max(f[i], s[i] + f[dq.getFirst()] - s[dq.getFirst()]);
            while (!dq.isEmpty() && f[dq.getLast()] - s[dq.getLast()] <= f[i] - s[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return String.valueOf(f[n + 1]);
    }
}
/*
https://www.luogu.com.cn/problem/P2627

灵茶の试炼 2025-04-09
输入 n k(1≤k≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
从 a 中选择一些数，但这些数中，不能有超过 k 个数的下标是连续的，即下标 i,i+1,i+2,...,i+k 不能都选。
输出你选的数的最大和。

用划分型 DP 思考。
下标从 0 开始。
定义 f[i+1] 表示从左闭右开区间 [0,i) 中选数字，元素和的最大值。这里 +1 是为了避免下标出现负数。
如果不选 a[i-1]，那么 f[i+1] = f[i]。
如果选 a[i-1]，那么枚举子数组左端点 L=i-k,i-k+1,...,i-1，子问题为从 [0,L-1) 中选数字，元素和的最大值，即 f[L]。
于是转移方程为
f[i+1] = max(f[i], max{f[L] + s[i] - s[L]})
其中 s[i] 是 a 的前缀和数组。
把 s[i] 提出来，max{f[L] - s[L]} 是 239. 滑动窗口最大值，可以用单调队列优化。
注：如果定义成「f[i] 表示从左闭右开区间 [0,i) 中选数字，元素和的最大值」，转移方程会是 max{f[L-1] - s[L]}，这会导致 L=0 的时候产生负数下标。
初始值 f[0] = f[1] = 0。
答案为 f[n+1]。
代码 https://www.luogu.com.cn/paste/qmvop45k

# P2627 [USACO11OPEN] Mowing the Lawn G

## 题目描述

在一年前赢得了小镇的最佳草坪比赛后，Farmer John 变得很懒，再也没有修剪过草坪。现在，新一轮的最佳草坪比赛又开始了，Farmer John 希望能够再次夺冠。

然而，Farmer John 的草坪非常脏乱，因此，Farmer John 只能够让他的奶牛来完成这项工作。Farmer John 有 $N$（$1\le N\le 10^5$）只排成一排的奶牛，编号为 $1\ldots N$。每只奶牛的效率是不同的，奶牛 $i$ 的效率为 $E_i$（$0\le E_i\le 10^9$）。

靠近的奶牛们很熟悉，因此，如果 Farmer John安排超过 $K$ 只连续的奶牛，那么，这些奶牛就会罢工去开派对 :)。因此，现在 Farmer John 需要你的帮助，计算 FJ 可以得到的最大效率，并且该方案中没有连续的超过 $K$ 只奶牛。

## 输入格式

第一行：空格隔开的两个整数 $N$ 和 $K$。

第二到 $N+1$ 行：第 $i+1$ 行有一个整数 $E_i$。

## 输出格式

第一行：一个值，表示 Farmer John 可以得到的最大的效率值。

## 输入输出样例 #1

### 输入 #1

```
5 2
1
2
3
4
5
```

### 输出 #1

```
12
```
 */
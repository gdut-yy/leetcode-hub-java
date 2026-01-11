import java.io.PrintWriter;
import java.util.Scanner;

public class P3903 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[][] f = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();

            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    f[i][0] = Math.max(f[i][0], f[j][1] + 1);
                } else if (a[j] < a[i]) {
                    f[i][1] = Math.max(f[i][1], f[j][0]);
                }
            }

            f[i][1]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }

        out.print(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P3903

灵茶の试炼 2025-12-15

输入 n(1≤n≤1e3) 和长为 n 的数组 a(1≤a[i]≤1e9)。
从 a 中选一个震荡子序列 b，满足 b[0] > b[1] < b[2] > b[3] < ...
输出 b 的最大长度。
注：子序列不一定连续。

类似 LIS 的 O(n^2) 做法。
定义 f[i][0] 表示以 a[i] 结尾的长为偶数的震荡子序列的最长长度。
定义 f[i][1] 表示以 a[i] 结尾的长为奇数的震荡子序列的最长长度。
如果 a[j] > a[i]，那么 f[i][0] = f[j][1] + 1。
如果 a[j] < a[i]，那么 f[i][1] = f[j][0] + 1。
初始值 f[i][0] = 0，f[i][1] = 1。
答案为所有 f[i][j] 的最大值。
代码 https://paste.ubuntu.com/p/twqszd26pZ/
======
# P3903 导弹拦截III

## 题目描述

很多年以前，A 国发明了一种导弹系统用来拦截敌对势力发射的导弹。

这个系统可以发射一颗导弹拦截由近到远、高度不增加的多个导弹。

但是现在，科学家们发现这个防御系统还不够强大，所以他们发明了另外一套导弹系统。

这个新系统可以发射一颗导弹由近到远的拦截更多的导弹。

当这个系统启动，首先选择一颗敌人的导弹进行拦截，然后拦截一颗更远的高度更低的导弹进行拦截，然后拦截比第二颗更远的但高度更高的导弹……以此类推，拦截的第奇数颗导弹比前一颗导弹更远、更高，拦截的第偶数颗导弹比前一个更远、更低。

现在，给你一个从近到远的导弹高度列表，计算新系统发射一颗导弹可以拦截的最多的导弹数目。

## 输入格式

第一行是一个整数 $n$，表示敌人发射的导弹数目。接下来的一行有 $n$ 个整数，表示由近到远的。

## 输出格式

仅一个整数，表示拦截的最多导弹的数量。

## 输入输出样例 #1

### 输入 #1

```
4
5 3 2 4
```

### 输出 #1

```
3
```

## 说明/提示

$1\leq n\leq 10^3$，$1\leq $ 导弹高度 $\leq 10^9$。
 */
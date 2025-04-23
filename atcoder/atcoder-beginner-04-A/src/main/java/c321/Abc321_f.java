package c321;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc321_f {
    static Scanner scanner = new Scanner(System.in);
    static int q, k;

    public static void main(String[] args) {
        q = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = 998244353;

    private static String solve() {
        long[] f = new long[k + 1];
        f[0] = 1;

        long[] ans = new long[q];
        for (int qi = 0; qi < q; qi++) {
            String op = scanner.next();
            int v = scanner.nextInt();
            if ("+".equals(op)) {
                for (int i = k; i >= v; i--) {
                    f[i] = (f[i] + f[i - v]) % MOD;
                }
            } else {
                for (int i = v; i <= k; i++) {
                    f[i] = (f[i] - f[i - v] + MOD) % MOD;
                }
            }
            ans[qi] = f[k];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
F - #(subset sum = K) with Add and Erase
https://atcoder.jp/contests/abc321/tasks/abc321_f

灵茶の试炼 2025-02-27
题目大意：
输入 q(1≤n≤5000) 和 k(1≤k≤5000)。
一开始有一个空箱子。输入 q 个操作：
"+ v"：把一个写有数字 v 的小球放入箱子。
"- v"：从箱子中移除一个写有数字 v 的小球，保证箱子中有这样的小球。
v 的范围是 [1,5000]。
每次操作后，输出有多少种方案，从箱子中选取一些球，元素和恰好等于 k。答案模 998244353。
注意球是有区分的。

小球是有区别的，将这些小球视作一些物品，用 0-1 背包计算恰好装满容量为 k 的背包的方案数。
添加数字的时候，按照 0-1 背包的方法转移，也就是 f[i] += f[i-v]，倒序循环。
删除数字的时候，撤销掉之前的转移，也就是 f[i] -= f[i-v]，正序循环。
注意取模。
注意保证取模之后的结果非负。
代码 https://atcoder.jp/contests/abc321/submissions/62943296
问：为什么撤销是对的？
答：可以这样理解，物品顺序不影响 f 的计算，那么当我取出数字 v 的时候，我可以把 "+ v" 调换到取出之前，也就是刚加进去就拿出来，这样之前写的 f[i] += f[i-v] 就可以立刻用 f[i] -= f[i-v] 撤销掉，f 现在是没有 x 的方案数。
======

Input 1
15 10
+ 5
+ 2
+ 3
- 2
+ 5
+ 10
- 3
+ 1
+ 3
+ 3
- 5
+ 1
+ 7
+ 4
- 3
Output 1
0
0
1
0
1
2
2
2
2
2
1
3
5
8
5
 */

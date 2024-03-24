package p1042;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1042C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> neg = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        int mxI = 0;
        int mxV = (int) -2e9;
        for (int i = 1; i <= n; i++) {
            if (a[i] < 0) {
                if (a[i] > mxV) {
                    mxV = a[i];
                    mxI = i;
                }
                neg.add(i);
            } else if (a[i] == 0) {
                zero.add(i);
            } else {
                pos.add(i);
            }
        }

        if ((neg.size() & 1) > 0) {
            zero.add(mxI);
            for (int i = 0; i < neg.size(); i++) {
                if (neg.get(i) == mxI) {
                    pos.addAll(neg.subList(0, i));
                    pos.addAll(neg.subList(i + 1, neg.size()));
                }
            }
        } else {
            pos.addAll(neg);
        }

        List<String> ans = new ArrayList<>();
        if (zero.size() > 1) {
            for (int i = 1; i < zero.size(); i++) {
                ans.add(1 + " " + zero.get(i) + " " + zero.get(0));
            }
        }
        if (!pos.isEmpty()) {
            if (!zero.isEmpty()) {
                ans.add(2 + " " + zero.get(0));
            }
            for (int i = 1; i < pos.size(); i++) {
                ans.add(1 + " " + pos.get(i) + " " + pos.get(0));
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
C. Array Product
https://codeforces.com/contest/1042/problem/C

灵茶の试炼 2022-06-29
题目大意：
【易错题】
输入 n(2<=n<=2e5) 和一个长为 n 的数组 a(-1e9<=a[i]<=1e9)。
你有两个操作：
1. 选择两个未被删除的数字 a[i] 和 a[j]，把 a[i] 删掉，把 a[j] 变为 a[i]*a[j]。
2. 删除一个未被删除的数字 a[i]，该操作至多只能执行一次。
你需要操作 n-1 次，使得最后剩下的那个数字最大。
你不需要输出这个最大数，而是输出你的操作方案（多种方案输出任意一种）。
输出的格式：
操作 1 应输出 "1 i j"
操作 2 应输出 "2 i"
下标从 1 开始。

constructive algorithms
rating 1700
https://codeforces.com/contest/1042/submission/162207883
把 0 看成是垃圾桶，所有 0 扔到同一个 0 里面，然后把 0 删除，这样可以去掉所有的 0。
如果负数有奇数个，我们需要选一个绝对值最小的负数，把它也扔到 0 里面。
然后把剩下的负数和正数乘起来就好了。
具体实现见上面代码。
======

input
5
5 -2 0 1 -3
output
2 3
1 1 2
1 2 4
1 4 5

input
5
5 2 0 4 0
output
1 3 5
2 5
1 1 2
1 2 4

input
2
2 -1
output
2 2

input
4
0 -10 0 0
output
1 1 2
1 2 3
1 3 4

input
4
0 0 0 0
output
1 1 2
1 2 3
1 3 4
 */
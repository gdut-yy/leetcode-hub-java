package p1792;

import java.util.Scanner;

public class CF1792C {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[p[i]] = i;
        }
        int x = n / 2;
        while (x > 0 && pos[x] < pos[x + 1] && pos[n - x] < pos[n - x + 1]) {
            x--;
        }
        return String.valueOf(x);
    }
}
/*
C. Min Max Sort
https://codeforces.com/contest/1792/problem/C

灵茶の试炼 2023-10-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 1~n 的排列 p。
每次操作，你可以从 p 中拿出两个数，把较小值放在 p 的开头（最左边），较大值放在 p 的末尾（最右边）。
要使 p 单调递增，至少要操作多少次？

rating 1500
提示 1：什么样的情况只需要操作一次？或者说，最后一次操作是什么？
去掉两个数之后，剩下的数是单调递增的。
但如果只有 3~n 是递增的，我们是不能只去掉 1 和 2 的，因为要把 2 放在最右边。
所以只有一种情况，就是去掉 1 和 n 之后，剩下的 2~n-1 是单调递增的。这种情况只需要操作一次。
提示 2：什么样的情况只需要操作两次？
同理，去掉 1,2,n-1,n 之后，如果剩下的 3~n-2 是单调递增的，就只需要操作两次。
提示 3：从 x=n/2 开始枚举，判断 x 到 n-x+1 是不是单调递增的，如果是，就把 x 减一，继续判断。
每次判断只需要比较 pos[x] < pos[x+1] 且 pos[n-x] < pos[n-x+1]，其中 pos[x] 表示元素 x 所在的下标。
最后答案就是 x。
https://codeforces.com/contest/1792/submission/227987559
======

input
4
5
1 5 4 2 3
3
1 2 3
4
2 1 4 3
6
5 2 4 1 6 3
output
2
0
1
3
 */

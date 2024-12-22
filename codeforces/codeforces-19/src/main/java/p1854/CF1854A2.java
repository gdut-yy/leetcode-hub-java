package p1854;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1854A2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static int neg, pos, maxI, minI;
    static List<int[]> ans;

    private static String solve() {
        neg = 0;
        pos = 0;
        maxI = 0;
        minI = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                neg++;
            } else if (a[i] > 0) {
                pos++;
            }
            if (a[i] > a[maxI]) {
                maxI = i;
            } else if (a[i] < a[minI]) {
                minI = i;
            }
        }

        ans = new ArrayList<>();
        if (a[maxI] >= -a[minI]) {
            if (neg <= 12) {
                makePos();
            } else {
                for (int i = 0; i < 5; i++) {
                    ans.add(new int[]{minI, minI});
                }
                makeNeg();
            }
        } else {
            if (pos <= 12) {
                makeNeg();
            } else {
                for (int i = 0; i < 5; i++) {
                    ans.add(new int[]{maxI, maxI});
                }
                makePos();
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(o -> (o[0] + 1) + " " + (o[1] + 1)).collect(Collectors.joining(System.lineSeparator()));
    }

    static void makePos() {
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                ans.add(new int[]{i, maxI});
            }
        }
        for (int i = 1; i < n; i++) {
            ans.add(new int[]{i, i - 1});
        }
    }

    static void makeNeg() {
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                ans.add(new int[]{i, minI});
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            ans.add(new int[]{i, i + 1});
        }
    }
}
/*
B. Producing Snow
https://codeforces.com/contest/1854/problem/A2

灵茶の试炼 2023-12-28
题目大意：
本题分为简单和困难两个版本。
在简单版本中，K=50。
在困难版本中，K=31。
输入 T(≤500) 表示 T 组数据。
每组数据输入 n(1≤n≤20) 和长为 n 的数组 a(-20≤a[i]≤20)。
你可以执行至多 K 次操作，每次操作：
选择下标 i 和 j，执行 a[i] += a[j]。注意 i 可以等于 j。
目标是使数组 a 非递减，即 a[i] <= a[i+1]。
输出操作次数，以及每次操作的 i 和 j，下标从 1 开始。
注意：你无需最小化操作次数，只要操作次数 <= K 即可。

rating 2500
提示 1
如果没有负数，可以通过 a[2]+=a[1], a[3]+=a[2], ..., a[n]+=a[n-1] 使数组非递减。
如果没有正数，可以通过 a[n-1]+=a[n], a[n-2]+=a[n-1], ..., a[1]+=a[2] 使数组非递减。
提示 2
不失一般性，假设 max(a) >= -min(a)。
如果有负数，我们可以把负数都加上 max(a) 变成非负数，然后就可以按照提示 1 操作了。
这种做法可以通过简单版本。
提示 3
仍然假设 max(a) >= -min(a)。
由于提示 1 的操作至多执行 n-1<=19 次，这意味着我们只剩下 31-19=12 次操作，能否全变成非负数或者非正数呢？
大方向是：如果正数多，那么就把负数都变成非负数；如果负数多，那么就把正数都变成非正数。
具体如何判断呢？
提示 4
设有 x 个负数。
如果 x <= 12，那么把负数全变成非负数即可。
否则 x >= 13，只能把正数变成非正数。
首先得弄出个很小的负数，使得 -min(a) >= max(a)。由于 2^5 = 32 > 20，对同一个负数至多翻倍 5 次即可做到。
此时还剩下 12-5=7 次操作，刚好 n-x <= 20-13 = 7，我们可以把所有正数都变成非正数。
https://codeforces.com/contest/1854/submission/239097233
======

Input
10
2
2 1
4
1 2 -10 3
5
2 1 1 1 1
8
0 0 0 0 0 0 0 0
5
1 2 -4 3 -10
10
11 12 13 14 15 -15 -16 -17 -18 -19
7
1 9 3 -4 -3 -2 -1
3
10 9 8
20
1 -14 2 -10 6 -5 10 -13 10 7 -14 19 -5 19 1 18 -16 -7 12 8
20
-15 -17 -13 8 14 -13 10 -4 11 -4 -16 -6 15 -4 -2 7 -9 5 -5 17

Output
1
2 1
3
4 4
4 4
3 4
4
2 1
3 1
4 1
5 1
0
7
3 4
3 4
5 4
5 4
5 4
5 4
5 4
15
6 1
6 1
6 1
7 2
7 2
7 2
8 3
8 3
8 3
9 4
9 4
9 4
10 5
10 5
10 5
8
3 4
3 4
2 4
2 4
2 4
2 4
1 4
1 4
3
2 1
3 1
3 1
31
14 1
18 7
13 11
15 11
6 4
5 17
19 6
19 12
10 5
11 12
1 17
15 19
16 10
14 2
16 11
20 7
7 6
9 5
3 6
6 14
17 18
18 14
12 3
17 16
8 18
13 16
9 8
14 8
16 2
11 8
12 7
31
5 12
19 13
9 1
5 17
18 19
6 16
15 8
6 9
15 14
7 10
19 7
17 20
14 4
15 20
4 3
1 8
16 12
16 15
5 6
12 10
11 15
20 3
20 19
13 14
11 14
18 10
7 3
12 17
4 7
13 2
11 13
 */

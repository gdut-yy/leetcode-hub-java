package c312;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Abc312_f {
    static int n, m;
    static List<Integer> a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new ArrayList<>();
        b = new ArrayList<>();
        c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            if (t == 0) a.add(x);
            else if (t == 1) b.add(x);
            else c.add(x);
        }
        System.out.println(solve());
    }

    private static String solve() {
        a.sort(Comparator.reverseOrder());
        b.sort(null);
        c.sort(null);

        long[] x = new long[n + 1], y = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (i < a.size()) x[i + 1] = x[i] + a.get(i);
            else x[i + 1] = x[i];
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (b.isEmpty()) y[i + 1] = y[i];
            else if (r == 0) {
                if (!c.isEmpty()) {
                    int lastIdx = c.size() - 1;
                    r += c.get(lastIdx);
                    c.remove(lastIdx);
                }
                y[i + 1] = y[i];
            } else {
                r--;
                int lastIdx = b.size() - 1;
                y[i + 1] = y[i] + b.get(lastIdx);
                b.remove(lastIdx);
            }
        }

        long ans = 0;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, x[i] + y[m - i]);
        }
        return String.valueOf(ans);
    }
}
/*
F - Cans and Openers
https://atcoder.jp/contests/abc312/tasks/abc312_f

题目大意：
一共有 N 项。
每一个都是一个拉标签罐，一个普通罐，或一个开罐器。
第 i 项用整数对(ti, xi)表示如下:
- 如果 Ti =0，则第 i 项为拉卡罐;如果你得到了，你的幸福指数是 xi。
- 如果 Ti =1，则第 i 项为普通罐头;如果你得到它，并使用开罐器对它，你得到 Xi 的幸福。
- 如果 Ti =2，第第 i 件物品是开罐器;它最多可用于 Xi 罐。
找出从 N 个项目中获得 M 个项目所获得的最大总幸福度。

https://atcoder.jp/contests/abc312/editorial/6865
如果我们确定拉卡罐的数量，选择快乐度更高的罐显然是最优的。
同样，如果我们固定了正常的罐子的数量，选择快乐度更高的罐子是最优的;至于开罐器，最好选择那些能打开更多罐头的。
通过降序排序并求和，我们可以找到每个人在选择拉杆罐时的最大快乐度。因此，在选择普通易拉罐和开罐器时，只要知道每个人的最大幸福值就足够了。
这里，在最优解中，我们可以假设没有未使用开罐器的常规罐，也没有未使用开罐器的任何罐，因此以下贪婪过程产生最优解:
如果还有一个可用的开罐器，选择一个普通的罐头与最大的幸福。
否则，选择一个能打开最多罐头的开罐器。
通过对普通易拉罐的幸福度和开罐器的使用次数进行排序，贪心算法总共运行了 O(N)个时间，问题就解决了。
======

Input 1
8 4
0 6
0 6
1 3
1 5
1 15
2 1
2 10
2 100
Output 1
27

Input 2
5 5
1 5
1 5
1 5
1 5
1 5
Output 2
0

Input 3
12 6
2 2
0 1
0 9
1 3
1 5
1 3
0 4
2 1
1 8
2 1
0 1
0 4
Output 3
30
 */
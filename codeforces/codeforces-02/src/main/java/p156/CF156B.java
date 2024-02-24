package p156;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF156B {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        for (int v : a) {
            if (v < 0) {
                cnt[-v]--;
                m--;
            } else {
                cnt[v]++;
            }
        }
        int cm = 0;
        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] == m) {
                cm++;
            }
        }

        List<String> ans = new ArrayList<>();
        for (int v : a) {
            if (v > 0) {
                if (cnt[v] != m) ans.add("Lie");
                else if (cm == 1) ans.add("Truth");
                else ans.add("Not defined");
            } else {
                if (cnt[-v] != m) ans.add("Truth");
                else if (cm == 1) ans.add("Lie");
                else ans.add("Not defined");
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
B. Suspects
https://codeforces.com/contest/156/problem/B

灵茶の试炼 2022-06-01
题目大意：
有 n(<=1e5) 个人，编号从 1 到 n。其中恰好有一个人是罪犯。
同时还有 n 条陈述，每条陈述要么是 +x，表示 x 是罪犯；要么是 -x，表示 x 不是罪犯。(1<=x<=n)
已知这 n 条陈述中恰好有 m(<=n) 条是实话，有 n-m 条是假话。
对于每条陈述，如果这条陈述一定是实话，输出 "Truth"；如果一定是假话，输出 "Lie"；如果不确定是真是假，输出 "Not defined"。

rating 1600
https://codeforces.com/problemset/submission/156/159122474
枚举。
假设 i 是罪犯，如果 “i 是罪犯” 的陈述数和 “j 不是罪犯”(j≠i) 的陈述数之和等于 m，则 i 可能是罪犯，否则 i 一定不是罪犯。
然后遍历所有陈述，按照上面统计的结果来输出对应的字符串。
======

input
1 1
+1
output
Truth

input
3 2
-1
-2
-3
output
Not defined
Not defined
Not defined

input
4 1
+2
-3
+4
-1
output
Lie
Not defined
Lie
Not defined
 */
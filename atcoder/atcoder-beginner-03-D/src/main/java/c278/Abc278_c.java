package c278;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Abc278_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        while (q-- > 0) {
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (t == 1) {
                adj.computeIfAbsent(a, key -> new HashSet<>()).add(b);
            } else if (t == 2) {
                adj.computeIfAbsent(a, key -> new HashSet<>()).remove(b);
            } else {
                boolean bool1 = adj.getOrDefault(a, new HashSet<>()).contains(b);
                boolean bool2 = adj.getOrDefault(b, new HashSet<>()).contains(a);
                System.out.println((bool1 && bool2) ? "Yes" : "No");
            }
        }
    }
}
/*
C - FF
https://atcoder.jp/contests/abc278/tasks/abc278_c

题目大意：
Takahashi 经营的 SNS“Twidai”从用户 1 到用户 N 共有 N 个用户。在 Twidai 中，用户可以关注或取消关注其他用户。
推贷上线以来，共进行了 Q 次操作。第 i 次(1≤i≤Q)运算用三个整数 t1、a1、b1 表示，其含义如下:
- 如果 Ti = 1，表示用户 A i 跟随用户 B i。如果执行此操作时，用户 A i 已经跟随用户 B i，则不做任何更改。
- 如果 Ti = 2，表示用户 A i 取消关注用户 B i。如果执行此操作时，用户 A i 没有跟随用户 B i，则不做任何更改。
- 如果 Ti = 3，这意味着您被要求确定用户 A i 和 B i 是否相互关注。如果用户 A i 跟随用户 B i，用户 B i 跟随用户 A i，则打印“是”，否则打印“否”。
当该服务启动时，没有用户关注其他用户。
打印所有运算的正确答案，使 Ti = 3 按 i 的升序排列。

建图 模拟。
======

Input 1
3 9
1 1 2
3 1 2
1 2 1
3 1 2
1 2 3
1 3 2
3 1 3
2 1 2
3 1 2
Output 1
No
Yes
No
No

Input 2
2 8
1 1 2
1 2 1
3 1 2
1 1 2
1 1 2
1 1 2
2 1 2
3 1 2
Output 2
Yes
No

Input 3
10 30
3 1 6
3 5 4
1 6 1
3 1 7
3 8 4
1 1 6
2 4 3
1 6 5
1 5 6
1 1 8
1 8 1
2 3 10
1 7 6
3 5 6
1 6 7
3 6 7
1 9 5
3 8 6
3 3 8
2 6 9
1 7 1
3 10 8
2 9 2
1 10 9
2 6 10
2 6 8
3 1 6
3 1 8
2 8 5
1 9 10
Output 3
No
No
No
No
Yes
Yes
No
No
No
Yes
Yes
 */
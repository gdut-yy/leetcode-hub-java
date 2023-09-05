package p1862;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1862D {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long left = 3;
        long right = (long) 2e9;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        long d = left - 1;
        long tot = d * (d - 1) / 2;
        long ans = n - tot + d;
        return String.valueOf(ans);
    }

    private static boolean checkMid(long mid) {
        long tot = mid * (mid - 1) / 2;
        return tot <= n;
    }
}
/*
D. Ice Cream Balls
https://codeforces.com/contest/1862/problem/D

题目大意：
Tema 决定提高他的冰淇淋制作技能。他已经学会了如何用两个球制作蛋筒冰淇淋。
在对冰淇淋着迷之前，Tema 对数学很感兴趣。因此，他很好奇，要制作 n 种不同的冰淇淋，他需要最小数量的球。
有很多可能的冰淇淋口味:1、2、3、... .Tema 可以做出任何口味的双球冰淇淋(可能是一样的)。
如果两种冰淇淋的丸子口味不同，那么它们就被认为是不同的。例如，{1,2}={2,1}，但{1,1}≠{1,2}。
例如，有以下冰淇淋球:{1,1,2}，Tema 只能做出两种冰淇淋:{1,1}和{1,2}。
注意，Tema 不需要同时制作所有的冰淇淋甜筒。这意味着他独立制作冰淇淋甜筒。同样，为了对某些 x 做出如下锥形{x,x}， Tema 需要至少 2 个类型为 x 的球。
帮助 Tema 回答这个问题。可以证明，答案总是存在的。
---
在第一个示例中，有以下类型的球就足够了:{1,1}。注意，这个集合{1}是不够的，因为我们需要至少 2 个类型为 1 的球来制作这样的圆锥体{1,1}。
在第二个样本中，不可能用 2 个球制作，但可以用这些球:{1,2,3}。
在第三个样本中，{1,2,3,4}是最优答案，因此我们可以得到以下冰淇淋甜筒:{1,2}，{1,3}，{1,4}，{2,3}，{2,4}，{3,4}。
---
请注意，Tema 想要确定最小的一组球的大小，这样从理论上讲，他可以精确地组装 n 个冰淇淋。他实际上并没有组装它们(也就是说，它们没有被用完);他评估了用这一套冰淇淋可以做出多少种不同的冰淇淋。他的目标是找到这样一个最小尺寸，他可以组装的不同冰淇淋的数量正好等于 n。

不是 C(n,m) 吗，C(19, 2) = 171
题目描述问题，后面补充强调了是 exactly n（恰好为 n）
======

input
5
1
3
6
179
1000000000000000000
output
2
3
4
27
2648956421
 */

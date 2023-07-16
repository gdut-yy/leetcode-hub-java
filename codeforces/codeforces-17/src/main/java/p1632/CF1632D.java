package p1632;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1632D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[n];

        int res = 0;
        // v,l,r
        List<int[]> set = new ArrayList<>();
//        label:
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (v == 1) {
                set.clear();
                res++;
                ans[i] = res;
                continue;
            }

            boolean flag = false;
            for (int[] p : set) {
                int g = getGCD(p[0], v);
                int l = i + 1 - g;
                if (p[1] <= l && l <= p[2]) {
                    set.clear();
                    res++;
                    ans[i] = res;
                    flag = true;
                    break;
//                    continue label;
                }
                p[0] = g;
            }
            if (flag) continue;

            set.add(new int[]{v, i, i});
            int k = 0;
            for (int j = 1; j < set.size(); j++) {
                int[] q = set.get(j);
                if (set.get(k)[0] == q[0]) {
                    set.get(k)[2] = q[2];
                } else {
                    k++;
                    set.set(k, q);
                }
            }
            // b = b[:k+1]
            set.subList(k + 1, set.size()).clear();

            ans[i] = res;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. New Year Concert
https://codeforces.com/contest/1632/problem/D

题目大意：
新年即将来临，这意味着在 179 学校，音乐会的准备工作正在如火如荼地进行。
学校有 n 个班，编号从 1 到 n，第 i 个班准备了一个长度为 ai 分钟的场景。
作为举办音乐会的主要负责人，Idnar 知道，如果一场音乐会有 k 个场景，长度为 b1,b2,...,bk 分钟，那么如果存在两个整数 l 和 r，使 1≤l≤r≤k，且 gcd(bl,bl+1,...,br−1,br)=r−l+1，其中 gcd(bl,bl+1,...,br−1,br) 等于数字 bl,bl+1,...,br−1,br 的最大公约数(gcd)，观众就会感到无聊。
为了避免观众感到无聊，Idnar 可以要求第 t 类(1≤t≤k) 的任意次数(可能是 0 次)制作一个新的场景，长度为 d 分钟，其中 d 可以是任何正整数。因此，经过这个运算，b[t] 等于 d。注意，t 和 d 对于每个操作都是不同的。
对于场景长度为 b1,b2,...,bk 的序列，设 f(b)为 Idnar 为了避免让观众感到厌烦而要求改变场景的最小课时数。
Idnar 还没有决定音乐会允许哪些场景，所以他想知道 a 的每个非空前缀 f 的值。换句话说，Idnar 想知道 f(a1),f(a1,a2),...,f(a1,a2,...,an))。

rating 2000
子数组 LCM/GCD/OR/AND 模板
https://codeforces.com/contest/1632/submission/144604808
======

input
1
1
output
1

input
3
1 4 2
output
1 1 2

input
7
2 12 4 8 18 3 6
output
0 1 1 1 2 2 2
 */

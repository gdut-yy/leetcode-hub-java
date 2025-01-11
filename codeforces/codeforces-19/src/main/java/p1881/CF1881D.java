package p1881;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1881D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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

    private static String solve() {
        // 质因子 频次
        Map<Integer, Integer> pfCnt = new HashMap<>();
        for (int v : a) {
            // n * sqrt(1e6)
            for (int i = 2; i * i <= v; i++) {
                if (v % i == 0) {
                    while (v % i == 0) {
                        v /= i;
                        pfCnt.put(i, pfCnt.getOrDefault(i, 0) + 1);
                    }
                }
            }
            if (v != 1) {
                pfCnt.put(v, pfCnt.getOrDefault(v, 0) + 1);
            }
        }
        for (Integer c : pfCnt.values()) {
            if (c % n != 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
D. Divide and Equalize
https://codeforces.com/contest/1881/problem/D

灵茶の试炼 2024-11-11
题目大意：
给定一个由 n 个正整数组成的数组。可执行如下操作:
1、选取一对元素 ai 和 aj(1≤i,j≤n 且 i≠j);
2、选择整数 ai 的一个除数，即整数 x，使得 aimodx=0;
3、将 ai 替换为 ai/x，将 aj 替换为 aj·x。
确定是否有可能通过应用操作一定次数(可能为零)使数组中的所有元素相同。
例如，让我们考虑包含 5 个元素的数组 a =[100,2,50,10,1]。对其执行两项操作:
1、选择 a3=50 a2=2 x=5。a3 替换为 a3x=505=10, a2 替换为 a2·x=2·5=10。结果数组是 a = [100,10,10,10,1];
2、选择 a1=100 a5=1 x=10。将 a1 替换为 a1x=10010=10, a5 替换为 a5·x=1⋅10=10。得到的数组是 a =[10,10,10,10,10]。
执行这些操作后，数组 a 中的所有元素都等于 10。

每种质因子可以均分 n 份
======

input
7
5
100 2 50 10 1
3
1 1 1
4
8 2 4 2
4
30 50 27 20
2
75 40
2
4 4
3
2 3 1
output
YES
YES
NO
YES
NO
YES
NO
 */

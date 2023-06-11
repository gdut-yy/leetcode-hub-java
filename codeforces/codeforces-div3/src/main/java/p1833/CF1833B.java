package p1833;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1833B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a, b));
        }
    }

    private static String solve(int n, int k, int[] a, int[] b) {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        Arrays.sort(b);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[ids[i]] = b[i];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Restore the Weather
https://codeforces.com/contest/1833/problem/B

题目大意：
给定一个数组 a，其中包含 Berlandia 过去 n 天的天气预报。即 ai 为第 i 天的估计气温(1≤i≤n)。
你也会得到一个数组 b——每一天实际存在的空气温度。然而，数组 b 中的所有值都是混合的。
确定哪一天是什么温度，如果你知道天气与预报的差异永远不会超过 k 度。换句话说，如果第 i 天的实际空气温度是 c，那么等式|ai−c|≤k 总是成立的。
例如，给定长度为 n=5, k=2 的数组 a =[1,3,5,3,9]，数组 b =[2,5,11,2,4]。然后，为了使 bi 的值对应于第 i 天的气温，我们可以重新排列数组 b 的元素如下:[2,2,5,4,11]。事实上:
- 第 1 天，|a1−b1|=|1−2|=1，满足 1≤2=k;
- 第 2 天，|a2−b2|=|3−2|=1，满足 1≤2=k;
- 第 3 天，|a3−b3|=|5−5|=0，满足 0≤2=k;
- 第 4 天，|a4−b4|=|3−4|=1，满足 1≤2=k;
- 第 5 天，|a5−b5|=|9−11|=2，满足 2≤2=k。
在每个测试用例的单独一行上，精确地输出 n 个数字——按正确顺序输出每一天的空气温度值。
如果有多个答案-输出其中任何一个。

贪心，最小的一定匹配最小的，依次类推。
======

input
3
5 2
1 3 5 3 9
2 5 11 2 4
6 1
-1 3 -2 0 -5 -1
-4 0 -1 4 0 0
3 3
7 7 7
9 4 8
output
2 2 5 4 11
0 4 -1 0 -4 0
8 4 9
 */
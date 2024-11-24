package p988;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF988C {
    static int k, n;
    static int[] a;

    public static void main(String[] args) {
        Map<Long, int[]> mp = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        for (int i = 1; i <= k; i++) {
            n = scanner.nextInt();
            a = new int[n];
            long sum = 0;
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
                sum += a[j];
            }
            for (int j = 0; j < n; j++) {
                int v = a[j];
                int[] p = mp.getOrDefault(sum - v, new int[2]);
                if (p[0] > 0 && p[0] < i) {
                    System.out.println("YES");
                    System.out.println(p[0] + " " + (p[1] + 1));
                    System.out.println(i + " " + (j + 1));
                    return;
                }
                mp.put(sum - v, new int[]{i, j});
            }
        }
        System.out.println("NO");
    }

    private static String solve() {
        return "";
    }
}
/*
C. Equal Sums
https://codeforces.com/contest/988/problem/C

灵茶の试炼 2024-04-15
题目大意：
输入 k(2≤k≤2e5)。
然后输入 k 行，每行输入 n(1≤n<2e5) 和长为 n 的数组，数组元素范围 [-1e4,1e4]。所有 n 之和 ≤2e5。
从这 k 个数组中，选出两个数组 a 和 b，然后从 a b 中各删除恰好一个元素，要求删除后 sum(a) = sum(b)。
空数组的元素和为 0。
如果无法做到，输出 NO。
否则输出 YES。
然后输出数组 a 是输入的第几个数组，以及 a 中删除的元素在 a 的下标（从 1 开始）。
然后输出数组 b 是输入的第几个数组，以及 b 中删除的元素在 b 的下标（从 1 开始）。

rating 1400
对于数组 a，先计算 sum(a)，
然后再次遍历 a，同时用哈希表记录删除 a[i] 后的元素和，及其对应的 pair：{数组 a 是输入的第几个，下标 i}。
遍历 a 的同时，如果在哈希表中遇到同样的元素和，且对应的数组是不同的，则找到了答案。
https://codeforces.com/problemset/submission/988/256124413
======

Input
2
5
2 3 1 3 2
6
1 1 2 2 2 1
Output
YES
2 6
1 2

Input
3
1
5
5
1 1 1 1 1
2
2 3
Output
NO

Input
4
6
2 2 2 2 2 2
5
2 2 2 2 2
3
2 2 2
5
2 2 2 2 2
Output
YES
2 2
4 1
 */

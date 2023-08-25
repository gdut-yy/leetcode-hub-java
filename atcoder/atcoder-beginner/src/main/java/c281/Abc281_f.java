package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc281_f {
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
        Arrays.sort(a);
        long ans = f(a, 29, 0);
        return String.valueOf(ans);
    }

    private static long f(int[] a, int k, int pre) {
        if (k < 0 || a[0] == a[a.length - 1]) {
            return 0;
        }
        int bit = 1 << k;
        if ((a[0] & bit) == (a[a.length - 1] & bit)) {
            return f(a, k - 1, pre | a[0] & bit);
        }
        // i := sort.SearchInts(a, pre|bit)
        int i = searchInts(a, pre | bit);

        long ans1 = f(Arrays.copyOfRange(a, 0, i), k - 1, pre);
        long ans2 = f(Arrays.copyOfRange(a, i, a.length), k - 1, pre | bit);
        return Math.min(ans1, ans2) | bit;
    }

    private static int searchInts(int[] a, int key) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (a[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
F - Xor Minimization
https://atcoder.jp/contests/abc281/tasks/abc281_f

灵茶の试炼 2023-08-10
题目大意：
输入 n(1≤n≤1.5e5) 和长为 n 的数组 a(0≤a[i]<2^30)。
选一个非负整数 x，然后把每个 a[i] 更新成 a[i] XOR x。
输出 max(a) 的最小值。

https://atcoder.jp/contests/abc281/submissions/44402795
处理二进制问题的基本技巧之一是【拆位】。
从高到低枚举比特位。如果在第 k 位上，有些 a[i] 是 0，有些 a[i] 是 1，那么无论 x 的第 k 位是 0 还是 1，max(a) 的第 k 位必定是 1。
分类讨论：
如果 x 第 k 位取 0，那么 a[i] 第 k 位也是 0 的就不用考虑了，只需要考虑 a[i] 第 k 位是 1 的。
如果 x 第 k 位取 1，那么 a[i] 第 k 位也是 1 的就不用考虑了，只需要考虑 a[i] 第 k 位是 0 的。
这启发我们得到如下分治算法：
定义 f(a, k) 表示只考虑 <= k 位的前提下，max(a) 的最小值。
如果 a[i] 的第 k 位都一样，那么 f(a, k) = f(a, k-1)。
如果 a[i] 的第 k 位不都一样，那么 f(a, k) = min(f(b, k-1), f(c, k-1)) | (1 << k)，其中 b 表示第 k 位是 0 的元素组成的数组，c 表示第 k 位是 1 的元素组成的数组。
递归边界：k<0 时，返回 0。
递归入口：f(a, 29)。
代码实现时：
1. 为了快速判断【a[i] 的第 k 位是否都一样】，可以先把 a 排序，再去分治。
2. 为了快速分出数组 b 和数组 c，可以用二分查找 0 和 1 的分界线，为此需要多一个参数 pre 表示 a[i] 二进制的公共前缀，具体见代码。
注：可以不用二分查找，因为写个 for 循环来找分界线也 ok。
======

Input 1
3
12 18 11
Output 1
16

Input 2
10
0 0 0 0 0 0 0 0 0 0
Output 2
0

Input 3
5
324097321 555675086 304655177 991244276 9980291
Output 3
805306368
 */
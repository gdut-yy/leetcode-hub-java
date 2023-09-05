package c178;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc178_f {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        for (int v : a) cnt[v]++;
        for (int v : b) cnt[v]++;
        for (int c : cnt) {
            if (c > n) {
                return "No";
            }
        }
        reverse(b);

        int j = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int w = b[i];
            if (v != w) {
                continue;
            }
            while (b[j] == v || w == a[j]) {
                j++;
            }
            int tmp = b[i];
            b[i] = b[j];
            b[j] = tmp;

            j++;
        }
        return "Yes" + System.lineSeparator()
                + Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    // 由大到小排序
    private static void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
F - Contrast
https://atcoder.jp/contests/abc178/tasks/abc178_f

灵茶の试炼 2022-11-22
题目大意：
输入 n(≤2e5) 和两个长为 n 的非降数组 a b，元素范围在 [1,n]。
如果可以重排 b，使得 a[i] != b[i] 对每个 i 都成立，则输出 Yes 和重排后的 b，否则输出 No。

https://atcoder.jp/contests/abc178/submissions/36717693
如果 a+b 的众数出现次数 > n，根据鸽巢原理，必然会有相同的，输出 No。
否则答案一定存在，构造方法如下：
翻转 b，那么只可能存在中间一段是相同的，比如现在 a[i] = b[i] 了，那么从前面或者后面找 b[j] 和 b[i] 交换，如果交换后 a[i] != b[i] 且 a[j] != b[j]（不能影响原来的），那么就可以换。
======

Input 1
6
1 1 1 2 2 3
1 1 1 2 2 3
Output 1
Yes
2 2 3 1 1 1

Input 2
3
1 1 2
1 1 3
Output 2
No

Input 3
4
1 1 2 3
1 2 3 3
Output 3
Yes
3 3 1 2
 */
package c136;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc136_b {
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
        int[] cnt = new int[5005];
        boolean dup = false;
        int inv = 0;
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
            if (cnt[a[i]] > 1) {
                dup = true;
            }
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    inv ^= 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            cnt[b[i]]--;
            for (int j = 0; j < i; j++) {
                if (b[j] > b[i]) {
                    inv ^= 1;
                }
            }
        }
        if (!dup && inv > 0) {
            return "No";
        }
        for (int c : cnt) {
            if (c != 0) {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
B - Triple Shift
https://atcoder.jp/contests/arc136/tasks/arc136_b

灵茶の试炼 2022-11-30
题目大意：
输入 n(3≤n≤5000) 和两个长为 n 的数组 a b，元素范围在 [1,5000]。
你可以对数组 a 执行如下操作任意多次：
选择三个相邻的数 a[i] a[i+1] a[i+2]，设这三个数为 x y z，更新 a[i]=z a[i+1]=x a[i+2]=y。
如果可以把 a 变成 b，输出 Yes，否则输出 No。

https://atcoder.jp/contests/arc136/submissions/36888789
首先两个数组元素必须一样，即 Counter(a) == Counter(b)。
先考虑没有重复元素的情况。
由于操作是可逆的，尝试把 a 和 b 都变成一个有序数组。
通过操作，可以把前 n-2 小的元素都移到数组左边，也就是最大的两个数移到数组末尾。
由于最后两个数无法交换，所以如果不同，则输出 No。
如果数组中有重复元素，那么可以把其中的两个重复元素移到数组末尾。
因此只要有重复的，就输出 Yes。
代码实现时，对于无重复元素的情况，可以用 a 和 b 的逆序对的奇偶性是否相同来简化判定。
如果相同则输出 Yes，否则输出 No。
这是因为操作不会改变逆序对的奇偶性。
======

Input 1
4
3 1 4 5
4 1 5 3
Output 1
Yes

Input 2
3
1 2 2
2 1 2
Output 2
Yes

Input 3
3
1 2 3
2 3 4
Output 3
No
 */
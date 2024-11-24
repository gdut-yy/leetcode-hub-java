package p166;

import java.util.Arrays;
import java.util.Scanner;

public class CF166C {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        int i = searchInts(a, x);
        int j = searchInts(a, x + 1) - 1;
        int ans = 0;
        if (i == n || a[i] != x) {
            ans = 1;
            j = i;
            n++;
        }
        int m = (n - 1) / 2;
        if (i > m) {
            ans += i * 2 - n + 1;
        } else if (j < m) {
            ans += n - j * 2 - 2;
        }
        return String.valueOf(ans);
    }

    static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
C. Median
https://codeforces.com/contest/166/problem/C

灵茶の试炼 2024-03-26
题目大意：
输入 n(1≤n≤500) x(1≤x≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e5)。
向 a 中添加尽量少的数，使得 a 的中位数恰好等于 x。
输出添加的元素个数。
注：如果 n 是偶数，中位数取正中间左边那个。例如 a=[1,3,5,7] 的中位数是 3。
进阶：你能做到（预处理后）对于任意 x，都只用 O(log n) 的时间回答吗？

rating 1500
本题只有一个询问 x，如果改成多个询问（有多个不同的 x），对于每个询问，我们可以做到 O(log n) 的时间回答。
把 a 从小到大排序。
首先，如果 x 不在 a 中，我们得先插入一个 x。
设 i 和 j 分别是最左和最右 x 的下标（下标从 0 开始），这可以二分得到。
设中位数下标 m = (n-1)/2。
如果 i > m，说明 x 太大了，我们可以在 a 末尾添加 2*i-n+1 个数，使得 x 落在下标 m 上。
如果 j < m，说明 x 太小了，同样地，我们可以在 a 开头添加 n-2*j-2 个数，使得 x 落在下标 m 上。
其它情况无需添加。
https://codeforces.com/contest/166/submission/253010937
也可以计算最终的数组长度，减去 n 得到要添加的元素个数，代码见右。
```py
n, x = map(int, input().split(" "))
nums = list(map(int, input().split(" ")))

nums.sort()

l = bisect.bisect_left(nums, x)
r = n - bisect.bisect_right(nums, x)

final_len = max(n, r * 2, l * 2 + 1)
if x not in nums:
    final_len = max(final_len, n + 1)
print(final_len - n)
```
======

Input
3 10
10 20 30
Output
1

Input
3 4
1 2 3
Output
4
 */

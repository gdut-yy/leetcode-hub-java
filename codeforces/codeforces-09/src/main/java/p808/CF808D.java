package p808;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF808D {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + a[i];
        }
        if ((ps[n] & 1) > 0) {
            return "NO";
        }

        Set<Long> set = new HashSet<>();
        set.add(0L);
        long half = ps[n] / 2;
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
            if (set.contains(ps[i + 1] - half)) {
                return "YES";
            }
        }

        set.clear();
        set.add(0L);
        for (int i = n - 1; i >= 0; i--) {
            set.add(a[i]);
            if (set.contains(half - ps[i])) {
                return "YES";
            }
        }

        return "NO";
    }
}
/*
D. Array Division
https://codeforces.com/contest/808/problem/D

灵茶の试炼 2022-08-04
题目大意：
输入 n(≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以选择一个 a[i]，将其移除并插入到 a 的任意位置。
你能否在执行至多一次上述操作的限制下，将 a 划分成左右两部分，且这两部分的元素和相等？
能则输出 YES，不能则输出 NO。

rating 1900
https://codeforces.com/contest/808/submission/166868234
Python 写法见右 @七水
首先，如果 tot = sum(a) 是奇数则输出 NO，如果 a 存在一个前缀和等于 tot/2 则输出 YES。
然后用前缀和 + 哈希表来解决。
同时遍历 a[i] 和 a 的前缀和 s[i]，把 a[i] 放到哈希表中，如果 s[i]-tot/2 在哈希表中，说明可以把哈希表中这个元素移到右半部分，使得左右两部分的元素和均为 tot/2，输出 YES。
然后用同样的方法倒着遍历一次，看能否把一个元素从右半部分移到左半部分，使得左右两部分的元素和均为 tot/2。
如果都不行则输出 NO。
---
from typing import List
def solve(n: int, a: List[int]) -> None:
    s = sum(a)
    if s & 1 or n == 1:
        print('NO')
        return
    half = s // 2
    def judge(a: List[int]) -> bool:
        pre = {0}
        p = 0
        for i in a:
            pre.add(i)
            p += i
            if (p - half) in pre:
                return True
        return False
    print('YES' if judge(a) or judge(a[::-1]) else 'NO')

if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
    solve(n, a)
======

input
3
1 3 2
output
YES

input
5
1 2 3 4 5
output
NO

input
5
2 2 3 4 5
output
YES
 */

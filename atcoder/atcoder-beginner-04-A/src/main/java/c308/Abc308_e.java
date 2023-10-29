package c308;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc308_e {
    static int n;
    static int[] a;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    // 1<<v|1<<j|1<<k
    // 0,1,2 = mex[7] = 3

    // 0,0,1(0,1,1) = mex[3] = 2
    // 0,0,2(0,2,2) = mex[5] = 1
    // 1,1,2(1,2,2) = mex[6] = 0

    // 0,0,0 = mex[1] = 1
    // 1,1,1 = mex[2] = 0
    // 2,2,2 = mex[4] = 0
    static int[] mex = {0, 1, 0, 2, 0, 1, 0, 3};

    private static String solve() {
        int[] pre = new int[3], suf = new int[3];
        for (int i = 0; i < n; i++) {
            if (s[i] == 'X') {
                suf[a[i]]++;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'M') {
                pre[a[i]]++;
            } else if (s[i] == 'E') {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        ans += (long) mex[1 << a[i] | 1 << j | 1 << k] * pre[j] * suf[k];
                    }
                }
            } else {
                suf[a[i]]--;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - MEX
https://atcoder.jp/contests/abc308/tasks/abc308_e

灵茶の试炼 2023-09-05
题目大意：
输入 n(3≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤2)，以及长为 n 的字符串，仅包含 'M' 'E' 'X'。
遍历所有满足 i<j<k 且 s[i]=M 且 s[j]=E 且 s[k]=X 的下标三元组 (i,j,k)，累加 mex(a[i],a[j],a[k]) 的值，输出这个累加值。
注：mex(a[i],a[j],a[k]) 表示不在 a[i],a[j],a[k] 中的最小非负整数。

方法一：前后缀分解
枚举中间的 j。我们需要知道左边满足 s[i]=M 的 0/1/2 的个数；右边满足 s[k]=X 的 0/1/2 的个数。
这可以预处理出来。
当 s[j]=E 时，枚举 j 左边的 0/1/2 和 j 右边的 0/1/2 的 9 种组合，再算上 a[j]，得到 mex。
例如 a[j]=1，左边有 5 个 1，右边有 3 个 0，那么 mex(1,1,0)=2，对答案的贡献是 5*3=15 个 mex，也就是 30。
https://atcoder.jp/contests/abc308/submissions/45101686
方法二：状态机 DP
定义 f0[0/1/2] 表示当前统计的满足 s[i]=M 的 0/1/2 的个数。
定义 f1[1/2/3/4/5/6] 表示当前统计的满足 a[i]=M 且 a[j]=E 的 a[i] 和 a[j] 组成的集合（二进制表示）的个数，例如 f1[5] 表示集合 {0,2} 的个数。
遍历到 s[k]=X 时，枚举 mask=1/2/3/4/5/6，把答案加上 mex(mask 和 a[k] 组成的集合) * f1[mask]
https://atcoder.jp/contests/abc308/submissions/45102151
======

Input 1
4
1 1 0 2
MEEX
Output 1
3

Input 2
3
0 0 0
XXX
Output 2
0

Input 3
15
1 1 2 0 0 2 0 2 0 0 0 0 0 2 2
EXMMXXXEMEXEXMM
Output 3
13
 */
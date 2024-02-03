package p1895;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1895D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] c1 = new int[32];
        for (int i = 1; i < n; i++) {
            a[i] ^= a[i - 1];
            for (int j = a[i]; j > 0; j &= j - 1) {
                c1[Integer.numberOfTrailingZeros(j)]++;
            }
            for (int j = i; j > 0; j &= j - 1) {
                c1[Integer.numberOfTrailingZeros(j)]--;
            }
        }
        int a0 = 0;
        for (int i = 0; i < 32; i++) {
            if (c1[i] != 0) {
                a0 |= 1 << i;
            }
        }

        List<Integer> output = new ArrayList<>();
        output.add(a0);
        for (int i = 1; i < n; i++) {
            output.add(a[i] ^ a0);
        }
        return output.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. XOR Construction
https://codeforces.com/contest/1895/problem/D

灵茶の试炼 2023-12-21
题目大意：
输入 n(2≤n≤2e5) 和长为 n-1 的数组 a(0≤a[i]≤2n)。
构造一个长为 n 的，0 到 n-1 的排列 b，满足 a[i] = b[i] XOR b[i+1]。
输入保证有解。

rating 1900
我的思考过程：
1. 暴力做法是枚举 b1，然后看生成的 b 数组是否没有重复数字且元素值均小于 n。
2. 那如果 b 数组中有重复数字，对应的 a 数组会是什么样的？
（拿出草稿纸）假设 b 数组有某个子数组是 x,y,z,x，那么对应的 a 的子数组是 x^y,y^z,z^x，这三个数的异或和是 0。
3. （意识到 a 的异或前缀和很重要）
a1^a2^...^ai = b1^b(i+1)
4. 看样例 2，异或前缀和是 0,1,7,6,2,3，转成二进制看看。
000
001
111
110
010
011
确定了 b1 就能确定整个 b 数组。
5. （位运算的套路之一是拆位）b1 的最高位填 0 还是 1？
这得对比最终目标，也就 0 到 n-1 都恰好出现一次。
把 0,1,2,...,n-1 列出来：
000
001
010
011
100
101
6. 到这里就一目了然了，（用【必要条件】来思考，0 和 1 的个数总得对上吧！）最高位只能填 0，因为【前缀异或和】和【0 到 n-1】的 0 和 1 的个数已经是一样的了；次高位不一样，所以填 1；最低位一样，填 0。
7. 所以统计一下前缀异或和每一位的 1 的个数，以及 0 到 n-1 每一位的 1 的个数，按照上面的过程计算出 b1，就得到了 b 数组。
https://codeforces.com/contest/1895/submission/236901458
======

input
4
2 1 2
output
0 2 3 1

input
6
1 6 1 4 1
output
2 3 5 4 0 1
 */

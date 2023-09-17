package c290;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc290_e {
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
        long m = n / 2;
        long ans = m * (m + 1) * (m * 4 + n % 2 * 6 - 1) / 6;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = a[i] - 1;
            pos.computeIfAbsent(v, key -> new ArrayList<>()).add(i);
        }

        for (List<Integer> ps : pos.values()) {
            int l = 0, r = ps.size() - 1;
            while (l < r) {
                if (ps.get(l) + ps.get(r) < n) {
                    ans -= (long) (ps.get(l) + 1) * (r - l);
                    l++;
                } else {
                    ans -= (long) (n - ps.get(r)) * (r - l);
                    r--;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Make it Palindrome
https://atcoder.jp/contests/abc290/tasks/abc290_e

灵茶の试炼 2023-08-16
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
定义 f(b) 表示把数组 b 修改成回文数组，至少要修改多少个数。
例如 f([1,2])=1，f([1,2,1])=0，f([1,2,3,4])=2。
对 a 的每个连续子数组 b，分别独立计算 f(b)。
输出所有 f(b) 的和。

错误的思路：区间 DP。复杂度太高，没有优化空间。
提示 1：一对数只需修改其中一个。
提示 2：正难则反，考虑有多少对数字无需修改。用所有数对个数，减去无需修改的数对个数，就是需要修改的数对个数。
所有数对个数 = sum(长为 i 的子数组个数 * floor(i/2))，其中【长为 i 的子数组个数】就是 n+1-i。
可以写个 for 循环计算，也可以用公式 O(1) 算。
提示 3：贡献法。对于 a[i]=a[j] 的这对数，考虑这对数能出现在多少个子数组中。
什么时候子数组的个数取决于 i，什么时候取决于 j？
答：设下标从 0 开始。如果 i+j<n，那么取决于 i，否则取决于 j。
（想象成从 [i,j] 不断向外扩展，i 向左，j 向右）
提示 4：保存相同元素的下标列表 pos。
方法一：相向双指针。
设 p 为 pos 中的一个下标列表（下标从 0 开始）。
初始化 l=0，r=len(p)-1，循环直到 l>=r。
如果 p[l]+p[r]<n，那么有 p[l]+1 个子数组是包含 p[l] 和 p[r] 的。（这里的包含指 p[l] 和 p[r] 作为回文数组的对称位置）
此外，这意味着 p[l]+p[r-1] 也是 < n 的，那么也有 p[l]+1 个子数组是包含 p[l] 和 p[r-1] 的。
此外，这意味着 p[l]+p[r-2] 也是 < n 的，那么也有 p[l]+1 个子数组是包含 p[l] 和 p[r-2] 的。
依此类推，从 r'=r 到 r'=l+1，这样的 r' 一共有 r-l 个。
那么 p[l] 对答案的贡献为 (p[l]+1) * (r-l)。
如果 p[l]+p[r]>=n，那么同理可得 p[r] 对答案的贡献为 (n-p[r]) * (r-l)。
时间复杂度 O(n)。
代码：
https://atcoder.jp/contests/abc290/submissions/44626822
方法二：二分查找。
如果你没有想到相向双指针，那么二分可能更适合你。
遍历 r。我们可以在 p 中二分找哪些 p[l] 满足 p[l]+p[r]<n，哪些 p[l] 满足 p[l]+p[r]>=n，分别统计。
时间复杂度 O(nlogn)。
代码：
https://atcoder.jp/contests/abc290/submissions/44626962
======

Input 1
5
5 2 1 2 2
Output 1
9
 */
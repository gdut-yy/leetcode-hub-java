package p520;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CF520B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve1(n, m));
    }

    private static String solve(int n, int m) {
        if (n > m) {
            return String.valueOf(n - m);
        }

        int ans = 0;
        while (n < m) {
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m++;
            }
            ans++;
        }
        return String.valueOf(ans + n - m);
    }

    private static String solve1(int n, int m) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(m);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                if (x <= n) {
                    return String.valueOf(step + n - x);
                }

                if (x % 2 == 0) {
                    queue.add(x / 2);
                } else {
                    queue.add(x + 1);
                }
            }
            step++;
        }
        return "-1";
    }
}
/*
B. Two Buttons
https://codeforces.com/contest/520/problem/B

灵茶の试炼 2023-05-08
题目大意：
输入两个不同的整数 n m，范围都在 [1,1e4]。
每次操作，可以 n*=2，或者 n-=1。
至少操作多少次可以得到 m？
如果还可以加一呢？

rating 1400
https://codeforces.com/contest/520/submission/204549550
如果 n > m，就只能不断 -1 了，所以直接输出 n-m。
如果 n < m，可以用 BFS（稍微限制一下数字的上界，比如不能超过 10m）。
下面说一个 O(log) 的做法。
由于 *2 不稳定（不知道什么时机 *2 最好），逆向思维，改成从 m 出发，通过 /2 和 +1 变成 n。
能不能执行连续两次 +1，再 /2 呢？
这不如先 /2 再 +1，只需要两次操作
所以只要 m 是偶数就 /2，奇数才 +1。直到 m <= n 退出循环，因为必须都 +1。这样可以做到 O(log) 的时间复杂度。
O(1) 做法见右侧链接。https://codeforces.com/contest/520/submission/205035892
相似题目: E. Generate a String
https://codeforces.com/contest/710/problem/E
======

input
4 6
output
2

input
10 1
output
9

99 100
50
 */

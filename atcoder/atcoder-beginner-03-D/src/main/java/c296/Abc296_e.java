package c296;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc296_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    // https://atcoder.jp/contests/abc296/editorial/6126
    private static String solve(int n, int[] a) {
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]--;
            c[a[i]]++;
        }

        List<List<Integer>> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            b.add(new ArrayList<>());
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (c[i] == 0) {
                ans--;
                b.get(0).add(i);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int sz = b.get(i).size();
            if (sz == 0) {
                break;
            }
            for (int j = 0; j < sz; j++) {
                c[a[b.get(i).get(j)]]--;
                if (c[a[b.get(i).get(j)]] == 0) {
                    ans--;
                    b.get(i + 1).add(a[b.get(i).get(j)]);
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Transition Game
https://atcoder.jp/contests/abc296/tasks/abc296_e

题目大意：
给你一个 N 个数字的序列:a =(a1, a2,..., aN)。这里，每个 i(1≤i≤N)满足 1≤i≤N。
高桥和青木将进行 N 轮比赛。对于每一个 i=1,2,...,N，第 i 个博弈如下。
- Aoki 表示正整数 Ki。
- 在知道了青木指定的 Ki 后，高桥选择了 1 到 N 之间的整数 i，并将其写在黑板上。
- 重复下列动作 Ki 次。把黑板上写的整数 x 换成 ax。
如果在 K 次迭代后，i 被写在黑板上，高桥赢了第 i 轮;否则，青木赢。
这里，当 i=1,2，…，N 时，可以分别选择 ki 和 si。
如果双方都以最佳方式获胜，求出高桥赢的回合数。
======

Input
3
2 2 3
Output
2

Input
2
2 1
Output
2
 */
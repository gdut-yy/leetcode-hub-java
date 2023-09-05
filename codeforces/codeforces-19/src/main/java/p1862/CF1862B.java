package p1862;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1862B {
    static int n;
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> ans = new ArrayList<>();
        ans.add(b[0]);
        for (int i = 1; i < n; i++) {
            if (b[i] >= b[i - 1]) {
                ans.add(b[i]);
            } else {
                ans.add(1);
                ans.add(b[i]);
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Sequence Game
https://codeforces.com/contest/1862/problem/B

题目大意：
Tema 和 Vika 正在玩下面的游戏。
首先，Vika 想出一个长度为 m 的正整数序列 a，并把它写在一张纸上。然后，她拿出一张新纸，按照以下规则写下序列 b:
- 首先，她写下 a1。
- 然后，她只写下 ai(2≤i≤m)且 ai−1≤ai。设这个序列的长度为 n。
例如，从序列 a=[4,3,2,6,3,3]中，Vika 将获得序列 b=[4,6,3]。
然后她把那张写着 b 的纸给了 Tema。然后，他试着猜测序列 a。
Tema 认为在这样的游戏中获胜的可能性很小，但仍然希望找到至少一个可能由 Vika 最初选择的序列 a。帮助他并输出任何这样的序列。
请注意，输出的序列长度不应超过输入序列长度的两倍以上。

构造，插 1 即可。
======

input
6
3
4 6 3
3
1 2 3
5
1 7 9 5 7
1
144
2
1 1
5
1 2 2 1 1
output
6
4 3 2 6 3 3
3
1 2 3
6
1 7 9 3 5 7
1
144
2
1 1
6
1 2 2 1 1 1
 */

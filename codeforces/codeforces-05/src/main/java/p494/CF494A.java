package p494;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF494A {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int cnt = 0, d = 0, minD = 0;
        for (char b : s) {
            if (b == '(') {
                d++;
                continue;
            }
            d--;
            if (d < 0) {
                return "-1";
            }
            if (b == '#') {
                cnt++;
                minD = d;
            } else if (minD > d) {
                minD = d;
            }
        }
        if (minD < d) {
            return "-1";
        }

        // Fprint(out, strings.Repeat("1\n", cnt-1), d+1)
        int[] ans = new int[cnt];
        Arrays.fill(ans, 1);
        ans[cnt - 1] = d + 1;
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
A. Treasure
https://codeforces.com/contest/494/problem/A

灵茶の试炼 2022-07-28
题目大意：
输入一个长度不超过 1e5 的括号字符串 s，s 中除了 '('，')' 外，还包含至少一个 '#'。
每个 '#' 都可以替换为一个或多个 ')'。问能否将所有的 '#' 都替换掉，得到一个有效括号字符串。
若不能，输出 -1；否则输出 s.count('#') 行，每行一个正整数，表示第 i 个 '#' 被替换成了多少个 ')'。若替换方案不止一种，输出任意一种即可。
注：一个字符串是有效括号字符串当且仅当它的左右括号个数相等，且任意前缀的左括号个数不超过右括号个数。
进阶：你能做到一次遍历吗？
进阶 2：如果要计算所有合法方案数要怎么做？(提问@七水)
如果 ## 替换成 )+)) 和 ))+) 算不同方案呢？算同一种方案呢？

rating 1500
https://codeforces.com/contest/494/submission/165854447
先把 '#' 改成 ')'，问题转换成可以在 '#' 的位置插入任意个 ')'。
用一个变量 d 表示 s 的平衡度：遇到 '(' 就 +1，遇到 ')' 或 '#' 就 -1。
数形结合一下，把 d 的变化折线图画出来，由于我们只能添加右括号，那么中途 d<0 则直接输出 -1。
如果最后 d>0，我们可以在最后一个 '#' 处添加右括号，这相当于把从这个 '#' 处开始的折线图往下移，使末尾的 d=0。
因此只要从 '#' 到末尾中间的 d 值不低于末尾的 d 值，就可以调整成一个有效括号字符串。
想一想，为什么要处理的是最后一个 '#'？
如果处理的是一个前面的 '#'，那要是遇到中间的 d 值小于末尾的 d 值，就会失败。那不如直接处理最后一个更优。
---
说一点和这题有关的故事，这题是我在 19 年刚回坑时做的，当时写了个比较麻烦的 replace 的做法，而且还 WA 了一发。
https://codeforces.com/contest/494/submission/61223061
你能看出错在哪里吗？
这周我重新做了一遍这题，一眼就想出了我题解中的一次遍历做法。我相信这离不开持续的训练和总结。
你们在看我题解的时候，会发现我经常写出更加简洁的做法，CF 或者 LC 上。其实我也是从算法萌新一步步走过来的，不过我有一个习惯，就是喜欢到处看别人写的代码，比如运行最快、代码最短、通过最早等等，分析不同写法的优劣之处；有时还会看别人写错的代码，分析别人为什么会写错。很多很细节的东西，书上是不会讲的，就是零散地分布在互联网的小角落里了，等着你去发现，化为己用。
======

input
(((#)((#)
output
1
2

input
()((#((#(#()
output
2
2
1

input
#
output
-1

input
(#)
output
-1
 */

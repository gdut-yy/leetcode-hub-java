package p1821;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CF1821E {
    static int k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            k = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> a = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                st.push(i);
            } else {
                a.add((i - st.peek()) / 2);
                st.pop();
            }
        }
        a.sort(null);
        long ans = 0;
        for (int i = 0; i < a.size() - k; i++) {
            ans += a.get(i);
        }
        return String.valueOf(ans);
    }
}
/*
E. Rearrange Brackets
https://codeforces.com/contest/1821/problem/E

灵茶の试炼 2024-01-18
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的字符串长度之和 ≤2e5。
每组数据输入 k(0≤n≤5) 和一个长度 ≤2e5 的合法括号字符串 s。
定义 s 的代价为：
初始化 cost=0，不断选取 s 中的一对相邻括号，即 s[i-1]='(' 且 s[i]=')'，将这对括号删除，并将 cost 增加 s[i] 右边的括号数量。例如 (()) 删除内层的 () 会让 cost 增加 1。
如此直到 s 为空。s 的代价就是最终的 cost 值。
定义 s 的最小代价为：
所有删除括号方案的最小代价。
在计算最小代价前，你可以执行如下操作至多 k 次。
选择一个 s[i]，将其移动到 s 的任意位置。
需要保证操作后 s 仍然是合法括号字符串。
设操作至多 k 次后得到的字符串为 t，输出 t 的最小代价的最小值。

rating 2100
提示 1
k=0 时，答案（最小代价）是多少？
提示 2
我们可以从右往左删除。如果一对括号的深度（嵌套在多少个括号内）是 d，当我们删除这对括号时，右括号的右边恰好有 d 个括号，且都是右括号，所以删除这对括号最少需要 d 的代价。
最小代价即为所有括号的深度之和。
提示 3
k=1 时，答案是多少？
操作等价于把任意一对匹配的括号删除，例如 "( () (()) )" （为了方便大家看的更清楚，我添加了一些空格），我们可以删除最外层的括号得到 "() (())"，这 3 对括号的深度都减少了 1，所以深度之和减少了 3。
一般地，删除一对匹配的括号，可以让深度和减少 floor((j-i)/2)，其中 i 和 j 是左右括号的下标。
提示 4
从 floor((j-i)/2) 这个式子可以发现，删除外层括号，不会改变删除内层括号对深度之和的减少量。
所以删除 floor((j-i)/2) 最大的 k 对括号即可，即使这些括号有嵌套关系。
https://codeforces.com/contest/1821/submission/240887632
======

input
7
0
()
0
(())
1
(())
5
()
1
(()()(()))
2
((())()(()())((())))
3
((())()(()())((())))
output
0
1
0
0
1
4
2
 */

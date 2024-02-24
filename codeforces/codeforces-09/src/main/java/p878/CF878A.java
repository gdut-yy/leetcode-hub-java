package p878;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF878A {
    static int n;
    static Command[] cmd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        cmd = new Command[n];
        for (int i = 0; i < n; i++) {
            char op = scanner.next().charAt(0);
            int v = scanner.nextInt();
            cmd[i] = new Command(op, v);
        }
        System.out.println(solve());
    }

    private static String solve() {
        int mask = 0, xor = 0;
        for (Command cmd : cmd) {
            char op = cmd.op;
            int v = cmd.v;

            if (op == '^') {
                xor ^= v;
            } else if (op == '&') {
                mask |= ~v;
                xor &= v;
            } else {
                mask |= v;
                xor |= v;
            }
        }

        List<String> ans = new ArrayList<>();
        ans.add("3");
        ans.add("^ " + xor);
        ans.add("& " + (1023 & (~mask) | xor));
        ans.add("| " + (mask & xor));
        return String.join(System.lineSeparator(), ans);
    }

    static class Command {
        char op;
        int v;

        public Command(char op, int v) {
            this.op = op;
            this.v = v;
        }
    }
}
/*
A. Short Program
https://codeforces.com/contest/878/problem/A

灵茶の试炼 2022-05-11
题目大意：
给你两个长度不超过 5e5 的数组 op 和 val，其中 op[i] 为 & | ^ 三种位运算中的一种，0<=val[i]<=1023
这表示如下函数 f，它接收一个整数 x(0<=x<=1023)，经过若干位运算后，再返回这个数
def f(x: int) -> int:
    x = x op[1] val[1]
    x = x op[2] val[2]
    ...
    x = x op[n] val[n]
    return x
请你写一个结构与 f 类似的新函数 g，其至多包含 5 对 op' 和 val'，且对任意 0<=x<=1023 均满足 f(x) = g(x)
输出 g 中的 op' 和 val'（其中 op'[i] 为 & | ^ 三种位运算中的一种，0<=val'[i]<=1023）

rating 1600
https://codeforces.com/contest/878/submission/156773072
位运算常用技巧：把每一位拆开单独算
这样就能找到简化方法：只要某一位上发生了 & 0 或者 | 1，那么这一位的最终结果就是确定的
最后发现不用拆开也能算出来：
只看每一位的话，如果遇到了 |1 或者 &0，那么后面这个位的值是可以确定的。那么分类讨论：
这一位没有遇到 |1 和 &0，那么就根据 ^ 来算
这一位遇到了 |1 或者 &0：
     最后结果为 0：需要用 &0 来 set bit
     最后结果为 1：需要用 |1 来 set bit
最后变成三个 op val
先 ^ 一下把没有遇到 |1 和 &0 的 bit 确定了
然后把结果为 0 的用 & 来 set，把结果为 1 的用 | 来 set
======

input
3
| 3
^ 2
| 1
output
2
| 3
^ 2

input
3
& 1
& 3
& 5
output
1
& 1

input
3
^ 1
^ 2
^ 3
output
0
 */

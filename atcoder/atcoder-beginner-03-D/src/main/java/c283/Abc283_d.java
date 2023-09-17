package c283;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc283_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        // 盒子里的元素
        Set<Character> box = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    box.remove(stack.pop());
                }
                // 弹出 '('
                stack.pop();
            } else if (ch == '(') {
                stack.push(ch);
            } else {
                // letter
                if (box.contains(ch)) {
                    return "No";
                } else {
                    box.add(ch);
                    stack.push(ch);
                }
            }
        }
        return "Yes";
    }
}
/*
D - Scope
https://atcoder.jp/contests/abc283/tasks/abc283_d

题目大意：
一个由小写英文字母，(，和 ) 组成的字符串，如果你能通过以下过程使其成为空字符串，就被认为是一个好字符串:
- 首先，去掉所有小写英文字母。
- 然后，在可能的情况下反复删除连续的 ()。
例如，((a)ba) 是一个很好的字符串，因为删除所有小写英文字母会产生 (())，我们可以从中删除第 2 和第 3 个字符的连续()来获得()，这反过来又以空字符串结束。
你有一个很好的字符串 S，我们用 Si 表示 S 的第 i 个字符。
对于每个小写英文字母 a, b，…，和 z，我们有一个球，上面写着这个字母。另外，我们还有一个空盒子。
对于每一个 i=1,2,...,|S| 在这个顺序中，Takahashi 执行以下操作，除非他晕倒。
- 如果是小写英文字母，把写有字母的球放进盒子里。如果球已经在禁区内，他就会晕倒。
- 如果 si 是 '('，什么都不做。
- 如果 Si 是 ')'，取小于 i 的最大整数 j，使得 S 的第 j 到第 i 个字符形成一个好的字符串。（我们可以证明这样的整数 j 总是存在的。）从盒子里拿出他在第 j 次到第 i 次操作中放入的所有球。
确定高桥是否能在不晕厥的情况下完成一系列操作。

括号序 栈思想。
======

Input 1
((a)ba)
Output 1
Yes

Input 2
(a(ba))
Output 2
No

Input 3
(((())))
Output 3
Yes

Input 4
abca
Output 4
No
 */
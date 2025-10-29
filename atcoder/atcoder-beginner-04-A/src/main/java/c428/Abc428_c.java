package c428;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Abc428_c {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record State(int balance, int minBalance) {
    }

    private static void solve() {
        int q = scanner.nextInt();
        Deque<State> st = new ArrayDeque<>();
        st.push(new State(0, 0));
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                char c = scanner.next().charAt(0);
                State current = st.peek();
                int newBal, newMinBal;

                if (c == '(') {
                    newBal = current.balance + 1;
                    newMinBal = Math.min(current.minBalance, newBal);
                } else {
                    newBal = current.balance - 1;
                    newMinBal = Math.min(current.minBalance, newBal);
                }
                st.push(new State(newBal, newMinBal));
            } else {
                st.pop();
            }

            State top = st.peek();
            if (top.minBalance >= 0 && top.balance == 0) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }

//    private static void solve1() {
//        int q = scanner.nextInt();
//        Deque<Character> st = new ArrayDeque<>();
//        Deque<Character> st2 = new ArrayDeque<>();
//        int sum = 0;
//        while (q-- > 0) {
//            int op = scanner.nextInt();
//            if (op == 1) {
//                char c = scanner.next().charAt(0);
//                sum += c == '(' ? 1 : -1;
//                st.push(c);
//
//                if (c == ')' && !st2.isEmpty() && st2.peek() == '(') {
//                    st2.pop();
//                } else {
//                    st2.push(c);
//                }
//            } else {
//                char c = st.pop();
//                sum -= c == '(' ? 1 : -1;
//
//                st2.pop();
//            }
//            out.println(sum == 0 && st2.isEmpty() ? "Yes" : "No");
//        }
//    }
}
/*
C - Brackets Stack Query
https://atcoder.jp/contests/abc428/tasks/abc428_c

题目大意：
有一个字符串 S 。最初， S 是空字符串。
按照给出的顺序处理 Q 查询。每次查询后，判断 S 是否是一个好的括号序列。
- `1 c`:给出了一个字符 c 。 c 是`（`或`）`。将 c 追加到 S 的末尾。
- `2`:删除 S 的最后一个字符。保证此时 S 不是空字符串。

https://yuanbao.tencent.com/chat/naQivTmsDa/bda23b34-755d-4ef1-aba4-8cb76ed5dac2
======

Input 1
8
1 (
2
1 (
1 )
2
1 (
1 )
1 )
Output 1
No
Yes
No
Yes
No
No
No
Yes
 */

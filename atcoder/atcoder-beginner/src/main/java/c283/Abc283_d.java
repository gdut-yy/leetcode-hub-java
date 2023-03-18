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
        String S = scanner.next();

        // 盒子里的元素
        Set<Character> box = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : S.toCharArray()) {
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
                    System.out.println("No");
                    return;
                } else {
                    box.add(ch);
                    stack.push(ch);
                }
            }
        }
        System.out.println("Yes");
    }
}
/*
D - Scope
https://atcoder.jp/contests/abc283/tasks/abc283_d

括号序 栈思想
 */
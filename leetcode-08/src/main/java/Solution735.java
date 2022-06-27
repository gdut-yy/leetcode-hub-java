import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }
            if (!stack.isEmpty() && asteroid < 0 && stack.peek() == -asteroid) {
                stack.pop();
            } else if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        List<Integer> list = new ArrayList<>(stack);
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
/*
735. 行星碰撞
https://leetcode.cn/problems/asteroid-collision/

注意 Stack 与 Deque 的区别：
Stack<Integer> stack1 = new Stack<>();
Deque<Integer> stack2 = new ArrayDeque<>();
stack1.push(1); stack1.push(2); stack1.push(3);
stack2.push(1); stack2.push(2); stack2.push(3);
System.out.println(Arrays.toString(stack1.stream().mapToInt(i -> i).toArray())); // [1, 2, 3]
System.out.println(Arrays.toString(stack2.stream().mapToInt(i -> i).toArray())); // [3, 2, 1]
 */
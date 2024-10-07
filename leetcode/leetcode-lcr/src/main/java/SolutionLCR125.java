import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionLCR125 {
    static class CQueue {
        Deque<Integer> st1, st2;

        public CQueue() {
            st1 = new ArrayDeque<>();
            st2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            st1.push(value);
        }

        public int deleteHead() {
            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
            if (!st2.isEmpty()) {
                return st2.pop();
            }
            return -1;
        }
    }
}
/*
LCR 125. 图书整理 II
https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/description/

读者来到图书馆排队借还书，图书管理员使用两个书车来完成整理借还书的任务。书车中的书从下往上叠加存放，图书管理员每次只能拿取书车顶部的书。排队的读者会有两种操作：
- push(bookID)：把借阅的书籍还到图书馆。
- pop()：从图书馆中借出书籍。
为了保持图书的顺序，图书管理员每次取出供读者借阅的书籍是 最早 归还到图书馆的书籍。你需要返回 每次读者借出书的值 。
如果没有归还的书可以取出，返回 -1 。
提示：
1 <= bookID <= 10000
最多会对 push、pop 进行 10000 次调用

注意空队列时，出队的差异。
相似题目: 232. 用栈实现队列
https://leetcode.cn/problems/implement-queue-using-stacks/
 */
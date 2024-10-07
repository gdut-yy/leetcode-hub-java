import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionLCR148 {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        int n = putIn.length;
        Deque<Integer> st = new ArrayDeque<>();
        int popIdx = 0;
        for (int push : putIn) {
            st.push(push);
            while (!st.isEmpty() && popIdx < n && st.peek() == takeOut[popIdx]) {
                st.pop();
                popIdx++;
            }
        }
        return popIdx == n;
    }
}
/*
LCR 148. 验证图书取出顺序
https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/description/

现在图书馆有一堆图书需要放入书架，并且图书馆的书架是一种特殊的数据结构，只能按照 一定 的顺序 放入 和 拿取 书籍。
给定一个表示图书放入顺序的整数序列 putIn，请判断序列 takeOut 是否为按照正确的顺序拿取书籍的操作序列。你可以假设放入书架的所有书籍编号都不相同。
提示：
0 <= putIn.length == takeOut.length <= 1000
0 <= putIn[i], takeOut < 1000
putIn 是 takeOut 的排列。

同: 946. 验证栈序列
https://leetcode.cn/problems/validate-stack-sequences/
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution933 {
    static class RecentCounter {
        private final Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.element() + 3000 < t) {
                queue.remove();
            }
            return queue.size();
        }
    }
}
/*
933. 最近的请求次数
https://leetcode-cn.com/problems/number-of-recent-calls/

“固定大小的队列”
 */
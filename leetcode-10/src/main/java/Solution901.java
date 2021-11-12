import java.util.ArrayDeque;
import java.util.Deque;

public class Solution901 {
    static class StockSpanner {
        private final Deque<Integer> priceStack;
        private final Deque<Integer> wStack;

        private int countRemove;

        public StockSpanner() {
            priceStack = new ArrayDeque<>();
            wStack = new ArrayDeque<>();
        }

        public int next(int price) {
            int w = 1;
            while (!priceStack.isEmpty() && priceStack.peek() <= price) {
                priceStack.pop();
                w += wStack.pop();
            }
            priceStack.push(price);
            wStack.push(w);
            return w;
        }
    }
}
/*
901. 股票价格跨度
https://leetcode-cn.com/problems/online-stock-span/

编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

单调栈。
 */
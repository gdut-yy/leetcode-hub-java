import java.util.ArrayList;
import java.util.List;

public class Solution6364 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i, reward1[i], reward2[i]));
        }
        list.sort((o1, o2) -> Integer.compare(o2.r1 - o2.r2, o1.r1 - o1.r2));

        int res = 0;
        for (int i = 0; i < k; i++) {
            res += list.get(i).r1;
        }
        for (int i = k; i < n; i++) {
            res += list.get(i).r2;
        }
        return res;
    }

    private static class Node {
        int i;
        int r1;
        int r2;

        public Node(int i, int r1, int r2) {
            this.i = i;
            this.r1 = r1;
            this.r2 = r2;
        }
    }
}
/*
6364. 老鼠和奶酪
https://leetcode.cn/problems/mice-and-cheese/

第 339 场周赛 T3。

有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
下标为 i 处的奶酪被吃掉的得分为：
- 如果第一只老鼠吃掉，则得分为 reward1[i] 。
- 如果第二只老鼠吃掉，则得分为 reward2[i] 。
给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
提示：
1 <= n == reward1.length == reward2.length <= 10^5
1 <= reward1[i], reward2[i] <= 1000
0 <= k <= n

贪心 + 排序
时间复杂度 O(nlogn)
 */
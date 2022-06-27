import java.util.PriorityQueue;

public class Solution2102 {
    static class SORTracker {
        private static class Scenic {
            String name;
            int score;

            public Scenic(String name, int score) {
                this.name = name;
                this.score = score;
            }
        }

        PriorityQueue<Scenic> priorityQueue1;
        PriorityQueue<Scenic> priorityQueue2;

        public SORTracker() {
            // 小顶堆顶存放第 i 个最大值
            priorityQueue1 = new PriorityQueue<>((o1, o2) -> {
                if (o1.score == o2.score) {
                    return o2.name.compareTo(o1.name);
                }
                return Integer.compare(o1.score, o2.score);
            });
            // 大顶堆存放 i-1 个最大的值
            priorityQueue2 = new PriorityQueue<>((o1, o2) -> {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                }
                return Integer.compare(o2.score, o1.score);
            });
        }

        public void add(String name, int score) {
            priorityQueue1.add(new Scenic(name, score));
            priorityQueue2.add(priorityQueue1.poll());
        }

        public String get() {
            priorityQueue1.add(priorityQueue2.poll());
            return priorityQueue1.peek().name;
        }
    }
}
/*
2102. 序列顺序查询
https://leetcode.cn/problems/sequentially-ordinal-rank-tracker/

第 67 场双周赛 T4。

一个观光景点由它的名字 name 和景点评分 score 组成，其中 name 是所有观光景点中 唯一 的字符串，score 是一个整数。
景点按照最好到最坏排序。景点评分 越高 ，这个景点越好。如果有两个景点的评分一样，那么 字典序较小 的景点更好。
你需要搭建一个系统，查询景点的排名。初始时系统里没有任何景点。这个系统支持：
- 添加 景点，每次添加 一个 景点。
- 查询 已经添加景点中第 i 好 的景点，其中 i 是系统目前位置查询的次数（包括当前这一次）。
比方说，如果系统正在进行第 4 次查询，那么需要返回所有已经添加景点中第 4 好的。
注意，测试数据保证 任意查询时刻 ，查询次数都 不超过 系统中景点的数目。
请你实现 SORTracker 类：
- SORTracker() 初始化系统。
- void add(string name, int score) 向系统中添加一个名为 name 评分为 score 的景点。
- string get() 查询第 i 好的景点，其中 i 是目前系统查询的次数（包括当前这次查询）。

双优先队列倒腾。
相似题目: 295. 数据流的中位数
https://leetcode.cn/problems/find-median-from-data-stream/
 */
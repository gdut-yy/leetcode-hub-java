import java.util.Map;
import java.util.TreeMap;

public class Solution2276 {
    static class CountIntervals {
        private final TreeMap<Integer, Integer> intervalMap;
        private int cnt;

        public CountIntervals() {
            intervalMap = new TreeMap<>();
            cnt = 0;
        }

        public void add(int left, int right) {
            int newLeft = left;
            int newRight = right;

            Map.Entry<Integer, Integer> interval = intervalMap.floorEntry(right);
            while (interval != null && interval.getValue() >= newLeft) {
                cnt -= interval.getValue() - interval.getKey() + 1;
                newLeft = Math.min(newLeft, interval.getKey());
                newRight = Math.max(newRight, interval.getValue());
                intervalMap.remove(interval.getKey());
                interval = intervalMap.floorEntry(right);
            }
            intervalMap.put(newLeft, newRight);
            cnt += newRight - newLeft + 1;
        }

        public int count() {
            return cnt;
        }
    }

    static class CountIntervals2 {
        private final DynamicSegTree dynamicSegTree;

        public CountIntervals2() {
            dynamicSegTree = new DynamicSegTree();
        }

        public void add(int left, int right) {
            dynamicSegTree.update(left, right, 1);
        }

        public int count() {
            return dynamicSegTree.getSum();
        }

        // 动态开点线段树
        private static class DynamicSegTree {
            private static class Node {
                // 左子树
                Node ls;
                // 右子树
                Node rs;
                // 区间和
                int sum;
                // 懒标记
                int lazy;
            }

            private static final int N = (int) 1e9;
            private final Node root = new Node();

            // 区间更新 [l,r] 置为 val
            void update(int l, int r, int val) {
                this.update(l, r, val, 1, N, root);
            }

            // 区间查询 [l,r] 的和
            int getSum() {
                return this.getSum(1, N, 1, N, root);
            }

            private void update(int l, int r, int val, int s, int t, Node node) {
                int len = t - s + 1;
                if (l <= s && t <= r) {
                    node.sum = (val == 1) ? len : 0;
                    node.lazy = val;
                    return;
                }
                pushDown(node, len);
                int mid = s + (t - s) / 2;
                if (l <= mid) {
                    update(l, r, val, s, mid, node.ls);
                }
                if (r > mid) {
                    update(l, r, val, mid + 1, t, node.rs);
                }
                pushUp(node);
            }

            private int getSum(int l, int r, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    return node.sum;
                }
                pushDown(node, t - s + 1);
                int mid = s + (t - s) / 2;
                int sum = 0;
                if (l <= mid) {
                    sum = getSum(l, r, s, mid, node.ls);
                }
                if (r > mid) {
                    sum += getSum(l, r, mid + 1, t, node.rs);
                }
                return sum;
            }

            private void pushDown(Node node, int len) {
                if (node.ls == null) {
                    node.ls = new Node();
                }
                if (node.rs == null) {
                    node.rs = new Node();
                }
                if (node.lazy == 0) {
                    return;
                }
                // 当 add = -1 代表 removeRange 懒标记，当 add = 1 则代表 addRange 懒标记。
                int add = node.lazy;
                if (add == -1) {
                    node.ls.sum = 0;
                    node.rs.sum = 0;
                } else {
                    node.ls.sum = len - len / 2;
                    node.rs.sum = len / 2;
                }
                node.ls.lazy = add;
                node.rs.lazy = add;
                node.lazy = 0;
            }

            private void pushUp(Node node) {
                node.sum = node.ls.sum + node.rs.sum;
            }
        }
    }
}
/*
2276. 统计区间中的整数数目
https://leetcode.cn/problems/count-integers-in-intervals/

第 293 场周赛 T4。

给你区间的 空 集，请你设计并实现满足要求的数据结构：
- 新增：添加一个区间到这个区间集合中。
- 统计：计算出现在 至少一个 区间中的整数个数。
实现 CountIntervals 类：
- CountIntervals() 使用区间的空集初始化对象
- void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
- int count() 返回出现在 至少一个 区间中的整数个数。
注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
提示：
1 <= left <= right <= 10^9
最多调用  add 和 count 方法 总计 10^5 次
调用 count 方法至少一次

TreeMap模拟/动态开点线段树
相似题目: 57. 插入区间
https://leetcode.cn/problems/insert-interval/
352. 将数据流变为多个不相交区间
https://leetcode.cn/problems/data-stream-as-disjoint-intervals/
715. Range 模块
https://leetcode.cn/problems/range-module/
 */
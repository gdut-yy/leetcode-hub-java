public class Solution731 {
    static class MyCalendarTwo {
        private final DynamicSegTree dynamicSegTree;

        public MyCalendarTwo() {
            dynamicSegTree = new DynamicSegTree();
        }

        public boolean book(int start, int end) {
            int max = dynamicSegTree.getMax(start, end - 1);
            if (max >= 2) {
                return false;
            }
            dynamicSegTree.update(start, end - 1, 1);
            return true;
        }

        // 动态开点线段树
        private static class DynamicSegTree {
            private static class Node {
                // 左子树
                Node ls;
                // 右子树
                Node rs;
                // 区间最大值
                int max;
                // 懒标记
                int lazy;
            }

            private static final int N = (int) 1e9;
            private final Node root = new Node();

            // 区间更新 [l,r] 加上 val
            void update(int l, int r, int val) {
                this.update(l, r, val, 0, N, root);
            }

            // 区间查询 [l,r] 最大值
            int getMax(int l, int r) {
                return this.getMax(l, r, 0, N, root);
            }

            private void update(int l, int r, int val, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    node.max += val;
                    node.lazy += val;
                    return;
                }
                int mid = s + (t - s) / 2;
                pushDown(node);
                if (l <= mid) {
                    update(l, r, val, s, mid, node.ls);
                }
                if (r > mid) {
                    update(l, r, val, mid + 1, t, node.rs);
                }
                pushUp(node);
            }

            private int getMax(int l, int r, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    return node.max;
                }
                int mid = s + (t - s) / 2;
                pushDown(node);
                int max = 0;
                if (l <= mid) {
                    max = Math.max(max, getMax(l, r, s, mid, node.ls));
                }
                if (r > mid) {
                    max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
                }
                return max;
            }

            private void pushDown(Node node) {
                if (node.ls == null) {
                    node.ls = new Node();
                }
                if (node.rs == null) {
                    node.rs = new Node();
                }
                if (node.lazy > 0) {
                    node.ls.max += node.lazy;
                    node.rs.max += node.lazy;
                    node.ls.lazy += node.lazy;
                    node.rs.lazy += node.lazy;
                    node.lazy = 0;
                }
            }

            private void pushUp(Node node) {
                node.max = Math.max(node.ls.max, node.rs.max);
            }
        }
    }
}
/*
731. 我的日程安排表 II
https://leetcode.cn/problems/my-calendar-ii/

实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，start <= x < end。
当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
提示：
每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。

动态开点线段树
 */
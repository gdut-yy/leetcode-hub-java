public class Solution715 {
    static class RangeModule {
        private final SegmentTree segmentTree;

        public RangeModule() {
            segmentTree = new SegmentTree();
        }

        public void addRange(int left, int right) {
            segmentTree.update(left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            return segmentTree.getSum(left, right - 1) == right - left;
        }

        public void removeRange(int left, int right) {
            segmentTree.update(left, right - 1, -1);
        }

        // 动态开点线段树
        private static class SegmentTree {
            private static final int N = (int) (1e9 + 10);

            private static class Node {
                // 左子树
                Node ls;
                // 右子树
                Node rs;
                // 区间和
                int sum;
                // 懒标记
                int add;
            }

            private final Node root = new Node();

            // 区间更新 [l,r] 置为 val
            void update(int l, int r, int val) {
                this.update(l, r, val, 1, N, root);
            }

            // 区间查询 [l,r]
            int getSum(int l, int r) {
                return this.getSum(l, r, 1, N, root);
            }

            private void update(int l, int r, int val, int s, int t, Node node) {
                int len = t - s + 1;
                if (l <= s && t <= r) {
                    node.sum = (val == 1) ? len : 0;
                    node.add = val;
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
                if (node.add == 0) {
                    return;
                }
                // 当 add = -1 代表 removeRange 懒标记，当 add = 1 则代表 addRange 懒标记。
                int add = node.add;
                if (add == -1) {
                    node.ls.sum = 0;
                    node.rs.sum = 0;
                } else {
                    node.ls.sum = len - len / 2;
                    node.rs.sum = len / 2;
                }
                node.ls.add = add;
                node.rs.add = add;
                node.add = 0;
            }

            private void pushUp(Node node) {
                node.sum = node.ls.sum + node.rs.sum;
            }
        }
    }
}
/*
715. Range 模块
https://leetcode.cn/problems/range-module/

Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
实现 RangeModule 类:
- RangeModule() 初始化数据结构的对象。
- void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
- boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
- void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。

动态开点线段树（动态指针）
 */
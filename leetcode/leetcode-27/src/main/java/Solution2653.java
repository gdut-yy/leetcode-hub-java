import java.util.Objects;
import java.util.TreeSet;

public class Solution2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;

        // 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
        // 维护 k-(x-1) 个数
        TreeSet<Node> minHeap = new TreeSet<>((o1, o2) -> {
            if (o1.val == o2.val) {
                return Integer.compare(o1.id, o2.id);
            }
            return Integer.compare(o1.val, o2.val);
        });
        // 维护 x-1 个数
        TreeSet<Node> maxHeap = new TreeSet<>((o1, o2) -> {
            if (o1.val == o2.val) {
                return Integer.compare(o1.id, o2.id);
            }
            return Integer.compare(o2.val, o1.val);
        });

        // 滑动窗口
        // [0, k-1]
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(i, nums[i]));
        }
        for (int i = 0; i < x - 1; i++) {
            Node top = minHeap.pollFirst();
            maxHeap.add(top);
        }
        int[] res = new int[n - k + 1];
        res[0] = Math.min(minHeap.first().val, 0);

        // [k, n-1]
        for (int i = k; i < n; i++) {
            Node rm = new Node(i - k, nums[i - k]);
            if (maxHeap.contains(rm)) {
                maxHeap.remove(rm);
            } else {
                minHeap.remove(rm);
            }

            Node add = new Node(i, nums[i]);
            minHeap.add(add);
            if (!maxHeap.isEmpty()) {
                Node top = maxHeap.pollFirst();
                minHeap.add(top);
            }
            while (minHeap.size() > k - x + 1) {
                Node top = minHeap.pollFirst();
                maxHeap.add(top);
            }
            res[i - k + 1] = Math.min(minHeap.first().val, 0);
        }
        return res;
    }

    private static class Node {
        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id && val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, val);
        }
    }
}
/*
2653. 滑动子数组的美丽值
https://leetcode.cn/problems/sliding-subarray-beauty/

第 342 场周赛 T3。

给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
- 子数组指的是数组中一段连续 非空 的元素序列。
提示：
n == nums.length 
1 <= n <= 10^5
1 <= k <= n
1 <= x <= k 
-50 <= nums[i] <= 50

双堆/对顶堆/平衡树
如果 nums[i] 值域范围扩展到更大的做法。
时间复杂度 O(n)
相似题目: E - Least Elements
https://atcoder.jp/contests/abc281/tasks/abc281_e
 */
package lq240518;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LQ240518T8 {
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] p = next_mask_stack(a);
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            if (p[i] != n) {
                res[i] = res[p[i]] + 1;
            }
        }

        String[] output = new String[q];
        SegmentTreeBinarySearchIndex0 seg = new SegmentTreeBinarySearchIndex0(a);
        for (int i = 0; i < q; ++i) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int v = seg.binarySearchMax(l, r, seg.queryMax(l, r));
            output[i] = String.valueOf(res[v]);
        }
        System.out.println(String.join(System.lineSeparator(), output));
    }

    private static String solve() {
        return "";
    }

    static int[] next_mask_stack(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if (!st.isEmpty()) res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    static class SegmentTreeBinarySearchIndex0 {
        static class Node {
            long maxVal, minVal, sum;

            public Node(long maxVal, long minVal, long sum) {
                this.maxVal = maxVal;
                this.minVal = minVal;
                this.sum = sum;
            }
        }

        int n;
        Node[] tree;

        public SegmentTreeBinarySearchIndex0(int[] nums) {
            n = nums.length;
            tree = new Node[4 * n];
            Arrays.setAll(tree, e -> new Node(0, 0, 0));
            buildTree(nums, 0, 0, n - 1);
        }

        private void buildTree(int[] nums, int treeIndex, int lo, int hi) {
            if (lo == hi) {
                tree[treeIndex] = new Node(nums[lo], nums[lo], nums[lo]);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(nums, treeIndex * 2 + 1, lo, mid);
            buildTree(nums, treeIndex * 2 + 2, mid + 1, hi);
            pushUp(treeIndex);
        }

        private void pushUp(int treeIndex) {
            tree[treeIndex].maxVal = Math.max(tree[treeIndex * 2 + 1].maxVal, tree[treeIndex * 2 + 2].maxVal);
            tree[treeIndex].minVal = Math.min(tree[treeIndex * 2 + 1].minVal, tree[treeIndex * 2 + 2].minVal);
            tree[treeIndex].sum = tree[treeIndex * 2 + 1].sum + tree[treeIndex * 2 + 2].sum;
        }

        void update(int index, long val) {
            updateTree(0, 0, n - 1, index, val);
        }

        private void updateTree(int treeIndex, int lo, int hi, int arrIndex, long val) {
            if (lo == hi) {
                tree[treeIndex] = new Node(val, val, val);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            if (arrIndex <= mid) {
                updateTree(treeIndex * 2 + 1, lo, mid, arrIndex, val);
            } else {
                updateTree(treeIndex * 2 + 2, mid + 1, hi, arrIndex, val);
            }
            pushUp(treeIndex);
        }

        long queryMax(int i, int j) {
            return queryTree(0, 0, n - 1, i, j).maxVal;
        }

        long queryMin(int i, int j) {
            return queryTree(0, 0, n - 1, i, j).minVal;
        }

        long querySum(int i, int j) {
            return queryTree(0, 0, n - 1, i, j).sum;
        }

        private Node queryTree(int treeIndex, int lo, int hi, int i, int j) {
            if (lo > j || hi < i) return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            if (i <= lo && hi <= j) return tree[treeIndex];
            int mid = lo + (hi - lo) / 2;
            Node leftQuery = queryTree(treeIndex * 2 + 1, lo, mid, i, j);
            Node rightQuery = queryTree(treeIndex * 2 + 2, mid + 1, hi, i, j);

            return new Node(Math.max(leftQuery.maxVal, rightQuery.maxVal),
                    Math.min(leftQuery.minVal, rightQuery.minVal),
                    leftQuery.sum + rightQuery.sum);
        }

        long acc;

        int findTargetSumIndex(long target) {
            acc = 0;
            return binarySearchSum(0, 0, n - 1, target);
        }

        private int binarySearchSum(int treeIndex, int curLo, int curHi, long target) {
            if (curLo == curHi) {
                if (acc + tree[treeIndex].sum >= target) return curLo;
                acc += tree[treeIndex].sum;
                return -1;
            }
            int mid = curLo + (curHi - curLo) / 2;
            if (acc + tree[treeIndex * 2 + 1].sum >= target) {
                return binarySearchSum(treeIndex * 2 + 1, curLo, mid, target);
            } else {
                acc += tree[treeIndex * 2 + 1].sum;
                return binarySearchSum(treeIndex * 2 + 2, mid + 1, curHi, target);
            }
        }

        int binarySearchMax(int i, int j, long target) {
            return binarySearchMax(0, 0, n - 1, i, j, target);
        }

        private int binarySearchMax(int treeIndex, int curLo, int curHi,
                                    int targetLo, int targetHi, long target) {
            if (curHi < targetLo || curLo > targetHi
                    || tree[treeIndex].maxVal < target) {
                return -1;
            }
            if (curLo == curHi) {
                return tree[treeIndex].maxVal >= target ? curLo : -1;
            }

            int mid = curLo + (curHi - curLo) / 2;
            int res = -1;
            // 先尝试在左子树中查找
            if (mid >= targetLo) { // 只有当左子树可能包含目标区间时才搜索
                res = binarySearchMax(treeIndex * 2 + 1, curLo, mid, targetLo, targetHi, target);
            }
            // 如果左子树没有找到，并且右子树可能包含目标区间，才在右子树中搜索
            if (res == -1 && mid < targetHi && tree[treeIndex * 2 + 2].maxVal >= target) {
                res = binarySearchMax(treeIndex * 2 + 2, mid + 1, curHi, targetLo, targetHi, target);
            }
            return res;
        }

        int binarySearchMin(int i, int j, long target) {
            return binarySearchMin(0, 0, n - 1, i, j, target);
        }

        private int binarySearchMin(int treeIndex, int curLo, int curHi,
                                    int targetLo, int targetHi, long target) {
            if (curHi < targetLo || curLo > targetHi
                    || tree[treeIndex].minVal > target) {
                return -1;
            }
            if (curLo == curHi) {
                return tree[treeIndex].maxVal <= target ? curLo : -1;
            }

            int mid = curLo + (curHi - curLo) / 2;
            int res = -1;
            // 先尝试在左子树中查找
            if (mid >= targetLo && tree[treeIndex * 2 + 1].minVal <= target) { // 只有当左子树可能包含目标区间时才搜索
                res = binarySearchMin(treeIndex * 2 + 1, curLo, mid, targetLo, targetHi, target);
            }
            // 如果左子树没有找到，并且右子树可能包含目标区间，才在右子树中搜索
            if (res == -1 && mid < targetHi) {
                res = binarySearchMin(treeIndex * 2 + 2, mid + 1, curHi, targetLo, targetHi, target);
            }
            return res;
        }
    }
}
/*
皇家守卫【算法赛】

线段树上二分？
 */
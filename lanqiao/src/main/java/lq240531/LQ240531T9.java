package lq240531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LQ240531T9 {
    static int n;
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        long cur1 = 0, cur2 = 0;
        v1 = new ArrayList<>();
        v2 = new ArrayList<>();
        v1.add(0L);
        v2.add(0L);
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            cur1 += a - b;
            cur2 += a - c;
            v1.add(cur1);
            v2.add(cur2);
        }
        System.out.println(solve());
    }

    static List<Long> v1, v2;

    private static String solve() {
        // 离散化
        long[] yArr = getDiscrete(v1);

        Integer[] st_range = new Integer[n + 1];
        for (int i = 0; i < n + 1; i++) st_range[i] = i;
        Arrays.sort(st_range, (o1, o2) -> {
            if (v2.get(o1).equals(v2.get(o2))) {
                return Long.compare(v1.get(o1), v1.get(o2));
            }
            return Long.compare(v2.get(o1), v2.get(o2));
        });

        long ans = 0;
        int[] a = new int[n + 1];
        Arrays.fill(a, n);
        SegmentTreeBinarySearchIndex0 seg = new SegmentTreeBinarySearchIndex0(a);
        for (Integer i : st_range) {
            ans = Math.max(ans, i - seg.queryMin(0, getId(yArr, v1.get(i)) + 1));
            seg.update(getId(yArr, v1.get(i)), i);
        }

        return String.valueOf(ans);
    }

    static long[] getDiscrete(List<Long> xArr) {
        Set<Long> set = new HashSet<>();
        for (long x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        long[] yArr = new long[sz];
        int id = 0;
        for (long x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    static int getId(long[] yArr, long x) {
        return Arrays.binarySearch(yArr, x);
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
国赛训练【算法赛】

a 的区间和 大于 c 的区间和
(a - b) 的区间和大于 0
(a - c) 的区间和大于 0
(a - b) 前缀和构成 acc1
(a - c) 前缀和构成 acc2
acc1[r+1] >= acc1[l] 和 acc2[r+1] >= acc2[l] 满足的情况下，最大的 r + 1 - l
---
从小到大遍历所有的 (acc2[x], acc1[x])
一定満足 acc2[x] <= acc2[y]
只需要多考虑 acc1 的关系
现在考虑下标是 idx
要找到前面遍历的点满足 acc2[x] <= acc2[idx] 的 x 中最小的一个
对于每一个 acc[idx] 记录此前遇到的填在这个位置的最小下标
@小羊肖恩Yawn_Sean
 */
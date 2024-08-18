package lq240629;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LQ240629T6 {
    static int n;
    static int[][] va;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        va = new int[n][2];
        for (int i = 0; i < n; i++) {
            va[i][0] = scanner.nextInt();
            va[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 离散化
        int[] yArr = getDiscrete(va);

        String[] output = new String[n];
        SegmentTreeBinarySearchIndex0 seg = new SegmentTreeBinarySearchIndex0(new int[n + 1]);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int vi = va[i][0], ai = va[i][1];
            ans += ai;
            int j = getId(yArr, vi);

            seg.update(j, ai + seg.querySum(j, j));
            int k = seg.findTargetSumIndex((ans + 1) / 2);

            output[i] = String.valueOf(yArr[k - 1]);
        }
        return String.join(System.lineSeparator(), output);
    }

    static int[] getDiscrete(int[][] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int[] p : xArr) {
            set.add(p[0]);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    static int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
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
热身操领队【算法赛】

在本题中，我们始终要关注的都只是带领热身操的学生的身高。为了确定这个身高，我们需要对每种身高的学生人数进行跟踪。
为了使问题简化，我们可以将学生的身高进行压缩（离散化），因为要确定带领热身操的学生的身高，我们仅需知晓比其高和比其矮的学生人数就行。
故而，所有学生的身高都可被压缩为从 1 到 2e5（n <= 2e5）之间的数字。
接着，按照学生进入体育馆的顺序，借助线段树来更新学生的身高信息。让线段树的第 i 个叶子节点记录压缩后身高为 i 的学生的人数。要是当前学生的总数为 x，
那么带领热身操的学生将会是队伍经过排序后的第 x/2 个学生（设改学生的编号为 y）。我们可以利用线段树二分的方法从根节点开始去找到这个学生的身高，
具体的算法如下：
1、从线段树的根节点开始
2、如果左节点的值大于或等于 y，则移动到左子节点
3、如果左节点的值小于 y，则将 y 减去左子节点的值，并移动到右子节点
4、重复上述步骤，直到到达叶子节点
叶子节点的索引值即为所求学生的身高（离散化之后）
时间复杂度为 O(nlogn)。
 */
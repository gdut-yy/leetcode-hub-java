import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        int matM = mat.length;
        int[] descartesRes = mat[0];
        Arrays.sort(descartesRes);
        for (int i = 1; i < matM; i++) {
            Arrays.sort(mat[i]);
            descartesRes = descartesSum(descartesRes, mat[i], target);
        }

        // 二分找边界
        int idx = binarySearchRightBound(descartesRes, target);
        idx = (idx == -1) ? 0 : idx;

        // 若存在边界, 则答案必然出现在边界两侧
        if (idx + 1 < descartesRes.length) {
            int res1 = Math.abs(descartesRes[idx] - target);
            int res2 = Math.abs(descartesRes[idx + 1] - target);
            return Math.min(res1, res2);
        }
        // 若结果只有一个数（譬如只有 1 列）, 答案必然唯一
        return Math.abs(descartesRes[idx] - target);
    }

    private int binarySearchRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }

    /**
     * 结果去重且有序且剪枝的 "笛卡尔积"
     *
     * @param nums1  升序数组 1
     * @param nums2  升序数组 2
     * @param target 目标值
     * @return 结果去重且有序且剪枝的 "笛卡尔积"
     */
    private int[] descartesSum(int[] nums1, int[] nums2, int target) {
        // TreeSet 升序且去重
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                treeSet.add(sum);
            }
        }

        // 剪枝
        List<Integer> treeList = new ArrayList<>(treeSet);
        List<Integer> resList = new ArrayList<>();
        int idx = 0;
        for (; idx < treeList.size(); idx++) {
            // 加上全部小于或等于 target 的结果
            if (treeList.get(idx) <= target) {
                resList.add(treeList.get(idx));
            } else {
                break;
            }
        }
        // 加上一个大于 target 且最接近 target 的结果
        if (idx < treeList.size()) {
            resList.add(treeList.get(idx));
        }

        // List<Integer> 转 int[]
        int resLen = resList.size();
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
/*
1981. 最小化目标值与所选元素的差
https://leetcode-cn.com/problems/minimize-the-difference-between-target-and-chosen-elements/

第 255 场周赛 T3。

给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
返回 最小的绝对差 。
a 和 b 两数字的 绝对差 是 a - b 的绝对值。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 70
1 <= mat[i][j] <= 70
1 <= target <= 800

笛卡尔积 + 剪枝。
容易想到 时间复杂度 O(n^m) 的笛卡尔积解法。暴力解决想都不用想会超时，需要对其进行剪枝，以下两种情况可进行剪枝：
case1: 当前行与上一层结果作笛卡尔积运算后，重复的结果可以进行剪枝，否则后续结果必然也会重复。
case2: 当前行与上一层结果作笛卡尔积运算后，第二个及之后大于 target 的结果可以进行剪枝，因为后续结果越乘越大，不会比第一个大于 target 的数更接近。
最后得出一个升序数组，通过二分查找最接近 target 的值即可。
 */
import java.util.Arrays;

public class SolutionLCR172 {
    public int countTarget(int[] scores, int target) {
        if (Arrays.binarySearch(scores, target) < 0) return 0;
        return upperBound(scores, target) - lowerBound(scores, target);
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
LCR 172. 统计目标成绩的出现次数
https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。

注意返回值的差异。
相似题目: 34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
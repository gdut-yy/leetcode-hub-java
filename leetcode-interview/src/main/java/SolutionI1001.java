public class SolutionI1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int p0 = A.length - 1;
        // 双指针
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (A[p1] >= B[p2]) {
                A[p0] = A[p1];
                p1--;
            } else {
                A[p0] = B[p2];
                p2--;
            }
            p0--;
        }
        // 余下的继续补充完整
        while (p1 >= 0) {
            A[p0] = A[p1];
            p1--;
            p0--;
        }
        while (p2 >= 0) {
            A[p0] = B[p2];
            p2--;
            p0--;
        }
    }
}
/*
面试题 10.01. 合并排序的数组
https://leetcode-cn.com/problems/sorted-merge-lcci/

给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。

同: 88. 合并两个有序数组
https://leetcode-cn.com/problems/merge-sorted-array/
 */
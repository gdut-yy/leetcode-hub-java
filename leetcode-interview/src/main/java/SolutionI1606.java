import java.util.Arrays;

public class SolutionI1606 {
    public int smallestDifference(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        // 双指针
        int pa = 0;
        int pb = 0;
        long min = Long.MAX_VALUE;
        while (pa < lenA && pb < lenB) {
            min = Math.min(min, Math.abs((long) a[pa] - b[pb]));
            if (a[pa] > b[pb]) {
                pb++;
            } else {
                pa++;
            }
        }
        return (int) min;
    }
}
/*
面试题 16.06. 最小差
https://leetcode.cn/problems/smallest-difference-lcci/

给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
示例：
输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出：3，即数值对(11, 8)
提示：
1 <= a.length, b.length <= 100000
-2147483648 <= a[i], b[i] <= 2147483647
正确结果在区间 [0, 2147483647] 内

贪心 + 双指针
 */
import java.util.Arrays;

public class SolutionO11 {
    public int minArray(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}
/*
剑指 Offer 11. 旋转数组的最小数字
https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

同: 154. 寻找旋转排序数组中的最小值 II
https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 */
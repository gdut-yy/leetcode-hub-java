import java.util.Arrays;

public class SolutionO40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
/*
剑指 Offer 40. 最小的k个数
https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]

排序后取前 k 个数。
 */
import java.util.HashSet;
import java.util.Set;

public class Solution1521 {
    public int closestToTarget(int[] arr, int target) {
        Set<Integer> andSet = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();
        for (int x : arr) {
            Set<Integer> andSet2 = new HashSet<>();
            for (Integer or : andSet) {
                andSet2.add(or & x);
            }
            andSet2.add(x);
            andSet = andSet2;
            ansSet.addAll(andSet);
        }

        int min = Integer.MAX_VALUE;
        for (int ans : ansSet) {
            min = Math.min(min, Math.abs(ans - target));
        }
        return min;
    }
}
/*
1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/

Winston 构造了一个如上所示的函数 func 。他有一个整数数组 arr 和一个整数 target ，他想找到让 |func(arr, l, r) - target| 最小的 l 和 r 。
请你返回 |func(arr, l, r) - target| 的最小值。
请注意， func 的输入参数 l 和 r 需要满足 0 <= l, r < arr.length 。
提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^6
0 <= target <= 10^7

集合
相似题目: 898. 子数组按位或操作
https://leetcode.cn/problems/bitwise-ors-of-subarrays/
 */
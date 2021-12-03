import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1968 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (!checkList(numsList)) {
            Collections.shuffle(numsList);
        }
        // List<Integer> to int[]
        int[] res = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            res[i] = numsList.get(i);
        }
        return res;
    }

    private boolean checkList(List<Integer> numsList) {
        int len = numsList.size();
        for (int i = 1; i < len - 1; i++) {
            if (numsList.get(i - 1) + numsList.get(i + 1) == numsList.get(i) + numsList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
/*
1968. 构造元素不等于两相邻元素平均值的数组
https://leetcode-cn.com/problems/array-with-elements-not-equal-to-average-of-neighbors/

第 254 场周赛 T2。
洗牌算法 java Collections#shuffle(List<?> list) 满足要求的返回即可。

正规方法是先进行排序 时间复杂度 O(nlogn)
可以将数值较小的第一部分的元素放入重排数组的偶数下标（包含 0），并将数值较大的第二部分的元素放入重排数组的奇数下标。
本题的 UT 写法，可以考虑穷举所有合法答案，看是否包含；亦或者用自定义函数进行校验。
 */
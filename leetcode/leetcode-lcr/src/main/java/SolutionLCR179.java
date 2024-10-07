import java.util.HashMap;
import java.util.Map;

public class SolutionLCR179 {
    public int[] twoSum(int[] price, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < price.length; i++) {
            // 2  => 0
            // 7  => 1
            // 11 => 2
            // 15 => 3
            map.put(price[i], i);
        }
        for (int i = 0; i < price.length; i++) {
            int want = target - price[i];
            // complement => 9 - 2 = 7
            if (map.containsKey(want) && map.get(want) != i) {
                // 下标 从 1 开始计数
                return new int[]{price[i], want};
            }
        }
        return new int[]{};
    }
}
/*
LCR 179. 查找总价格为目标值的两个商品
https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/

购物车内的商品价格按照升序记录于数组 price。请在购物车中找到两个商品的价格总和刚好是 target。若存在多种情况，返回任一结果即可。
提示：
1 <= price.length <= 10^5
1 <= price[i] <= 10^6
1 <= target <= 2*10^6

注意返回对应元素还是对应元素下标。
相似题目: 167. 两数之和 II - 输入有序数组
https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
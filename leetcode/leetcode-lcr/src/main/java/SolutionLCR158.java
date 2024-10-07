import java.util.HashMap;
import java.util.Map;

public class SolutionLCR158 {
    /**
     * 哈希表法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int inventoryManagement(int[] stock) {
        int halfLen = stock.length / 2;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int v : stock) {
            if (cntMap.merge(v, 1, Integer::sum) > halfLen) {
                return v;
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int inventoryManagement2(int[] stock) {
        int count = 0;
        int candidate = 0;

        for (int num : stock) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
/*
LCR 158. 库存管理 II
https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。请返回库存表中数量大于 stock.length / 2 的商品 id。
限制：
1 <= stock.length <= 50000
给定数组为非空数组，且存在结果数字

同: 169. 多数元素
https://leetcode.cn/problems/majority-element/
 */
import java.util.Arrays;

public class SolutionLCR128 {
    public int stockManagement(int[] stock) {
        return Arrays.stream(stock).min().orElseThrow();
    }
}
/*
LCR 128. 库存管理 I
https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/description/

仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。原库存表按商品 id 升序排列。现因突发情况需要进行商品紧急调拨，管理员将这批商品 id 提前依次整理至库存表最后。请你找到并返回库存表中编号的 最小的元素 以便及时记录本次调拨。
提示：
1 <= stock.length <= 5000
-5000 <= stock[i] <= 5000

同: 154. 寻找旋转排序数组中的最小值 II
https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 */
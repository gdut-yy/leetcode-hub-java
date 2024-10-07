import java.util.Arrays;

public class SolutionLCR159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        Arrays.sort(stock);
        return Arrays.copyOfRange(stock, 0, cnt);
    }
}
/*
LCR 159. 库存管理 III
https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/description/

仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
提示：
0 <= cnt <= stock.length <= 10000
0 <= stock[i] <= 10000

排序后取前 k 个数。
 */
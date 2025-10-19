import java.util.ArrayList;
import java.util.List;

public class Solution3697 {
    public int[] decimalRepresentation(int n) {
        int base = 1;
        List<Integer> ans = new ArrayList<>();
        while (n > 0) {
            int d = n % 10;
            if (d != 0) ans.add(d * base);
            n /= 10;
            base *= 10;
        }
        return ans.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
3697. 计算十进制表示
https://leetcode.cn/problems/compute-decimal-representation/description/

第 469 场周赛 T1。

给你一个 正整数 n。
如果一个正整数可以表示为 1 到 9 的单个数字和 10 的非负整数次幂的乘积，则称这个整数是一个 10 进制分量。例如，500、30 和 7 是 10 进制分量 ，而 537、102 和 11 则不是。
请将 n 表示为若干 仅由 10 进制分量组成的和，且使用的 10 进制分量个数 最少 。
返回一个包含这些 10 进制分量 的数组，并按分量大小 降序 排列。
提示：
1 <= n <= 10^9

模拟。
时间复杂度 O(logn)。
 */
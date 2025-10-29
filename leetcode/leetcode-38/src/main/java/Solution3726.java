public class Solution3726 {
    public long removeZeros(long n) {
        String s = String.valueOf(n).replace("0", "");
        return Long.parseLong(s);
    }
}
/*
3726. 移除十进制表示中的所有零
https://leetcode.cn/problems/remove-zeros-in-decimal-representation/description/

第 473 场周赛 T1。

给你一个正整数n。
返回一个整数，该整数是将 n 的十进制表示中所有的零都移除后得到的结果。
提示：
1 <= n <= 10^15

库函数模拟。
时间复杂度 O(1)。
 */
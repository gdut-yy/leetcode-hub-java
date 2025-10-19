import java.util.Arrays;

public class Solution3536 {
    public int maxProduct(int n) {
        char[] a = String.valueOf(n).toCharArray();
        Arrays.sort(a);
        int len = a.length;
        return (a[len - 1] - '0') * (a[len - 2] - '0');
    }
}
/*
3536. 两个数字的最大乘积
https://leetcode.cn/problems/maximum-product-of-two-digits/description/

第 448 场周赛 T1。

给定一个正整数 n。
返回 任意两位数字 相乘所得的 最大 乘积。
注意：如果某个数字在 n 中出现多次，你可以多次使用该数字。
提示：
10 <= n <= 10^9

中国时间 2025-05-04 周日 10:30
广州·中肿。五四青年节。
贪心。
 */
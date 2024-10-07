public class SolutionLCR135 {
    public int[] countNumbers(int cnt) {
        int max = (int) (Math.pow(10, cnt) - 1);
        int[] ans = new int[max];
        for (int i = 0; i < max; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
/*
LCR 135. 报数
https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/description/

实现一个十进制数字报数程序，请按照数字从小到大的顺序返回一个整数数列，该数列从数字 1 开始，到最大的正整数 cnt 位数字结束。
示例 1:
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 */
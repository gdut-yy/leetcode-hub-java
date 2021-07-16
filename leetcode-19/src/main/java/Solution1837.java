public class Solution1837 {
    public int sumBase(int n, int k) {
        int cnt = 0;
        while (n > 0) {
            cnt += n % k;
            n /= k;
        }
        return cnt;
    }
}
/*
1837. K 进制表示下的各位数字总和
https://leetcode-cn.com/problems/sum-of-digits-in-base-k/

周赛签到题。进制转换
 */
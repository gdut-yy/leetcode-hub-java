public class Solution1952 {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt == 3;
    }
}
/*
1952. 三除数
https://leetcode-cn.com/problems/three-divisors/

第 252 场周赛 T1。
n <= 10^4
直接根据题意进行模拟即可。
 */
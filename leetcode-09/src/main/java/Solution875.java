public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        // 左边界二分
        // 1 <= piles.length <= 10^4
        // piles.length <= H <= 10^9
        int left = 1;
        int right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMinEatingSpeed(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMinEatingSpeed(int[] piles, int h, int k) {
        int cnt = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                cnt += pile / k;
            } else {
                cnt += pile / k + 1;
            }
        }
        return cnt <= h;
    }
}
/*
875. 爱吃香蕉的珂珂
https://leetcode-cn.com/problems/koko-eating-bananas/

第 94 场周赛 T3。
左边界二分
 */
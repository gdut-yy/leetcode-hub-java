public class Solution1891 {
    public int maxLength(int[] ribbons, int k) {
        int left = 1;
        int right = 100001;
        // 右边界二分
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(ribbons, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private boolean check(int[] ribbons, int k, int len) {
        int cnt = 0;
        for (int ribbon : ribbons) {
            cnt += ribbon / len;
        }
        return cnt >= k;
    }
}
/*
$1891. 割绳子
https://leetcode-cn.com/problems/cutting-ribbons/

给定一个整数数组 ribbons 和一个整数 k，数组每项 ribbons[i] 表示第 i 条绳子的长度。对于每条绳子，
你可以将任意切割成一系列长度为正整数的部分，或者选择不进行切割。

例如，如果给你一条长度为 4 的绳子，你可以：
保持绳子的长度为 4 不变；
切割成一条长度为 3 和一条长度为 1 的绳子；
切割成两条长度为 2 的绳子；
切割成一条长度为 2 和两条长度为 1 的绳子；
切割成四条长度为 1 的绳子。
你的任务是最终得到 k 条完全一样的绳子，他们的长度均为相同的正整数。如果绳子切割后有剩余，你可以直接舍弃掉多余的部分。

对于这 k 根绳子，返回你能得到的绳子最大长度；如果你无法得到 k 根相同长度的绳子，返回 0。

二分。
 */
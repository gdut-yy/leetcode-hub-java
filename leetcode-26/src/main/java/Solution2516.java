public class Solution2516 {
    private int totA;
    private int totB;
    private int totC;

    public int takeCharacters(String s, int k) {
        totA = 0;
        totB = 0;
        totC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                totA++;
            } else if (ch == 'b') {
                totB++;
            } else {
                totC++;
            }
        }
        if (totA < k || totB < k || totC < k) {
            return -1;
        }

        int len = s.length();
        // 最少取 3k 个，最多全取
        int left = k * 3;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(s, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // mid: 需要的分钟数（取走字符个数）
    private boolean checkMid(String s, int k, int mid) {
        // 剩余 m 个
        int m = s.length() - mid;
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        // 前 m 个
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == 'a') {
                cntA++;
            } else if (s.charAt(i) == 'b') {
                cntB++;
            } else {
                cntC++;
            }
        }
        if (totA - cntA >= k && totB - cntB >= k && totC - cntC >= k) {
            return true;
        }

        for (int i = m; i < s.length(); i++) {
            char addCh = s.charAt(i);
            if (addCh == 'a') {
                cntA++;
            } else if (addCh == 'b') {
                cntB++;
            } else {
                cntC++;
            }

            char rmCh = s.charAt(i - m);
            if (rmCh == 'a') {
                cntA--;
            } else if (rmCh == 'b') {
                cntB--;
            } else {
                cntC--;
            }
            if (totA - cntA >= k && totB - cntB >= k && totC - cntC >= k) {
                return true;
            }
        }
        return false;
    }
}
/*
2516. 每种字符至少取 K 个
https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/

第 325 场周赛 T2。

给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
提示：
1 <= s.length <= 10^5
s 仅由字母 'a'、'b'、'c' 组成
0 <= k <= s.length

二分查找。思路类似 1423
相似题目: 1423. 可获得的最大点数
https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 */
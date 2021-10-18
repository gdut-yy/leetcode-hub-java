public class Solution2027 {
    public int minimumMoves(String s) {
        int res = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) != 'X') {
                idx++;
            } else {
                res++;
                idx += 3;
            }
        }
        return res;
    }
}
/*
2027. 转换字符串的最少操作次数
https://leetcode-cn.com/problems/minimum-moves-to-convert-string/

第 261 场周赛 T1。
固定大小的滑动窗口。
 */
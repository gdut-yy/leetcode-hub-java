public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        int cnt = 0;
        String curWork = word;
        while (sequence.contains(curWork)) {
            cnt++;
            curWork += word;
        }
        return cnt;
    }
}
/*
1668. 最大重复子字符串
https://leetcode-cn.com/problems/maximum-repeating-substring/

周赛签到题。使用 String.contains() 判断是否为子串。
 */
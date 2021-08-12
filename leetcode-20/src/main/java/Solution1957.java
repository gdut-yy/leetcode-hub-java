public class Solution1957 {
    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        int lastCh = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch == lastCh) {
                cnt++;
            } else {
                lastCh = ch;
                cnt = 1;
            }
            if (cnt < 3) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
/*
1957. 删除字符使字符串变好
https://leetcode-cn.com/contest/biweekly-contest-58/

第 58 场双周赛 T1。
直接模拟即可。
 */
public class Solution1945 {
    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            stringBuilder.append(ch - 'a' + 1);
        }
        s = stringBuilder.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ch : s.toCharArray()) {
                int cur = ch - '0';
                sum += cur;
            }
            s = String.valueOf(sum);
        }
        return Integer.parseInt(s);
    }
}
/*
1945. 字符串转化后的各位数字之和
https://leetcode-cn.com/problems/sum-of-digits-of-string-after-convert/

第 251 场周赛 T1。
根据题意进行模拟即可。
 */
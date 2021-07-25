public class Solution848 {
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        // 反向前缀和
        long[] rePreSum = new long[len];
        rePreSum[len - 1] = shifts[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rePreSum[i] = shifts[i] + rePreSum[i + 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = (char) ((s.charAt(i) - 'a' + rePreSum[i]) % 26 + 'a');
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
/*
848. 字母移位
https://leetcode-cn.com/problems/shifting-letters/

第 88 场周赛 T1。
最后的字母移位次数最少，而最前面的字母却是所有次数之和。
类前缀和，可以构造出反向前缀和。根据题意进行模拟即可。
注意 int[] 的前缀和数组会溢出，需用 long[]
 */
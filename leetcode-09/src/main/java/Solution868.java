public class Solution868 {
    public int binaryGap(int n) {
        int maxLen = 0;
        int lastIdx = -1;
        // int 32bit
        for (int i = 0; i < 32; i++) {
            // >> i 右移 i 位
            // & 1 二进制为 1
            if (((n >> i) & 1) == 1) {
                if (lastIdx >= 0) {
                    maxLen = Math.max(maxLen, i - lastIdx);
                }
                lastIdx = i;
            }
        }
        return maxLen;
    }
}
/*
868. 二进制间距
https://leetcode-cn.com/problems/binary-gap/

第 93 场周赛 T1。
((n >> i) & 1) == 1
等价于
((n >> i) % 2) == 1
 */
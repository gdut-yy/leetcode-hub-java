public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int lenM = strs.length;
        int lenN = strs[0].length();
        int res = 0;
        for (int i = 0; i < lenN; i++) {
            for (int j = 1; j < lenM; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    // 剪枝
                    break;
                }
            }
        }
        return res;
    }
}
/*
944. 删列造序
https://leetcode-cn.com/problems/delete-columns-to-make-sorted/

第 111 场周赛 T2。
根据题意模拟即可。
 */
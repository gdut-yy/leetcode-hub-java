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
https://leetcode.cn/problems/delete-columns-to-make-sorted/

第 111 场周赛 T2。

给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：

根据题意模拟即可。
 */
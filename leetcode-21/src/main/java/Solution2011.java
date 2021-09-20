public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
/*
2011. 执行操作后的变量值
https://leetcode-cn.com/problems/final-value-of-variable-after-performing-operations/

第 259 场周赛 T1。
 */
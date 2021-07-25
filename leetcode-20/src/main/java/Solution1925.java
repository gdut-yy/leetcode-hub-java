public class Solution1925 {
    public int countTriples(int n) {
        int cnt = 0;
        // 1 <= n <= 250
        for (int c = 1; c <= n; c++) {
            for (int a = 1; a < c; a++) {
                int bb = c * c - a * a;
                // Math.sqrt 取整后如果还能平方等于原数，证明满足等式
                int b = (int) Math.sqrt(bb);
                if (b * b == bb) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1925. 统计平方和三元组的数目
https://leetcode-cn.com/problems/count-square-sum-triples/

第 56 场双周赛 T1。
n <= 250，直接枚举即可。
 */
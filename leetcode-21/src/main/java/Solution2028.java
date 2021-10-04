import java.util.Arrays;

public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumRolls = Arrays.stream(rolls).sum();
        int mAndN = m + n;
        int total = mean * mAndN;
        int sumNs = total - sumRolls;
        // 注意边界
        if (sumNs >= n && sumNs <= n * 6) {
            int average = sumNs / n;
            int[] res = new int[n];
            Arrays.fill(res, average);
            int diff = sumNs - average * n;
            for (int i = 0; i < diff; i++) {
                res[i]++;
            }
            return res;
        }
        return new int[]{};
    }
}
/*
2028. 找出缺失的观测数据
https://leetcode-cn.com/problems/find-missing-observations/

模拟题。
 */
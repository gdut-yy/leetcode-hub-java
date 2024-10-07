public class SolutionLCR191 {
    public int[] statisticalResult(int[] arrayA) {
        int n = arrayA.length;
        if (n == 0) return new int[0];

        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * arrayA[i - 1];
        }
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * arrayA[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
/*
LCR 191. 按规则计算统计结果
https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/

为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
提示：
所有元素乘积之和不会溢出 32 位整数
arrayA.length <= 100000

前后缀分解。
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 238. 除自身以外数组的乘积
https://leetcode.cn/problems/product-of-array-except-self/
 */
public class SolutionO66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        leftProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            leftProduct[i] = leftProduct[i - 1] * a[i - 1];
        }
        rightProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * a[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }
        return res;
    }
}
/*
剑指 Offer 66. 构建乘积数组
https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/

给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]

类似前缀和思想。
leftProduct[i] 表示 [0,i-1] 项乘积
rightProduct[i] 表示 [i+1,n-1] 项乘积

时间复杂度 O(n)
空间复杂度 O(n)

相似题目: 238. 除自身以外数组的乘积
https://leetcode.cn/problems/product-of-array-except-self/
 */
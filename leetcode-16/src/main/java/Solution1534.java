public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((Math.abs(arr[i] - arr[j]) <= a)) {
                    cnt = getCnt(arr, b, c, len, cnt, i, j);
                }
            }
        }
        return cnt;
    }

    private int getCnt(int[] arr, int b, int c, int len, int cnt, int i, int j) {
        for (int k = j + 1; k < len; k++) {
            if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1534. 统计好三元组
https://leetcode-cn.com/problems/count-good-triplets/

第 200 场周赛 T1。
暴力枚举即可。时间复杂度 O(n^3)
可以进行剪枝，时间复杂度 O(n^2)
抽取方法避免嵌套过深。
 */
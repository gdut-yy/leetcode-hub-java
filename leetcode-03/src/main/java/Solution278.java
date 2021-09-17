public class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // UT
    public Solution278(int bad) {
        super(bad);
    }
}
/*
278. 第一个错误的版本
https://leetcode-cn.com/problems/first-bad-version/

由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
找出导致之后所有版本出错的第一个错误的版本。

显然 左边界二分。
注意一个小 trick:
因为: 1 <= bad <= n <= 2^31 - 1
因此直接 int mid = (left + right) / 2; 可能会在相加步骤溢出
可以优化为 int mid = left + (right - left) / 2;
 */
public class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 左边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
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

class VersionControl {
    int bad;

    public VersionControl(int bad) {
        this.bad = bad;
    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}
/*
278. 第一个错误的版本
https://leetcode-cn.com/problems/first-bad-version/

由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
找出导致之后所有版本出错的第一个错误的版本。

左边界二分。
 */
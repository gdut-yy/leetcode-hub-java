public class SolutionLCR173 {
    public int takeAttendance(int[] records) {
        // 左边界二分
        int left = 0;
        int right = records.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] != mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
LCR 173. 点名
https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/

某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
提示：
1 <= records.length <= 10000

左边界二分。找第一个 !=
nums[0]==0, nums[1]==1, ..., nums[i]==i, nums[i+1]!=i+1, ..., nums[n]==n
 */
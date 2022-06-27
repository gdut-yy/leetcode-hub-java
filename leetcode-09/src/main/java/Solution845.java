public class Solution845 {
    public int longestMountain(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 0;
        }
        // 差分数组
        int[] diff = new int[len];
        diff[0] = arr[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        // 反向差分数组
        int[] reDiff = new int[len];
        reDiff[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            reDiff[i] = arr[i] - arr[i + 1];
        }

        int maxLen = 0;
        // 找到山顶 再往两边扩散
        for (int top = 1; top < len - 1; top++) {
            boolean isTop = (diff[top] > 0 && diff[top + 1] < 0)
                    && (reDiff[top] > 0 && reDiff[top - 1] < 0);
            if (isTop) {
                int left = top - 1;
                int right = top + 1;
                // 右指针右移至山底
                while (right < len && diff[right] < 0) {
                    right++;
                }
                // 左指针左移至山底
                while (left >= 0 && reDiff[left] < 0) {
                    left--;
                }
                int curLen = right - left - 1;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
/*
845. 数组中的最长山脉
https://leetcode.cn/problems/longest-mountain-in-array/

第 87 场周赛 T2。

把符合下列属性的数组 arr 称为 山脉数组 ：
- arr.length >= 3
- 存在下标 i（0 < i < arr.length - 1），满足
  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。

差分数组思想，假设有用例 3 1 2 1 3
差分数组是 3 -2 1 -1 2，不难看出从下标 1 开始（山顶两侧必须有值），1 -1 一正一负，正数对应的下标即为山顶
同理，理解差分数组思想，不难构造出反向差分数组 2 -1 1 -2 3，同理 -1 1 一负一正，正数对应的下标为山顶
然后根据双指针思想，由中心向两侧扩散，统计最值即可
时间复杂度 O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 记录每个 '|' 下标
        List<Integer> candleIdxList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                candleIdxList.add(i);
            }
        }
        int[] candleIdxArr = candleIdxList.stream().mapToInt(i -> i).toArray();

        // 二分
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // 二分找左右 '|' 边界
            int leftIdx = binarySearchLeftBound(candleIdxArr, left);
            int rightIdx = binarySearchRightBound(candleIdxArr, right);
            if (leftIdx < rightIdx) {
                int leftVal = candleIdxArr[leftIdx];
                int rightVal = candleIdxArr[rightIdx];
                // 两个 '|' 间隔距离
                int cntDistance = rightVal - leftVal - 1;
                // 两个 '|' 中 '|' 的数量
                int cntCandle = rightIdx - leftIdx - 1;
                res[i] = cntDistance - cntCandle;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
2055. 蜡烛之间的盘子
https://leetcode-cn.com/problems/plates-between-candles/

第 64 场双周赛 T3。
区间统计（数组不可变）
使用索引数组进行加速即可。
 */
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
https://leetcode.cn/problems/plates-between-candles/

第 64 场双周赛 T3。

给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，
子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。

区间统计（数组不可变）
使用索引数组进行加速即可。
 */
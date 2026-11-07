public class Solution4095 {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) {
            if (x > max) max = x;
        }
        int[] count = new int[max + 1];
        for (int x : nums) {
            count[x]++;
        }
        int[][] occurrences = new int[max + 1][];
        for (int v = 1; v <= max; v++) {
            if (count[v] > 0) {
                occurrences[v] = new int[count[v]];
            }
        }
        int[] rank = new int[n];
        int[] fill = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            rank[i] = fill[v];
            occurrences[v][fill[v]++] = i;
        }
        int[] next = new int[n + 1];
        int[] prev = new int[n + 1];
        int head = n;
        next[head] = head;
        prev[head] = head;
        int ans = 0;
        for (int l = n - 1; l >= 0; l--) {
            int v = nums[l];
            int idx = rank[l];
            int[] pos = occurrences[v];
            if (idx + 1 < pos.length) {
                int removed = pos[idx + 1];
                next[prev[removed]] = next[removed];
                prev[next[removed]] = prev[removed];
            }
            int oldHead = next[head];
            next[head] = l;
            prev[l] = head;
            next[l] = oldHead;
            prev[oldHead] = l;
            int low = -1;
            int high = n - 1;
            int p = l;
            int k = 1;
            while (p != head) {
                v = nums[p];
                idx = rank[p];
                pos = occurrences[v];
                int occurrenceIndex = idx + k - 1;
                if (occurrenceIndex >= pos.length) {
                    break;
                }
                int needLast = pos[occurrenceIndex];
                int nextOccurrence = occurrenceIndex + 1 < pos.length
                        ? pos[occurrenceIndex + 1]
                        : n;
                if (needLast > low) low = needLast;
                if (nextOccurrence - 1 < high) high = nextOccurrence - 1;
                if (low > high) break;
                int r = l + k * (k + 1) / 2 - 1;
                if (r > high) break;
                if (r >= low && next[p] > r) {
                    ans++;
                }
                p = next[p];
                k++;
            }
        }
        return ans;
    }
}
/*
4095. 统计频次阶梯子数组的数目 II
https://leetcode.cn/problems/count-frequency-staircase-subarrays-ii/description/

第 525 场周赛 T4。

给你一个整数数组 nums。
考虑一个子数组中的所有不同值，并按它们首次出现的顺序排列。
如果其中有 k 个不同值，且第一个不同值恰好出现一次，第二个不同值恰好出现两次，以此类推，第 k 个不同值恰好出现 k 次，则称该子数组为频次阶梯。
即，按首次出现的顺序排列的各个不同值，其出现次数必须恰好为 1, 2, 3, ..., k。
返回 nums 中频次阶梯子数组的数量。
子数组是数组中一段连续且非空的元素序列。
一个值在子数组中的频次，是指它在该子数组中出现的次数。
示例 1：
输入： nums = [5,8,8,2,2,2]
输出： 9
示例 2：
输入： nums = [6,6,9,9]
输出： 5
示例 3：
输入： nums = [2,3,4,4,3,4]
输出： 8
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^5

暴力枚举。
 */
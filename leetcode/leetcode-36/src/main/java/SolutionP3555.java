import java.util.*;

public class SolutionP3555 {
    static class V1 {
        public int[] minSubarraySort(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                ans[i] = findUnsortedSubarray(nums, i, i + k - 1);
            }
            return ans;
        }

        // solution581
        private int findUnsortedSubarray(int[] nums, int start, int end) {
            int n = end - start + 1;
            int[] sorted = new int[n];
            System.arraycopy(nums, start, sorted, 0, n);
            Arrays.sort(sorted);
            int l = 0, r = n - 1;
            while (l <= r && nums[l + start] == sorted[l]) l++;
            while (l <= r && nums[r + start] == sorted[r]) r--;
            return r - l + 1;
        }
    }

    static class V2 {
        record Pair(int val, int idx) {
        }

        public int[] minSubarraySort(int[] nums, int k) {
            int n = nums.length;
            if (k == 1) return new int[n];

            int preEnd = 1;
            Deque<Pair> unOrderMinStack = new ArrayDeque<>();
            Deque<Pair> unOrderMaxStack = new ArrayDeque<>();
            int postStart = 1;
            List<Integer> result = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (i - k >= 0) {
                    // 移除最左边的元素 (i-k)
                    if (!unOrderMaxStack.isEmpty() && i - k == unOrderMaxStack.getFirst().idx) {
                        unOrderMaxStack.removeFirst();
                        if (!unOrderMaxStack.isEmpty()) {
                            while (postStart - 1 >= 0 && nums[postStart - 1] >= unOrderMaxStack.getFirst().val) {
                                postStart--;
                            }
                        }
                    }
                    if (!unOrderMinStack.isEmpty() && i - k + 1 == unOrderMinStack.getFirst().idx) {
                        unOrderMinStack.removeFirst();
                        preEnd = i - k + 2;
                        if (unOrderMinStack.isEmpty()) {
                            preEnd = i;
                            postStart = i;
                        } else {
                            while (preEnd < i && nums[preEnd] <= unOrderMinStack.getFirst().val) {
                                preEnd++;
                            }
                        }
                    } else {
                        preEnd = Math.max(preEnd, i - k + 1);
                    }
                }
                if (nums[i] < nums[i - 1]) {
                    // 发现逆序对
                    postStart = i + 1;
                    while (!unOrderMinStack.isEmpty() && unOrderMinStack.getLast().val > nums[i]) {
                        unOrderMinStack.removeLast();
                    }
                    unOrderMinStack.addLast(new Pair(nums[i], i));
                    while (!unOrderMaxStack.isEmpty() && unOrderMaxStack.getLast().val < nums[i - 1]) {
                        unOrderMaxStack.removeLast();
                    }
                    unOrderMaxStack.addLast(new Pair(nums[i - 1], i - 1));
                    int limit = Math.max(0, i + 1 - k);
                    while (preEnd > limit && nums[preEnd - 1] > unOrderMinStack.getFirst().val) {
                        preEnd--;
                    }
                } else if (unOrderMaxStack.isEmpty()) {
                    preEnd = i + 1;
                    postStart = i + 1;
                } else if (nums[i] < unOrderMaxStack.getFirst().val) {
                    postStart = i + 1;
                }
                if (i >= k - 1) {
                    result.add(k - (preEnd - (i - k + 1)) - (i + 1 - postStart));
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
/*
$3555. 排序每个滑动窗口中最小的子数组
https://leetcode.cn/problems/smallest-subarray-to-sort-in-every-sliding-window/description/

给定一个整数数组 nums 和一个整数 k。
对于每个长度为 k 的连续 子数组，确定必须排序的连续段的最小长度，以便整个窗口成为 非递减 的；如果窗口已经排序，则其所需长度为零。
返回一个长度为 n − k + 1 的数组，其中每个元素对应其窗口的答案。
提示：
1 <= nums.length <= 1000
1 <= k <= nums.length
1 <= nums[i] <= 10^6

O(n)单调队列解法 https://leetcode.cn/problems/smallest-subarray-to-sort-in-every-sliding-window/
相似题目: 581. 最短无序连续子数组
https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/
 */
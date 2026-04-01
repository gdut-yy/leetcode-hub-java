import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3886 {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        int ans = 0;
        for (int k : factors) {
            boolean valid = true;
            int blocks = n / k;
            for (int b = 0; b < blocks; b++) {
                int l = b * k;
                int r = l + k - 1;

                int cnt = 0;
                int dropPos = -1;
                for (int j = l; j < r; j++) {
                    if (nums[j] > nums[j + 1]) {
                        cnt++;
                        dropPos = j;
                        if (cnt > 1) break;
                    }
                }
                if (cnt <= 1) {
                    if (nums[r] > nums[l]) {
                        cnt++;
                        dropPos = r;
                        if (cnt > 1) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (cnt > 1) {
                    valid = false;
                    break;
                }
                if (cnt == 0) {
                    for (int j = l; j <= r; j++) {
                        if (nums[j] != sorted[j]) {
                            valid = false;
                            break;
                        }
                    }
                } else {
                    int idx = dropPos + 1;
                    if (idx > r) idx = l;
                    for (int j = l; j <= r; j++) {
                        if (sorted[j] != nums[idx]) {
                            valid = false;
                            break;
                        }
                        idx++;
                        if (idx > r) idx = l;
                    }
                }
                if (!valid) break;
            }
            if (valid) ans += k;
        }
        return ans;
    }
}
/*
3886. 可排序整数求和
https://leetcode.cn/problems/sum-of-sortable-integers/description/

第 495 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
如果一个整数 k 满足以下条件，则称其为 可排序整数：k 是 n 的 因数，且可以通过依次执行以下操作将 nums 排序为 非递减顺序：
- 将 nums 划分为长度为 k 的 连续子数组。
- 独立地对每个子数组进行循环移动（左移或右移任意次数）。
返回所有可能的可排序整数 k 的和。
子数组 是数组中的一个连续、非空元素序列。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^5

预处理 + 分类讨论。
https://chat.deepseek.com/a/chat/s/78a3566c-3201-480a-9ad3-3f622af092ab
 */
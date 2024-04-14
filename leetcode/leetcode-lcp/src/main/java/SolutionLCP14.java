import java.util.Arrays;

public class SolutionLCP14 {
    // https://leetcode.cn/problems/qie-fen-shu-zu/solution/qie-fen-shu-zu-zhi-shu-shai-dp-by-leetcode-solutio/
    public int splitArray(int[] nums) {
        int n = nums.length;
        int m = Arrays.stream(nums).max().orElseThrow();

        int[] min_prime = new int[m + 1];
        int[] prime = new int[m + 1];
        int[] g = new int[m + 1];
        for (int i = 2; i <= m; i++) {
            if (min_prime[i] == 0) {
                prime[++prime[0]] = i;
                min_prime[i] = i;
            }
            for (int j = 1; j <= prime[0]; j++) {
                if (i > m / prime[j]) break;
                min_prime[i * prime[j]] = prime[j];
                if (i % prime[j] == 0) break;
            }
        }

        for (int j = 1; j <= prime[0]; j++) {
            g[prime[j]] = n;
        }
        for (int x = nums[0]; x > 1; x /= min_prime[x]) {
            g[min_prime[x]] = 0;
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = i + 1;
            for (int x = nums[i]; x > 1; x /= min_prime[x]) {
                ans = Math.min(ans, g[min_prime[x]] + 1);
            }
            if (i == n - 1) break;
            for (int x = nums[i + 1]; x > 1; x /= min_prime[x]) {
                g[min_prime[x]] = Math.min(g[min_prime[x]], ans);
            }
        }
        return ans;
    }
}
/*
LCP 14. 切分数组
https://leetcode.cn/problems/qie-fen-shu-zu/description/

给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。为了减少他的工作量，请求出最少可以切成多少个子数组。
限制：
1 <= nums.length <= 10^5
2 <= nums[i] <= 10^6

素数筛 + 动态规划。
时间复杂度 O(nlogm  + m)。
 */
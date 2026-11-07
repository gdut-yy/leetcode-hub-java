import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4081 {
    private static final int MX = 1001;
    private static final boolean[] isPrime = new boolean[MX];
    private static final List<Integer> primes = new ArrayList<>();

    static {
        Arrays.fill(isPrime, true);
        for (int i = 2; i < MX; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j < MX; j += i) {
                    isPrime[(int) j] = false; // j 是质数 i 的倍数
                }
            }
        }
    }

    public List<Integer> maxPrimeSubset(int n, int s) {
        int m = Collections.binarySearch(primes, n + 1);
        if (m < 0) m = ~m; // 见 Collections.binarySearch 源码
        int[][] f = new int[m + 1][s + 1];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        f[m][0] = 0;
        // 倒着 DP，这样可以正序输出方案，且保证越靠前的质数越小
        for (int i = m - 1; i >= 0; i--) {
            int x = primes.get(i);
            for (int j = 0; j <= s; j++) {
                if (j < x) {
                    f[i][j] = f[i + 1][j];
                } else {
                    f[i][j] = Math.min(f[i + 1][j], f[i + 1][j - x] + 1);
                }
            }
        }
        int j = s;
        while (j > 0 && f[0][j] == Integer.MAX_VALUE / 2) {
            j--;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; j > 0; i++) {
            int x = primes.get(i);
            // 靠前的质数越小越好，f[i+1][j-x]+1 = f[i+1][j] 的时候要选
            if (f[i + 1][j - x] + 1 <= f[i + 1][j]) {
                ans.add(x);
                j -= x;
            }
        }
        return ans;
    }
}
/*
4081. 选择质数子集 II
https://leetcode.cn/problems/prime-subset-selection-ii/description/

第 523 场周赛 T4。

给你两个整数 n 和 s。
考虑所有小于等于 n 的 质数 。从这些质数中选择一个 子集 ，并满足以下条件：
- 每个质数 最多只能选择一次。
- 在所选质数的 总和 不超过 s 的前提下，使总和 尽可能大。
- 在总和达到 最大值 的所有子集中，选择包含质数数量 最少 的子集。
- 如果仍有多个子集满足条件，则将各子集中的元素按递增顺序排列，并选择 字典序最小 的数组。
返回一个包含所选质数的整数数组，并按 递增 顺序排列。如果不存在合法的 非空 子集，则返回空数组。
质数 是大于 1 且只有 1 和它本身两个因数的自然数。
子集 是从一个集合中选择零个或多个不同元素得到的集合。
如果数组 a 和数组 b 在第一个不同的位置上，a 中的元素更小，则称 a 的 字典序更小。如果在较短数组的长度范围内所有元素都相同，则较短的数组字典序更小。
示例 1：
输入： n = 7, s = 20
输出： [2, 3, 5, 7]
示例 2：
输入： n = 15, s = 18
输出： [5,13]
示例 3：
输入： n = 5, s = 1
输出： []
提示：
1 <= n <= 1000
1 <= s <= 1000

0-1 背包 + 输出具体方案
https://leetcode.cn/problems/prime-subset-selection-ii/solutions/4041612/0-1-bei-bao-shu-chu-ju-ti-fang-an-python-x6g1/
 */
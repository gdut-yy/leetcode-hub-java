import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    // 迭代
    static class V1 {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            int num = 1;
            // 保证最多不超过 n 个数
            for (int i = 0; i < n; i++) {
                ans.add(num);
                if (num * 10 <= n) {
                    num *= 10;
                } else {
                    while (num % 10 == 9 || num + 1 > n) {
                        num /= 10;
                    }
                    num++;
                }
            }
            return ans;
        }
    }

    // 递归
    static class V2 {
        int n;
        List<Integer> ans;

        public List<Integer> lexicalOrder(int n) {
            this.n = n;
            ans = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                dfs(i);
            }
            return ans;
        }

        private void dfs(int cur) {
            if (cur > n) return;
            ans.add(cur);
            for (int i = 0; i <= 9; i++) {
                dfs(cur * 10 + i);
            }
        }
    }
}
/*
386. 字典序排数
https://leetcode.cn/problems/lexicographical-numbers/

给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
提示：
1 <= n <= 5 * 10^4

迭代 / 递归。
时间复杂度 O(n)。
 */
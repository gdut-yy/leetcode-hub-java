package lq240504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240504T6 {
    static int n, x;
    static int[] nums1;
    static int m, y;
    static int[] nums2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        y = scanner.nextInt();
        nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int[] cost;
    static List<Integer>[] tmp;

    private static String solve() {
        cost = new int[1 << 17];
        for (int i = 0; i < 1 << 17; i++) {
            for (int j = 0; j < 17; j++) {
                if ((i >> j & 1) == 1) {
                    cost[i] = cost[i ^ (1 << j)] + j + 1;
                }
            }
        }

        tmp = new ArrayList[17];
        Arrays.setAll(tmp, e -> new ArrayList<>());
        for (int j = 0; j < 17; j++) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < 1 << 17; i++) {
                if (cost[i] <= j) {
                    cur.add(i);
                }
            }

            for (int v1 : cur) {
                boolean flag = false;
                for (int v2 : cur) {
                    if (v1 == (v1 & v2) && v1 != v2) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) tmp[j].add(v1);
            }
        }

        int a = f(nums1, x);
        int b = f(nums2, y);
        if (a > b) {
            return "Clrlss";
        } else if (a < b) {
            return "Yaya";
        } else {
            return "Draw";
        }
    }

    static int f(int[] nums, int val) {
        int[] dp = new int[1 << 16];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = (1 << 16) - 1; i > -1; i--) {
                if (dp[i] != 0) {
                    for (Integer x : tmp[num]) {
                        dp[i | x] = 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 1 << 16; i++) {
            if (dp[i] != 0) {
                int res = 0;
                int cur = val;
                for (int j = 0; j < 16; j++) {
                    if ((i >> j & 1) == 1) {
                        res++;
                    } else if (cur >= j + 1) {
                        cur -= j + 1;
                        res++;
                    }
                }
                ans = Math.max(ans, res + ((int) Math.sqrt(cur * 8 + 33 * 33) - 33) / 2);
            }
        }
        return ans;
    }
}
/*
Yaya 与游戏【算法赛】

首先我们先研究策略。
有一个比较明显的结论是：双方都会在 1,2,3,...,res 中的每个商店都购买一张彩票，而且仅购买一张，直到剩下的资金不够在第 res+1 个商店购买彩票。
这个想法其实比较容易证明。首先，假如一方在某一个商店中购买两张，那么这两张彩票一定不能导致胜利，而且与只购买一张相比，对另外一方的限制效果是完全一样的。因此，一方只会最多在同一个商店中购买一张彩票。
其次，一方按照 1,2,3,...,res 的顺序购买彩票，那么对于另外一方而言，不论在决策上采取什么变化，都一定不会优于使用相同的决策，因为假如在中间的某个编号的商店中不购买彩票，那么都将导致对方获胜。
---
在经过以上分析之后，我们发现题目转化为：双方各有若干个背包，给出每个背包的容量，现在双方要在背包中装入体积以 1,2,3,... 的递增的物品，哪一方装的物品更多，哪一方就获胜。
在此基础上，我们可以发现，除了 X,Y 比较大之外，剩下的 ai 与 bi 都非常小。这暗示我们可以用状压 DP 来进行求解。考虑时间因素，先预处理出每个人能购买的彩票集合，再枚举所有集合进行合并
时间复杂度为 O((n+m) * 2^16)，其中预处理每个金额可以购买的彩票集合的时间复杂度为 O(Ʃcnti * 2^16)，cnti 为第 i 个人可行的购买彩票的集合。
@小羊肖恩Yawn_Sean
 */
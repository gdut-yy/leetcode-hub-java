package p1860;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1860C {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        int mn = n + 1, mnWin = n + 1;
        for (int x : p) {
            if (mn < x && x < mnWin) {
                ans += 1;
                mnWin = x;
            }
            mn = Math.min(mn, x);
        }
        return String.valueOf(ans);
    }
}
/*
C. Game on Permutation
https://codeforces.com/contest/1860/problem/C

题目大意：
爱丽丝和鲍勃在玩游戏。它们有一个大小为 n 的排列 p(大小为 n 的排列是一个大小为 n 的数组，其中从 1 到 n 的每个元素只出现一次)。它们还有一个芯片，可以放在排列中的任何元素上。
爱丽丝和鲍勃轮流走:爱丽丝走第一步，然后鲍勃走第二步，然后爱丽丝走第三步，以此类推。在第一步中，爱丽丝选择排列中的任何元素并将筹码放在该元素上。在接下来的每一次移动中，当前玩家必须将筹码移动到任何同时在左侧且严格小于当前元素的元素(即。如果芯片位于第 I 个元素上，则如果 j< I 且 pj<pi)，它可以移动到第 j 个元素上。如果一个玩家不能移动(根据游戏规则，移动筹码是不可能的)，那么这个玩家就赢了游戏。
假设如果满足以下条件，则排列中的第 i 个元素是幸运的:
- 如果 Alice 在她的第一步棋中把筹码放在第 i 个元素上，那么不管 Bob 怎么走，她都能赢。她有一个制胜策略)。
你必须计算这个排列中幸运元素的个数。

https://codeforces.com/blog/entry/119504
对于每个位置 i，让我们确定它的状态:对于将筹码移到该位置的玩家来说，这个位置是赢还是输。由于玩家只能将筹码移动到索引较小的位置，所以我们可以按照从 1 到 n 的顺序确定位置的状态。你可以把它看作是动态规划。
如果没有 j<i 和 pj<pi，那么这个位置是一个输的位置，因为另一个玩家不能移动，这意味着他们赢了(而把筹码放在那个位置的玩家输了)。否则，其他玩家可以采取行动。我们已经知道如果玩家在之前的所有位置都放一个筹码，他们是否会赢。如果存在一个可以移动的位置 j，并且 j 是一个获胜的位置，那么 i 就是一个失败的位置(因为我们的对手将移动到那里)。否则，它就是一个赢的位置。因此，我们有一个时间复杂度为 O(n2)的解，对于每个位置 i，我们需要迭代所有可能的转换 j。
然而，我们可以注意到，我们只对两个简单的属性感兴趣，以确定每个位置的状态:是否可以从当前位置进行移动，以及是否可以进入一个获胜的位置。第一个性质很容易检查如果我们保持最小元素到当前位置 i，我们叫它 mn。对于第二个属性，保持获胜位置的最小值就足够了，我们叫它 mnWin。那么，如果 mn<pi 且 mnWin>pi，位置 i 获胜。因此，解的时间复杂度为 O(n)。
======

input
4
3
2 1 3
2
2 1
3
1 2 3
4
2 1 4 3
output
1
0
1
2
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] usersLanguages = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j : languages[i]) {
                usersLanguages[i][j - 1] = true;
            }
        }
        Set<Integer> uncommon = new HashSet<>();
        for (int[] friendship : friendships) {
            int u = friendship[0] - 1, v = friendship[1] - 1;
            boolean hasCommon = false;
            for (int j = 0; j < n; j++) {
                if (usersLanguages[u][j] && usersLanguages[v][j]) {
                    hasCommon = true;
                    break;
                }
            }
            if (!hasCommon) {
                uncommon.add(u);
                uncommon.add(v);
            }
        }
        int[] counts = new int[n];
        for (int i : uncommon) {
            for (int j = 0; j < n; j++) {
                if (!usersLanguages[i][j]) {
                    counts[j]++;
                }
            }
        }
        return Arrays.stream(counts).min().orElseThrow();
    }
}
/*
1733. 需要教语言的最少人数
https://leetcode.cn/problems/minimum-number-of-people-to-teach/description/

在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
- 总共有 n 种语言，编号从 1 到 n 。
- languages[i] 是第 i 位用户掌握的语言集合。
- friendships[i] = [ui, vi] 表示 ui 和 vi 为好友关系。
你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
提示：
2 <= n <= 500
languages.length == m
1 <= m <= 500
1 <= languages[i].length <= n
1 <= languages[i][j] <= n
1 <= ui < vi <= languages.length
1 <= friendships.length <= 500
所有的好友关系 (ui, vi) 都是唯一的。
languages[i] 中包含的值互不相同。

为了使教语言的人数最少，应遵循如下贪心策略。
只有当一对好友没有共同掌握的语言时，才需要教其中至少一个用户一种语言。
对于上述用户，应选择这些用户中的掌握人数最多的语言，把该语言教给未掌握该语言的用户，则可满足上述用户都能掌握同一门语言且教语言的人数最少。
时间复杂度 O(mn+pn)。其中 m 是用户的数量，n 是语言的数量，p 是好友关系的数量。
 */
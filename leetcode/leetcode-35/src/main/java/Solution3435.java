import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3435 {
    private List<Integer>[] g;

    public List<List<Integer>> supersequences(String[] words) {
        // 收集有哪些字母，同时建图
        int all = 0;
        g = new ArrayList[26];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (String s : words) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(1) - 'a';
            all |= 1 << x;
            all |= 1 << y;
            g[x].add(y);
        }

        Set<Integer> set = new HashSet<>();
        int minSize = Integer.MAX_VALUE;
        // 枚举 all 的所有子集 sub
        // sub 中的 0 表示字母的出现次数是 1.
        // sub 中的 1 表示字母的出现次数是 2.
        int sub = all;
        do {
            int size = Integer.bitCount(sub);
            // 剪枝：如果 size > minSize 就不需要判断了
            if (size <= minSize && !hasCycle(sub)) {
                if (size < minSize) {
                    minSize = size;
                    set.clear();
                }
                set.add(sub);
            }
            sub = (sub - 1) & all;
        } while (sub != all);

        List<List<Integer>> ans = new ArrayList<>(set.size()); // 预分配空间
        for (int s : set) {
            List<Integer> cnt = new ArrayList<>(26); // 预分配空间
            for (int i = 0; i < 26; i++) {
                cnt.add((all >> i & 1) + (s >> i & 1));
            }
            ans.add(cnt);
        }
        return ans;
    }

    private boolean hasCycle(int sub) {
        int[] color = new int[26];
        for (int i = 0; i < 26; i++) {
            if ((sub >> i & 1) == 1) continue; // 只遍历不在 sub 中的字母
            if (color[i] == 0 && dfs(i, color, sub)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int x, int[] color, int sub) {
        color[x] = 1;
        for (int y : g[x]) {
            if ((sub >> y & 1) == 1) continue; // 只遍历不在 sub 中的字母
            if (color[y] == 1) return true;
            if (color[y] == 0 && dfs(y, color, sub)) return true;
        }
        color[x] = 2;
        return false;
    }
}
/*
3435. 最短公共超序列的字母出现频率
https://leetcode.cn/problems/frequencies-of-shortest-supersequences/description/

第 434 场周赛 T4。

给你一个字符串数组 words 。请你找到 words 所有 最短公共超序列 ，且确保它们互相之间无法通过排列得到。
最短公共超序列 指的是一个字符串，words 中所有字符串都是它的子序列，且它的长度 最短 。
请你返回一个二维整数数组 freqs ，表示所有的最短公共超序列，其中 freqs[i] 是一个长度为 26 的数组，它依次表示一个最短公共超序列的所有小写英文字母的出现频率。你可以以任意顺序返回这个频率数组。
排列 指的是一个字符串中所有字母重新安排顺序以后得到的字符串。
一个 子序列 是从一个字符串中删除一些（也可以不删除）字符后，剩余字符不改变顺序连接得到的 非空 字符串。
提示：
1 <= words.length <= 256
words[i].length == 2
words 中所有字符串由不超过 16 个互不相同的小写英文字母组成。
words 中的字符串互不相同。

贪心构造 + 枚举子集 + 有向图判环 + 优化。
1、性质：如果一个字母在答案中出现了两次，那么加在最左和最右是最优的
比如 a，加在最左和最右，那么可以满足所有 a* 和 *a 的字符串
    小问题：答案有必要有三个相同字母吗
2、每种字母至多是 2
3、16 种字母，每种字母要么出现 1 次，要么出现 2 次
    2^16 种不同的方案
4、枚举具体的方案（哪些字母出现 1 次，哪些出现 2 次）
    判断是否合法
5、求出所有合法方案中最短的
6、如何判断是否合法？
    s 字符串相当于一个约束：s[0] 在 s[1] 的左边
    这种位置关系可以抽象成【有向图】
7、问题变成判断【有向图】是否有环
8、有向图无环 -> 合法方案
相似题目: 207. 课程表
https://leetcode.cn/problems/course-schedule/
rating 3025 (clist.by)
 */
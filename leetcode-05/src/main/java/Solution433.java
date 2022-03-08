import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (cur.equals(end)) {
                    return step;
                }

                for (String next : bank) {
                    if (!visited.contains(next) && check(cur, next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean check(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
/*
433. 最小基因变化
https://leetcode-cn.com/problems/minimum-genetic-mutation/

一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
注意：
1.起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
2.如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
3.假定起始基因序列与目标基因序列是不一样的。

BFS。
 */
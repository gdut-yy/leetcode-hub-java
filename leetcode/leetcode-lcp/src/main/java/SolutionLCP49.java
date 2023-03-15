import java.util.Arrays;
import java.util.stream.IntStream;

public class SolutionLCP49 {
    private long[] challenge;
    private int n;
    private Integer[] idx;

    public long ringGame(long[] challenge) {
        this.challenge = challenge;
        this.n = challenge.length;
        this.idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, (o1, o2) -> Long.compare(challenge[o2], challenge[o1]));

        long res = 0L;
        for (long i = (1L << 61); i > 0; i /= 2) {
            if (!check((res | i) - 1)) {
                res |= i;
            }
        }
        return res;
    }

    // 检验当前的val，能否满足情况。
    private boolean check(long val) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i : idx) {
            // 如果搞不定当前的关卡
            if (val < challenge[i]) {
                continue;
            }
            // 如果已经搞定了当前的关卡
            if (visited[i]) {
                continue;
            }

            // 能搞定，就搞。并做好标记。
            long curScore = val | challenge[i];
            visited[i] = true;

            int ll = i;
            int rr = i;
            while (true) {
                // 如果这一圈都搞定了。两个指针已经相遇了
                if ((rr + 1) % n == ll) {
                    return true;
                }
                // 如果左侧的能搞定，就搞左侧的
                if (curScore >= challenge[(ll - 1 + n) % n]) {
                    ll = (ll - 1 + n) % n;
                    curScore |= challenge[ll];
                    visited[ll] = true;
                }
                // 如果右侧的能搞定，就往右搞定
                else if (curScore >= challenge[(rr + 1) % n]) {
                    rr = (rr + 1) % n;
                    curScore |= challenge[rr];
                    visited[rr] = true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
/*
LCP 49. 环形闯关游戏
https://leetcode.cn/problems/K8GULz/

LCCUP 力扣杯 2021 秋季编程大赛战队赛 T6。

「力扣挑战赛」中有一个由 N 个关卡组成的环形闯关游戏，关卡编号为 0~N-1，编号 0 的关卡和编号 N-1 的关卡相邻。
每个关卡均有积分要求，challenge[i] 表示挑战编号 i 的关卡最少需要拥有的积分。
- 小扣想要挑战关卡，闯关的具体规则如下：
- 初始小扣可以指定其中一个关卡为「开启」状态，其余关卡将处于「未开启」状态。
- 小扣可以挑战处于「开启」状态且满足最少积分要求的关卡，若小扣挑战该关卡前积分为 score，挑战结束后，积分将增长为 score|challenge[i]（即位运算中的 "OR" 运算）
在挑战某个关卡后，该关卡两侧相邻的关卡将会开启（若之前未开启）
请帮助小扣进行计算，初始最少需要多少积分，可以挑战 环形闯关游戏 的所有关卡。
提示：
1 <= challenge.length <= 5*10^4
1 <= challenge[i] <= 10^18
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3906 {
    private int[] pathPos;
    private int[] freeCount;
    private long[] pow10;
    private int[] fixedVal;
    private int[] digits;
    private List<int[]> allSeqs;

    public long countGoodIntegersOnPath(long l, long r, String directions) {
        pathPos = new int[7];
        int row = 0, col = 0;
        pathPos[0] = 0; // 起点 (0,0) -> 索引 0
        int idx = 1;
        for (char c : directions.toCharArray()) {
            if (c == 'D') row++;
            else if (c == 'R') col++;
            pathPos[idx++] = row * 4 + col;
        }
        boolean[] isPath = new boolean[16];
        for (int p : pathPos) isPath[p] = true;
        freeCount = new int[17];
        for (int i = 15; i >= 0; i--) {
            freeCount[i] = freeCount[i + 1] + (isPath[i] ? 0 : 1);
        }
        pow10 = new long[17];
        pow10[0] = 1;
        for (int i = 1; i <= 16; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
        fixedVal = new int[16];
        digits = new int[16];
        allSeqs = new ArrayList<>();
        genAllSeqs(0, 0, new int[7]);
        return countGood(r) - countGood(l - 1);
    }

    private void genAllSeqs(int step, int start, int[] seq) {
        if (step == 7) {
            allSeqs.add(seq.clone());
            return;
        }
        for (int d = start; d <= 9; d++) {
            seq[step] = d;
            genAllSeqs(step + 1, d, seq);
        }
    }

    private long countGood(long N) {
        if (N < 0) return 0;
        long temp = N;
        for (int i = 15; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }

        long total = 0;
        for (int[] seq : allSeqs) {
            total += calculate(seq);
        }
        return total;
    }

    private long calculate(int[] seq) {
        Arrays.fill(fixedVal, -1);
        for (int i = 0; i < 7; i++) {
            fixedVal[pathPos[i]] = seq[i];
        }
        return dfs(0, true);
    }

    private long dfs(int pos, boolean tight) {
        if (pos == 16) return 1;
        if (!tight) {
            return pow10[freeCount[pos]];
        }
        int limit = digits[pos];
        if (fixedVal[pos] != -1) {
            int d = fixedVal[pos];
            if (d > limit) return 0;
            if (d == limit) return dfs(pos + 1, true);
            return pow10[freeCount[pos + 1]];
        } else {
            long ans = (long) limit * pow10[freeCount[pos + 1]];
            ans += dfs(pos + 1, true);
            return ans;
        }
    }
}
/*
3906. 统计网格路径中好整数的数目
https://leetcode.cn/problems/count-good-integers-on-a-grid-path/description/

第 498 场周赛 T4。

给你两个整数 l 和 r，以及一个由 恰好 三个 'D' 字符和三个 'R' 字符组成的字符串 directions。
对于范围 [l, r]（包含边界）内的每个整数 x，执行以下步骤：
1.如果 x 的位数少于 16 位，请在其左侧填充 前导零 ，使其成为 16 位的字符串。
2.将这 16 个数字以 行优先 的顺序放入一个 4 × 4 的网格中（前 4 个数字从左到右构成第一行，接下来的 4 个数字构成第二行，依此类推）。
3.从左上角单元格（row = 0，column = 0）开始，按顺序应用 directions 中的 6 个字符：
  - 'D' 使行数加 1。
  - 'R' 使列数加 1。
4.记录沿路径访问的数字序列（包括起始单元格），生成一个长度为 7 的序列。
如果记录的序列是 非递减 的，则认为整数 x 是一个 好 整数。
返回一个整数，表示在范围 [l, r] 内好整数的数量。
提示：
1 <= l <= r <= 9 × 10^15
directions.length == 6
directions 由 恰好 三个 'D' 字符和三个 'R' 字符组成。

数位 DP。
https://chat.deepseek.com/a/chat/s/9982ca9d-fcc9-4d13-821d-99df764cb0c0
 */
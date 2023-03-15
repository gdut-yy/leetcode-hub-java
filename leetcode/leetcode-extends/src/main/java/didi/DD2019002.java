package didi;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DD2019002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String line = scanner.nextLine();
        System.out.println(solve(line));
    }

    private static final String GROUP1 = "qwertasdfgzxcv";

    private static String solve(String line) {
        String[] lines = line.split(" ");
        int n = lines.length;

        // [score, id] 如得分相同，则按照输入顺序进行排序。
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 1; i < n; i++) {
            int score = editDistance(lines[0], lines[i]);
            minHeap.add(new int[]{score, i});
        }

        List<String> resList = new ArrayList<>();
        int k = 3;
        while (!minHeap.isEmpty() && k > 0) {
            resList.add(lines[minHeap.remove()[1]]);
            k--;
        }
        return String.join(" ", resList);
    }

    private static int editDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // f[i][j] 表示 word1 的前 i 个元素和 word2 的前 j 个元素的编辑距离
        int[][] f = new int[n + 1][m + 1];

        // 初始状态
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][0] + 3;
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = f[0][j - 1] + 3;
        }

        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 3;
                    boolean b1 = GROUP1.contains("" + word1.charAt(i - 1));
                    boolean b2 = GROUP1.contains("" + word2.charAt(j - 1));
                    if ((b1 && b2) || (!b1 && !b2)) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                    } else {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 2);
                    }
                }
            }
        }
        return f[n][m];
    }
}
/*
DD-2019002. 英文单词拼写纠错推荐
https://leetcode.cn/problems/AbXz3n/

英文单词拼写的时候可能会出现拼写错误的情况(typo)。下面的题目，我们尝试实现拼写纠错推荐的功能。
字串编辑距离是衡量字串间相似度的常见手段。
1.字串编辑距离：是指利用字符操作，把字符串 A 转换成字符串B所需要的最少操作数。
2.字串操作包括：删除字符(removal)、插入字符(insertion)、修改字符(substitution)。
3.使用以下规则对推荐纠错选项进行相似度排序。得分越高，认为相似度越低 只涉及到 26 个英文字符、不区分大小写。
 - 删除(removal)：3 分
 - 插入(insertion)：3 分
 - 修改(substitution)：
  - (q w e r t a s d f g z x c v ) (y u i o p h j k l b n m)
  - 以上两个分组内的字符修改 1 分，两个分组间字符修改 2 分。
格式：
输入：
- 每行一个输入。空格分割参数。
- 第一个参数是目标单词(可能存在 typo)。后面若干空格分割参数(个数不定)是字典单词，作为候选纠错项（也可能和第一个参数重复）。
输出：
- 按照上面的纠错规则字串相似度最小编辑距离进行排序，给出3个(如有)对应的纠错候选。
- 如得分相同，则按照输入顺序进行排序。
示例：
输入：slep slap sleep step shoe shop snap slep
输出：slep slap step

动态规划
相似题目: 72. 编辑距离
https://leetcode.cn/problems/edit-distance/
 */
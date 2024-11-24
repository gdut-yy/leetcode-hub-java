package p817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CF817E {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int q = scanner.nextInt();

        Trie_Arr trie = new Trie_Arr(100000, 31);
        List<String> output = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int pi = scanner.nextInt();
            if (op == 1) {
                trie.insert(pi, 1);
            } else if (op == 2) {
                trie.insert(pi, -1);
            } else {
                int li = scanner.nextInt();
                int res = trie.query(pi, li - 1);
                output.add(String.valueOf(res));
            }
        }
        System.out.println(String.join("\n", output));
    }

    // 0-1 Trie
    // 2^31
    static class Trie_Arr {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie_Arr(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        public void insert(int x, int op) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx] += op;
            }
        }

        public int query(int x, int U) {
            int sum = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if ((U >> k & 1) == 1) {
                    if (dict[pos][idx] != 0) {
                        sum += cnt[dict[pos][idx]];
                    }
                    if (dict[pos ^ 1][idx] == 0) {
                        return sum;
                    }
                    idx = dict[pos ^ 1][idx];
                } else {
                    if (dict[pos][idx] == 0) {
                        return sum;
                    }
                    idx = dict[pos][idx];
                }
            }
            sum += cnt[idx];
            return sum;
        }
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
E. Choosing The Commander
https://codeforces.com/contest/817/problem/E

题目大意：
大家可能还记得上一轮比赛，沃瓦目前正在玩一款名为 "帝国之怒 "的策略游戏。
Vova 成功组建了一支庞大的军队，但却忘记了军队中的主力--指挥官。因此，他试图雇佣一名指挥官，他希望选择一个受战士们尊敬的人。
每个战士都有自己的个性--一个整数 pi 。每个指挥官都有两个特征--个性 pj 和领导力 lj (都是整数)。战士 i 只有在  ( 是 x 和 y 的 bitwise excluding OR)。
最初，沃瓦的军队是空的。军队可能会发生三种不同类型的事件：
1 pi - 一名个性为 pi 的战士加入沃瓦的军队；
2 pi - 一名个性为 pi 的战士离开沃瓦的军队；
3 pi li - 沃瓦试图雇佣一名个性为 pi 和领导力为 li 的指挥官。
对于第三种类型的每个事件，沃瓦都想知道有多少战士(只计算加入军队且尚未离开的战士)尊重他试图雇佣的指挥官。

相似题目: 1803. 统计异或值在范围内的数对有多少
https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/
======

Input
5
1 3
1 4
3 6 3
2 4
3 6 3
Output
1
0
 */

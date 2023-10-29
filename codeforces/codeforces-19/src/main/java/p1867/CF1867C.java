package p1867;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CF1867C {
    // FastReader 都 TLE，太sb了
    static Reader scanner = new Reader();

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        int mex = -1;
        for (int i = 0; i < n; ++i) {
            if (i == 0 && s[i] != 0) {
                mex = 0;
                break;
            }
            if (i > 0 && s[i] != s[i - 1] + 1) {
                mex = s[i - 1] + 1;
                break;
            }
        }
        if (mex == -1) {
            mex = s[n - 1] + 1;
        }
        System.out.println(mex);

        int y = scanner.nextInt();
        while (y != -1) {
            System.out.println(y);
            y = scanner.nextInt();
        }
    }

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            dataInputStream.close();
        }
    }
}
/*
C. Salyg1n and the MEX Game
https://codeforces.com/contest/1867/problem/C

题目大意：
这是一个互动问题!
salyg1n 给 Alice 一个由 n 个不同整数 s1,s2,...,sn(0≤si≤109)组成的集合 S。爱丽丝决定用这一套和鲍勃玩一局。游戏规则如下:
- 玩家轮流上场，爱丽丝先上场。
- 在一次移动中，Alice 向集合 S 中添加一个数字 x(0≤x≤109)。在移动时，集合 S 不能包含数字 x。
- 在一次移动中，Bob 从集合 S 中移除一个数字 y。集合 S 必须包含移动时的数字 y。另外，数字 y 必须严格小于 Alice 最后加的数字。
- 当鲍勃不能移动或移动 2·n+1(在这种情况下，爱丽丝的移动将是最后一个)时，游戏结束。
- 游戏结果为 MEX†(S)(游戏结束时为 S)。
- Alice 的目标是最大化结果，而 Bob 的目标是最小化结果。
设 R 为双方博弈最优时的结果。在这个问题中，你扮演爱丽丝对抗扮演鲍勃的陪审团程序。你的任务是为 Alice 执行一个策略，使游戏的结果总是至少为 R。
†整数集 c1,c2,...,ck 的 MEX 定义为不出现在集合 c 中的最小的非负整数 x。例如，MEX({0,1,2,4}) = 3。

难受
---
rating 1300
https://codeforces.com/blog/entry/120353
对爱丽丝来说，正确的策略是在第一步棋中将数字 MEX(S)添加到集合 S 中，并将最后移除的数字添加到其余的棋中。
设 m = MEX(S∪MEX(S))，在博弈开始时。换句话说，m 等于集合 S 的第二个 MEX。m≥1。
注意，在第一次移动之后，MEX(S)=m，无论 Bob 移走了什么，我们都会将该数字返回给集合，因此游戏的结果将始终等于 m。
让我们证明 Bob 的最优玩法，我们不能得到大于 m 的结果。
注意，集合的 MEX 是最大的数 k，使得集合中存在从 0 到 k−1 的所有数。
设 pi 为集合 S 中出现的从 0 到 i−1 的数的个数。那么 MEX(S)等于使 pi=i 的最大值 i。
如果 Bob 在他的回合中删除了数字 y，他将所有值 pi 中 i b> y 的值减少 1。所以,如果
无法解析标记[type=CF_MATHJAX]
，Bob 将所有非零值减少 1。
爱丽丝可以在她的回合中把一些值增加 1。因此，在 Alice 第一次移动之后，如果 Bob 继续移除最小值，MEX(S)将不再增加，因为 pi 的非零值不会增加(Bob 减少 1,Alice 最多增加 1)。
很明显，为了在第一次移动之后最大化 MEX(S)， Alice 需要将数字 MEX(S)添加到集合 S 中。
我们证明了 R≤m，并给出了一个策略，可以达到 m 的结果。
时间复杂度:每个测试用例 O(n)。
======

input
3
5
1 2 3 5 7

7

5

-1

3
0 1 2

0

-1

3
5 7 57

-1
output
8

57

0

3

0

0
 */

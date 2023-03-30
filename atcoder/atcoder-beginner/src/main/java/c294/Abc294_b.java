package c294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Abc294_b {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(h, w, a));
    }

    private static String solve(int h, int w, int[][] a) {
        char[][] cs = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == 0) {
                    cs[i][j] = '.';
                } else {
                    cs[i][j] = (char) (a[i][j] - 1 + 'A');
                }
            }
        }

        String[] res = new String[h];
        for (int i = 0; i < h; i++) {
            res[i] = new String(cs[i]);
        }
        return String.join(System.lineSeparator(), res);
    }

    private static class FastReader {
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
B - ASCII Art
https://atcoder.jp/contests/abc294/tasks/abc294_b

题目大意：
给定一个由 0 到 26 之间的整数组成的 H × W 矩阵 A。从上面开始的第 i 行和从左边开始的第 j 列的元素是 Aij。设 s1, s2,..., SH 是 H 个长度为 W 的字符串，满足以下条件。
如果 Aij 为 0,Si 的第 j 个字母为句点 (.)，否则 Aij 为大写英文字母。(例如，第 4 个字母是 D)
按顺序打印 s1, s2, ..., SH。

模拟。
======

Input
2 3
0 1 2
0 0 3
Output
.AB
..C

Input
3 3
24 0 0
0 25 0
0 0 26
Output
X..
.Y.
..Z

Input
3 1
2
9
4
Output
B
I
D

Input
24 60
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 13 13 14 0 0 0 10 0 0 0 0 0 15 24 14 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 13 23 7 25 24 13 10 0 10 12 0 0 0 0 19 9 23 0 0 0 0 10 10 14 0 0 0 10 14 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 13 5 0 0 23 11 14 14 0 0 12 9 1 21 19 0 0 9 12 10 25 3 10 6 0 0 9 13 23 24 14 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 13 14 6 0 0 0 10 5 25 13 0 0 25 0 0 0 0 0 0 0 0 0 0 10 16 0 0 13 21 13 13 14 23 14 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 13 8 2 0 0 0 0 0 13 11 13 19 0 0 1 2 5 9 12 12 5 9 9 20 6 0 14 14 14 9 0 0 0 14 14 18 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 10 23 13 13 13 13 13 13 14 14 14 13 14 14 13 7 0 0 0 0 0 0 0 0 0 0 0 0 13 13 13 2 0 0 0 0 13 11 13 16 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 13 1 0 0 0 9 20 9 20 20 20 20 13 20 20 13 20 23 8 8 8 20 8 20 7 8 17 7 10 13 14 13 19 0 0 0 0 0 22 14 25 13 16 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 13 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 20 20 13 13 7 20 26 13 8 6 14 0 0 0 0 0 0 0 0 0
0 0 0 0 0 5 0 0 0 0 0 0 0 1 2 20 20 23 13 2 7 2 10 12 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 20 23 13 0 0 0 0 0 0 0 0 0
0 0 0 0 13 0 0 0 0 0 0 0 0 1 0 0 0 13 12 9 14 13 13 9 9 20 12 0 0 0 0 0 0 0 0 0 0 0 1 9 9 9 9 12 0 0 0 0 0 0 0 20 0 0 0 0 0 0 0 0
0 0 0 2 0 0 0 0 0 0 0 0 0 0 19 0 0 14 13 14 14 13 13 0 0 9 5 16 0 0 0 0 0 0 5 20 20 13 2 2 20 9 13 14 14 20 12 12 0 0 0 0 9 13 0 0 0 0 0 0
0 0 1 9 0 0 0 0 0 0 0 0 0 0 0 13 10 13 13 13 13 2 5 12 10 5 0 0 0 0 0 0 0 0 20 16 0 0 0 13 14 13 13 13 13 0 0 10 8 0 0 0 0 0 20 7 0 0 0 0
0 0 4 2 0 0 0 0 0 0 0 0 0 0 0 0 9 7 14 10 10 14 13 5 0 0 0 0 0 0 0 0 0 0 0 23 13 12 13 13 13 13 13 9 13 0 14 4 0 0 0 0 0 0 0 9 16 0 0 0
0 0 22 13 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 13 13 13 2 9 14 2 20 14 0 0 0 0 0 0 0 0 0 2 0 0 0
0 0 0 5 13 0 0 0 2 7 13 13 13 13 13 13 13 2 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 20 20 9 0 0 0 0 0 0 0 0 0 0 0 0 0 19 0 0 0
0 0 0 0 20 13 12 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 21 14 7 2 20 24 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 6 0 0 0
0 0 0 0 0 0 9 14 14 0 0 20 20 13 13 20 13 9 0 0 10 0 0 0 0 0 0 9 23 13 9 0 0 0 0 0 0 0 10 6 0 0 7 0 0 9 20 13 13 14 2 0 0 0 0 5 0 0 0 0
0 0 0 0 0 0 0 0 20 13 14 0 0 0 0 0 0 0 0 13 9 0 0 0 0 0 0 0 0 13 11 0 0 0 0 0 0 0 14 9 0 0 0 20 25 14 7 0 0 0 0 9 1 14 7 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 9 13 13 20 0 0 0 0 0 9 12 0 0 0 0 0 0 0 14 13 14 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 9 9 20 14 14 4 14 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 2 9 0 0 0 0 9 9 20 21 7 13 20 0 0 20 23 7 7 2 12 7 6 0 0 0 0 0 0 0 0 0 0 0 0 5 5 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 20 9 9 20 24 10 12 10 0 0 0 0 0 0 0 0 20 20 0 0 0 0 0 20 7 7 13 22 2 5 9 2 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 20 5 20 5 2 5 7 20 5 14 14 5 11 5 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Output
................................B...........................
...................MMN...J.....OXN..........................
.................MWGYXMJ.JL....SIW....JJN...JN..............
...............IME..WKNN..LIAUS..ILJYCJF..IMWXN.............
..............MNF...JEYM..Y..........JP..MUMMNWN............
.............MHB.....MKMS..ABEILLEIITF.NNNI...NNR...........
..........JWMMMMMMNNNMNNMG............MMMB....MKMP..........
........MA...ITITTTTMTTMTWHHHTHTGHQGJMNMS.....VNYMP.........
......MI...............................TTTMMGTZMHFN.........
.....E.......ABTTWMBGBJL.......................TTWM.........
....M........A...MLINMMIITL...........AIIIIL.......T........
...B..........S..NMNNMM..IEP......ETTMBBTIMNNTLL....IM......
..AI...........MJMMMMBELJE........TP...MNMMMM..JH.....TG....
..DB............IGNJJNME...........WMLMMMMMIM.ND.......IP...
..VM.................................TMMMBINBTN.........B...
...EM...BGMMMMMMMBI....................ITTI.............S...
....TML..................UNGBTX........................IF...
......INN..TTMMTMI..J......IWMI.......JF..G..ITMMNB....E....
........TMN........MI........MK.......NI...TYNG....IANG.....
..........IMMT.....IL.......NMN.......F........IITNNDN......
..............TBI....IITUGMT..TWGGBLGF............EE........
.................TTIITXJLJ........TT.....TGGMVBEIB..........
.........................ITETEBEGTENNEKEB...................
............................................................
 */
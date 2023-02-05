package c285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Abc285_f {
    private static List<Fenwick> seg;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int N = scanner.nextInt();
        String S = scanner.next();
        char[] s = S.toCharArray();

        // 26 棵线段树
        seg = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            seg.add(new Fenwick(N));
        }
        int[] cnt = new int[26];

        for (int i = 0; i < N; i++) {
            seg.get(s[i] - 'a').add(i + 1, 1);
            cnt[s[i] - 'a']++;
        }

        int Q = scanner.nextInt();
        while (Q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt() - 1;
                char c = scanner.next().charAt(0);

                seg.get(s[x] - 'a').add(x + 1, -1);
                cnt[s[x] - 'a']--;
                s[x] = c;
                seg.get(s[x] - 'a').add(x + 1, 1);
                cnt[s[x] - 'a']++;
            } else {
                int l = scanner.nextInt();
                int r = scanner.nextInt();

                int[] ret = new int[26];
                for (int i = 0; i < 26; i++) {
                    ret[i] = seg.get(i).getSum(l, r);
                }
                int m = 0, M = 26;
                while (ret[m] == 0) m++;
                while (ret[M - 1] == 0) M--;
                boolean flag = true;
                for (int i = m + 1; i < M - 1; i++) {
                    flag &= (ret[i] == cnt[i]);
                }
                flag &= check(ret, l, r);
                System.out.println(flag ? "Yes" : "No");
            }
        }
    }

    private static boolean check(int[] ret, int l, int r) {
        for (int i = 0; i < 26; i++) {
            if (seg.get(i).getSum(l, l + ret[i] - 1) != ret[i]) {
                return false;
            }
            l += ret[i];
        }
        return true;
    }

    private static class Fenwick {
        private final int N;
        private final int[] tree;

        public Fenwick(int n) {
            this.N = n;
            this.tree = new int[N + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        // nums[x] add k
        public void add(int x, int k) {
            while (x <= N) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        public int getSum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        // nums [l,r] 的和
        public int getSum(int l, int r) {
            return getSum(r) - getSum(l - 1);
        }
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
F - Substring of Sorted String
https://atcoder.jp/contests/abc285/tasks/abc285_f

给定一个长度为N的字符串S，由小写英文字母组成，并进行Q次查询。按顺序处理查询。每个查询是以下两种类型之一:
1 x c: 将S的第x个字符替换为字符c。
2 l r: 设T为将S中的字符按升序排序得到的字符串。
如果由S的第l到第r个字符组成的字符串是T的子字符串，则打印Yes;否则，请打印No。

树状数组 + Fast I/O
线段树会 TLE。。
不用 Fast I/O 也会 TLE
 */
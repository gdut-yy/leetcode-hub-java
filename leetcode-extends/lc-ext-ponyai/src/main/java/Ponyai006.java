import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ponyai006 {
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int K = scanner.nextInt();
        int N = scanner.nextInt();

        int[] array = new int[N];
        int[] smallerCount = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        List<Integer>[] numIds = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            numIds[i] = new ArrayList<>();
        }

        int[] numIdsPtr = new int[10];
        int[] numIdsPtrSum = new int[10];

        for (int i = 0; i < N; i++) {
            int c = 0;
            for (int j = 0; j < array[i]; j++) {
                c += numIds[j].size();
            }
            smallerCount[i] = c;
            numIds[array[i]].add(i);
        }

        if (N == 1) {
            out.println(array[0]);
            return;
        }

        boolean first = true;
        int[] last2 = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 9; j >= 0; j--) {
                if (numIdsPtr[j] < numIds[j].size()) {
                    int nextId = numIds[j].get(numIdsPtr[j]);
                    int price = smallerCount[nextId] - numIdsPtrSum[j];

                    if (price <= K) {
                        K -= price;

                        if (i < N - 2) {
                            if (first) {
                                first = false;
                            } else {
                                out.print(" ");
                            }
                            out.print(j);
                        } else {
                            last2[i + 2 - N] = j;
                        }

                        numIdsPtr[j]++;

                        for (int j2 = j + 1; j2 < 10; j2++) {
                            numIdsPtrSum[j2]++;
                        }

                        break;
                    }
                }
            }
        }

        if (K != 0) {
            for (int j = 0; j < 10; j++) {
                if (numIds[j].size() > 1) {
                    K = 0;
                    break;
                }
            }

            if (K % 2 != 0) {
                int tmp = last2[0];
                last2[0] = last2[1];
                last2[1] = tmp;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (first) {
                first = false;
            } else {
                out.print(" ");
            }
            out.print(last2[i]);
        }

        out.println();
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
Pony.ai-006. 最大正整数
https://leetcode.cn/problems/IpQVkE/

数组中存储了一堆小于 10 的非负整数，整个数组从左到右代表一个正整数（如数组 [0, 1, 3, 2] 代表正整数 132）。现给出一个正整数 K，
要求经过 K 次数组相邻位置元素交换（必须完成 K 次交换），使得这个数组代表的数字最大。
例如,
int array[] = {0, 1, 3, 2}, K = 1，则经过 1 次交换后，数组所能代表的最大值为 1032；
int array[] = {0, 1, 3, 2}, K = 2，则经过 2 次交换后，数组所能代表的最大值为 3012。
输入描述:
首先，输入一个正整数 T，表示接收 T 组测试用例；
此后，输入 T 组测试用例，其中每组测试用例包含如下内容：
输入 1：一个正整数 K，表示在当前测试用例中，可以对数组进行 K 次相邻元素间的位置交换；
输入 2：一个正整数 N，表示当前用例包含数组的长度；
输入 3：N 个数组元素，所有元素都是小于 10 的非负整数；
输出描述:
输出共 T 行，对应于 T 个用例的输出：
每行输出为一个数组，数组元素之间用一个空格隔开，要求每行输出前后均无多余空格。
备注
60% 的数据 K <= 10^3
70% 的数据 K <= 10^4
80% 的数据 K <= 10^5
90% 的数据 K <= 10^6
100% 的数据 K <= 10^9
100% 的数据 T <= 10^3，60% 的数据 N <= 10^3，100% 的数据 N <= 5 * 10^3。
示例 1
输入
4
2
5
4 2 1 3 5
3
5
4 2 1 3 5
4
5
4 2 1 3 5
5
5
4 2 1 3 5
输出
4 3 2 1 5
4 5 2 1 3
5 4 2 1 3
5 4 2 3 1
 */
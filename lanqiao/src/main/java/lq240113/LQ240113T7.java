package lq240113;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LQ240113T7 {
    static Reader scanner = new Reader();
    static int n, A, B;
    static int[] a;

    public static void main(String[] args) throws IOException {
        n = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int N = (int) (1e6 + 5);
    static long[][] ca = new long[N][20];
    static long[][] cb = new long[N][20];

    private static String solve() {
        for (int i = 1; i <= n; i++) {
            ca[i][0] = a[i] % A;
            cb[i][0] = a[i] % B;
        }
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j + (1 << i) - 1 <= n; j++) {
                ca[j][i] = ca[j][i - 1] * ca[j + (1 << (i - 1))][i - 1] % A;
                cb[j][i] = cb[j][i - 1] * cb[j + (1 << (i - 1))][i - 1] % B;
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int l = index(ca, i, A);
            int r = index(cb, i, B);
            if (l <= r) {
                ans += r - l;
            }
        }
        return String.valueOf(ans);
    }

    static int index(long[][] x, int p, int A) {
        long res = 1;
        for (int i = 19; i >= 0; i--) {
            if (p + (1 << i) - 1 <= n) {
                if (res * x[p][i] % A != 0) {
                    res = res * x[p][i] % A;
                    p += (1 << i);
                }
            }
        }
        return p;
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
小蓝的反击【算法赛】

解法一：
倍增 + 二分。我们考虑枚举起点，然后找到从起点开始最近的点，满足连乘是 A 的倍数，同时找到最近的点，满足连乘是 B 的倍数。
两个位置相减即可，然后将所有的起点的结果都加起来。
我们假设 ri 为从 i 点开始，最近的点满足：ax 是 A 的倍数
我们假设 r‘i 为从 i 点开始，最近的点满足：ax 是 B 的倍数
然后 r'i - ri 就是结果。
复杂度 O(n * logn * logn) 或者 O(nlogn)
解法二：
双指针，我们维护两个指针，一个维护 A 的倍数，一个维护 B 的倍数，与上述做法类似。
复杂度 O(n)
 */
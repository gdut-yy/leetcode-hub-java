public class SolutionP4028 {
    public int minOperations(String s) {
        int n = s.length();
        long[] convSum = new long[n];
        int total = 0;
        for (int k = 0; k < 13; k++) {
            double[] aReal = new double[n];
            for (int i = 0; i < n; i++) {
                int x = s.charAt(i) - 'a';
                if (k <= x && x < k + 13) {
                    aReal[i] = 1;
                    total++;
                }
            }
            long[] c = selfCyclicConv(aReal);
            for (int i = 0; i < n; i++) {
                convSum[i] += c[i];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int rot = 0; rot < n; rot++) {
            int c = (int) (((long) rot * 2 - 1 + n) % n);
            ans = Math.min(ans, rot - (int) convSum[c]);
        }
        return ans + total;
    }

    // 一维循环自卷积（长度 n）
    private long[] selfCyclicConv(double[] a) {
        int n = a.length;
        int size = 1;
        while (size < n * 2) size <<= 1; // 线性卷积长度 2n-1，取 ≥ 的最小 2 的幂
        double[] real = new double[size];
        double[] imag = new double[size];
        System.arraycopy(a, 0, real, 0, n);
        transform(real, imag, false);
        for (int i = 0; i < size; i++) {
            double r = real[i], im = imag[i];
            real[i] = r * r - im * im;
            imag[i] = 2 * r * im;
        }
        transform(real, imag, true);
        long[] conv = new long[n];
        for (int i = 0; i < n; i++) {
            conv[i] = Math.round(real[i]) + Math.round(real[i + n]);
        }
        return conv;
    }

    // 原地迭代 Cooley–Tukey FFT（使用 double[] 存实部/虚部）
    public void transform(double[] real, double[] imag, boolean invert) {
        int n = real.length;
        // 1. 位反转置换
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >>> 1;
            for (; j >= bit; bit >>>= 1) j -= bit;
            j += bit;
            if (i < j) {
                swap(real, i, j);
                swap(imag, i, j);
            }
        }
        // 2. 蝶形运算
        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            double wlenReal = Math.cos(ang);
            double wlenImag = Math.sin(ang);
            int half = len >>> 1;

            for (int i = 0; i < n; i += len) {
                double wReal = 1.0, wImag = 0.0;
                for (int j = 0; j < half; j++) {
                    int idx1 = i + j;
                    int idx2 = i + j + half;

                    double uReal = real[idx1];
                    double uImag = imag[idx1];

                    double vReal = real[idx2] * wReal - imag[idx2] * wImag;
                    double vImag = real[idx2] * wImag + imag[idx2] * wReal;

                    real[idx1] = uReal + vReal;
                    imag[idx1] = uImag + vImag;
                    real[idx2] = uReal - vReal;
                    imag[idx2] = uImag - vImag;

                    double nextWReal = wReal * wlenReal - wImag * wlenImag;
                    double nextWImag = wReal * wlenImag + wImag * wlenReal;
                    wReal = nextWReal;
                    wImag = nextWImag;
                }
            }
        }
        // 3. 逆变换除以 n
        if (invert) {
            for (int i = 0; i < n; i++) {
                real[i] /= n;
                imag[i] /= n;
            }
        }
    }

    private void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
/*
$4028. 得到旋转回文字符串的最少操作次数 II
https://leetcode.cn/problems/minimum-operations-to-make-a-rotated-palindrome-ii/description/

给你一个由小写英文字母组成的字符串 s 。
你可以按任意顺序执行以下操作任意次（包括零次）：
- 递增：选择任意一个下标 i 并将 s[i] 替换为下一个小写英文字母。'z' 之后的字母是 'a' 。
- 左旋：将字符串的第一个字符移动到末尾。
返回使 s 成为 回文串 所需的 最少 操作次数。
示例 1：
输入： s = "abc"
输出： 2
示例 2：
输入： s = "yb"
输出： 3
提示：
2 <= s.length <= 5 * 10^4
s 仅由小写英文字母组成。

FFT.
相似题目: 4021. 得到旋转回文字符串的最少操作次数 I
https://leetcode.cn/problems/minimum-operations-to-make-a-rotated-palindrome-i/description/
 */
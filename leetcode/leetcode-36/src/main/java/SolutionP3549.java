public class SolutionP3549 {
    public long[] multiply(int[] poly1, int[] poly2) {
        int n1 = poly1.length, n2 = poly2.length;
        int resultSize = n1 + n2 - 1;
        // Find power of two ≥ n1 + n2
        int N = 1;
        while (N < n1 + n2) N <<= 1;

        // Prepare complex arrays
        double[] aReal = new double[N], aImag = new double[N];
        double[] bReal = new double[N], bImag = new double[N];
        for (int i = 0; i < n1; i++) aReal[i] = poly1[i];
        for (int i = 0; i < n2; i++) bReal[i] = poly2[i];

        // Forward FFT
        fft(aReal, aImag, false);
        fft(bReal, bImag, false);

        // Point-wise multiply
        for (int i = 0; i < N; i++) {
            double real = aReal[i] * bReal[i] - aImag[i] * bImag[i];
            double imag = aReal[i] * bImag[i] + aImag[i] * bReal[i];
            aReal[i] = real;
            aImag[i] = imag;
        }

        // Inverse FFT
        fft(aReal, aImag, true);

        // Extract and round
        long[] result = new long[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = Math.round(aReal[i]);
        }
        return result;
    }

    // In-place iterative Cooley–Tukey FFT
    private void fft(double[] real, double[] imag, boolean invert) {
        int n = real.length;
        // Bit-reversal permutation
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >>> 1;
            for (; j >= bit; bit >>>= 1) j -= bit;
            j += bit;
            if (i < j) {
                swap(real, i, j);
                swap(imag, i, j);
            }
        }
        // FFT
        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            double wlenReal = Math.cos(ang), wlenImag = Math.sin(ang);
            for (int i = 0; i < n; i += len) {
                double wReal = 1, wImag = 0;
                int half = len >>> 1;
                for (int j = 0; j < half; j++) {
                    double uReal = real[i + j];
                    double uImag = imag[i + j];
                    double vReal = real[i + j + half] * wReal
                            - imag[i + j + half] * wImag;
                    double vImag = real[i + j + half] * wImag
                            + imag[i + j + half] * wReal;
                    real[i + j] = uReal + vReal;
                    imag[i + j] = uImag + vImag;
                    real[i + j + half] = uReal - vReal;
                    imag[i + j + half] = uImag - vImag;
                    double nextWReal = wReal * wlenReal - wImag * wlenImag;
                    double nextWImag = wReal * wlenImag + wImag * wlenReal;
                    wReal = nextWReal;
                    wImag = nextWImag;
                }
            }
        }
        // If inverse FFT, divide by n
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
$3549. 两个多项式相乘
https://leetcode.cn/problems/multiply-two-polynomials/description/

给定两个整数数组 poly1 和 poly2，其中每个数组中下标 i 的元素表示多项式中 xi 的系数。
设 A(x) 和 B(x) 分别是 poly1 和 poly2 表示的多项式。
返回一个长度为 (poly1.length + poly2.length - 1) 的整数数组 result 表示乘积多项式 R(x) = A(x) * B(x) 的系数，其中 result[i] 表示 R(x) 中 xi 的系数。
提示：
1 <= poly1.length, poly2.length <= 5 * 10^4
-10^3 <= poly1[i], poly2[i] <= 10^3
poly1 与 poly2 至少包含一个非零系数。

FFT模板。
 */
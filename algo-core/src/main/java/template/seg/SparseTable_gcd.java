package template.seg;

/**
 * CF474F
 * ST 表求 GCD
 * https://oi-wiki.org/ds/sparse-table/
 */
public class SparseTable_gcd {
    long[][] st;

    public SparseTable_gcd(int[] a) {
        int n = a.length;
        st = new long[n][17];
        for (int i = 0; i < n; i++) {
            st[i][0] = a[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = getGCD(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    long query(int l, int r) {
        int k = bitsLen(r - l) - 1;
        return getGCD(st[l][k], st[r - (1 << k)][k]);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    int bitsLen(long x) {
        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}

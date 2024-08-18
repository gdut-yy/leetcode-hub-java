package lq240615;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240615T3 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        long x = 1;
        for (int v : primes) {
            // 注意会爆 long
//            if(x*v <= n) {
            if (n / x >= v) {
                ans++;
                x *= v;
            }
        }
        return String.valueOf(ans);
    }

    // 预处理
    static List<Integer> primes;
    static int MAX_N = (int) 2e5;

    static {
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[MAX_N];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < MAX_N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < MAX_N; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }
}
/*
最大质因子个数【算法赛】

题意可以等价为我们需要选择尽量多个不同质数，使得这些质数的乘积不大于 n。
从贪心角度不难想到，我们应该不断选择尽量小的质数，这样乘积的增长比较缓慢，从而使得我们尽可能放进更多质数。
实现的方法有很多，一种推荐的方法是使用筛法预处理一定范围内的质数，然后从小到大不断乘即可，
需要注意的是，在乘的过程中数据范围可能超出 longlong。
 */
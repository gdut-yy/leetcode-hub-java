package lq240210;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.LongFunction;

public class LQ240210T8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        int T = scanner.nextInt();
        long b;
        for (int i = 0; i < T; i++) {
            b = scanner.nextLong();
            decompose(b);
        }
        long ans = 1;
        for (Map.Entry<Long, Integer> entry : mp.entrySet()) {
            long p = entry.getKey();
            int q = entry.getValue();
            ans = ans * phi(p % MOD, 2 * q) % MOD;
        }
        if (ans < 0) {
            ans += MOD;
        }
        System.out.println(ans);
    }

    static void init() {
        d[1] = 1;
        for (int i = 2; i * i < maxp; ++i) { // 埃筛，d[i]表示是否为 非质数
            if (d[i] == 0) {
                for (int j = i * i; j < maxp; j += i) {
                    d[j] = i;
                }
            }
        }
        for (int i = 2; i < maxp; ++i) {
            if (d[i] == 0) {
                d[i] = i;
                pr[ptot++] = i; // 素数表
            }
        }
    }

    static int MOD = 998244353;

    static long phi(long p, int q) {
        return quickPow(p, q, MOD) - quickPow(p, q - 1, MOD);
    }

    final public static int maxp = (int) 7e5 + 7;

    static int ptot;
    static int[] d = new int[maxp];
    static int[] pr = new int[maxp];
    static Map<Long, Integer> mp = new HashMap<>();

    static boolean miller_rabin(long p) {
        if (p <= 4) return p == 2 || p == 3;
        long pow_2 = 0, tmp = p - 1;
        while (tmp % 2 == 0) {
            tmp /= 2;
            pow_2 += 1;
        }
        for (int a : new int[]{2, 3, 5, 7, 11}) {
            long basic = quickPow(a, tmp, p);
            if (basic == 0 || basic == 1 || basic == p - 1) continue;
            for (int i = 1; i < pow_2; i++) {
                basic = cheng(basic, basic, p);
                if (basic == 1) return false;
                if (basic == p - 1) break;
            }
            if (basic != p - 1) return false;
        }
        return true;
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b, long MOD) {
        a %= MOD;
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = cheng(res, a, MOD);
            a = cheng(a, a, MOD);
            b >>= 1;
        }
        return res;
    }

    // 龟速乘
    static long cheng(long a, long b, long MOD) {
        long s = 0;
        while (b != 0) {
            if ((b & 1) != 0) s = (s + a) % MOD;
            a = (a + a) % MOD;
            b >>= 1;
        }
        return s;
    }

    static long pollard_rho(long n) {
        long bias = randint(3, n - 1);
        LongFunction<Long> update = i -> (cheng(i, i, n) + bias) % n;
        long x = randint(0, n - 1);
        long y = update.apply(x);
        while (x != y) {
            long factor = getGCD(Math.abs(x - y), n);
            if (factor != 1) return factor;
            x = update.apply(x);
            y = update.apply(update.apply(y));
        }
        return n;
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    static Random random = new Random();

    static long rand() {
        return Math.abs(random.nextLong());
    }

    static long randint(long a, long b) {
        long len = b - a + 1;
        return rand() % len + a;
    }

    static int getValue(long n) {
        Integer tmp = mp.get(n);
        return tmp != null ? tmp : 0;
    }

    static void decompose(long n) {
        if (n < maxp) {
            while (n > 1) {
                int tmp = getValue(d[(int) n]);
                mp.put((long) d[(int) n], tmp + 1);
                n /= d[(int) n];
            }
        } else if (miller_rabin(n)) { // 是质数
            int tmp = getValue(n);
            mp.put(n, tmp + 1);
        } else {
            long fact = pollard_rho(n);
            decompose(fact);
            decompose(n / fact);
        }
    }
}
/*
学《数论》的贝贝【算法赛】

我们先考虑如何求解出，方程的所有解**。
对方程进行变形：
c(b-a)=-ab
c =\dfrac{ab}{a-b}
故容易得到 a > b。
不妨设a=b+\Delta，其中 \Delta > 1。
由 (1) 式得：
c=\dfrac{(b+\Delta)b}{\Delta}
=\dfrac{b^2+\Delta \cdot b}{\Delta}
=\dfrac{b^2}{\Delta} +b
也就是说 \Delta只要是b^2的约数都可以，都可以得到一组 (a,c) 解。
于是我们对b质因数分解 b=p_1^{q_1}p_2^{q_2}\cdots p_k^{q_k}，得到每个质数及其对于的指数部分（质因数分解可以用Pollard-Rho来做）。
我们将指数都乘以 2，就得到了 b^2 的质因数分解形式 b^2=p_1^{2q_1}p_2^{2q_2}\cdots p_k^{2q_k} 。
容易得到 \Delta=p_1^{c_1}p_2^{c_2}\cdots p_k^{c_k}，其中 0\le c_i\le 2q_i，即枚举所有的  (c_1,c_2,\cdots,c_k)，也就可以得到方程的所有解。
**接下来，开始考虑求解式子**。
设函数g(n)  为：g(n)=\sum_{d\mid n}\varphi(d)\mu(\dfrac{n}{d})  。
有  \Delta =b-a，于是我们就可以化简所求式子：
\sum_{(a+c)\times b=ac} g(\max(a-b,1))= \sum_{\Delta \mid b^2}g(\Delta)
接下来设 b^2=s，于是我们求解的式子就变成了：
\quad \sum_{\Delta \mid b^2}g(\Delta)
=\sum_{\Delta \mid s}\sum_{d\mid \Delta }\varphi(d)\mu(\dfrac{\Delta}{d})
我们发现这个式子并不好直接求解，我们需要重新换一个思路。
但是因为 \mu 和 \varphi 都是积性函数，故不难发现 g=\mu * \varphi 也是积性函数。
**另外，我们刚刚不是恰巧分解了质因数吗？**
故g(\Delta)=\prod_{i=1}^k g(p_i^{c_i})。
接下来我们考虑g(p^q)  的性质，q>0。
* 其约数为  1,p,p^2,\cdots,p^q；
* 容易得到这些约数的莫比乌斯函数除了 \mu(1) 为 1 且 \mu(p) 为 -1 以外，其余均为 0；
* 故：
* $\quad  g(p^q)=\mu(p)\varphi(p^{q-1})+\mu(1)\varphi(p^q) $
  = \varphi(p^q)-\varphi(p^{q-1})$
又因为：
$\quad \varphi(p^q)=p^q(1-\dfrac{1}{p})$
$=p^q-p^{q-1}$
可以 \mathcal O(\log q) 求解 \varphi(p^q)，也就可以 \mathcal O(\log q) 求解g(p^q)。
故我们所求式子，可以化简为如下形式（类似基于质因数分解，求解一个数的所有约数之和）：
$\quad\sum_{\Delta \mid s}g(\Delta)$
$= \prod_{i=1}^k (g(p_i^0)+g(p_i^1)+\cdots+g(p_i^{2q_i}))$
$= \prod_{i=1}^k (\varphi(p_i^0)+(\varphi(p_i^1)-\varphi(p_i^0))+\cdots+\varphi(p_i^{2q_i})-\varphi(p_i^{2q_i-1}))$
$= \prod_{i=1}^k \varphi(p_i^{2q_i})$
$= \prod_{i=1}^k (p_i^{2q_i}-p_i^{2q_i-1})$
可以 \mathcal O(k\log q) 求解答案。
---
**另一种思路**：
考虑狄利克雷卷积，
则需要求解的式子为 (\mathrm g*\mathrm I)(s)  。
* 其中 \mathrm I为恒等函数，即 \mathrm I=1。
考虑狄利克雷卷积的性质（结合律、交换律），于是有：
$ \quad \mathrm g* \mathrm I$
$= \varphi * \mu*  \mathrm{I}$
$= \varphi * (\mu*  \mathrm{I})$
$= \varphi * \varepsilon$
其中  \varepsilon=[n=1]，为黎曼函数。
所以求解的式子为：
$ \quad (\varphi * \varepsilon)(s)$
$ = \varphi(s)$
$ = \prod_{i=1}^k \varphi(p_i^{2q_i})$
$ = \prod_{i=1}^k (p_i^{2q_i}-p_i^{2q_i-1})$
再梳理一下，读入时，对于每个b_i做质因数分解，设 $V=\max\{b_i\}$。那么使用 Pollard-Rho 单次质因数分解可以做到 $\mathcal O(V^\frac{1}{4}\log V)$（是一个很松的上界），总共为 \mathcal O(m\times V^\frac{1}{4}\log V)。
总时间复杂度为 \mathcal O(m\times  V^\frac{1}{4}\log V +k\log q)。
 */

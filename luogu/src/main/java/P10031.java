import java.io.PrintWriter;
import java.util.Scanner;

public class P10031 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        long n = scanner.nextLong();
        if (n % 2 == 0) {
            n ^= n / 2;
        }
        out.println(n);
    }
}
/*
https://www.luogu.com.cn/problem/P10031

灵茶の试炼 2025-12-30
输入 T(≤100) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18)。
输出 gcd(n,1) XOR gcd(n,2) XOR gcd(n,3) XOR ... XOR gcd(n,n) 的结果。

方法零：从特殊到一般
如果 n 是质数，答案是多少？
如果 n 是两个奇质数的乘积（比如 n=15），答案是多少？动手算一算。
如果 n 是偶数，答案是多少？
方法一：GCD 的性质
由于 gcd(n,i) = gcd(n,n-i)（更相减损术），所以 gcd(n,i) XOR gcd(n,n-i) = 0，对称位置两两抵消。
当 n 是奇数时，最终只剩下 gcd(n,n) = n。
当 n 是偶数时，最终只剩下 gcd(n,n/2) = n/2 和 gcd(n,n) = n，异或结果为 n/2 XOR n。
方法二：欧拉函数的奇偶性
如果 gcd(n,i) = d，那么 n 和 i 都是 d 的倍数。
这可以写成 gcd(n,k*d) = d，也就是 gcd(n/d,k) = 1，即 k 与 n/d 互质。
1 到 n/d 中有 φ(n/d) 个与 n/d 互质的数。
答案可以表示为：计算 d 的异或和，其中 d 是 n 的因子，且 φ(n/d) 为奇数。（偶数个 d 异或为 0）
变量代换，令 m = n/d，答案表示为：计算 n/m 的异或和，其中 m 是 n 的因子，且 φ(m) 为奇数。
哪些 φ(m) 是奇数？
如果 m 含有奇质数 p，那么 φ(m) 式子包含 p-1，φ(m) 为偶数。
如果 m = 2^k 且 k >= 2，那么 φ(2^k) = 2^(k-1) 是偶数。
所以只有 φ(1) = φ(2) = 1 是奇数，得到和方法一同样的结论。
代码 https://paste.ubuntu.com/p/zb8tT2G9FT/
======
# P10031 「Cfz Round 3」Xor with Gcd

## 题目背景

她是午夜潜入海风漂流的沙砾

极光与她一齐许下明日愿景

飞身电波铺满天穹而海仍平静

“愿世界都繁花似锦”

## 题目描述

给定一个整数 $n$。

你需要求出 $\bigoplus\limits_{i=1}^{n} \gcd(i,n)$，即 $\gcd(1,n) \oplus \gcd(2,n) \oplus \cdots \oplus \gcd(n,n)$ 的值。其中 $\gcd(a,b)$ 表示 $a$ 和 $b$ 的**最大公约数**，$\bigoplus$ 表示**按位异或**，即 C++ 中的 `^`。

## 输入格式

**本题有多组测试数据。**

第一行输入一个整数 $T$，表示测试数据组数。

接下来依次输入每组测试数据。对于每组测试数据，输入一行一个整数 $n$。

## 输出格式

对于每组测试数据，输出一行一个整数，表示 $\bigoplus\limits_{i=1}^{n} \gcd(i,n)$ 的值。

## 输入输出样例 #1

### 输入 #1

```
3
2
3
6

```

### 输出 #1

```
3
3
5
```

## 说明/提示

#### 「样例解释 #1」

对于第 $1$ 组数据，$\bigoplus\limits_{i=1}^{2} \gcd(i,2)=\gcd(1,2)\oplus\gcd(2,2)=1\oplus2=3$。

对于第 $2$ 组数据，$\bigoplus\limits_{i=1}^{3} \gcd(i,3)=\gcd(1,3)\oplus\gcd(2,3)\oplus\gcd(3,3)=1\oplus1\oplus3=3$。

#### 「数据范围」

对于所有数据，$1 \le T \le 100$，$1 \le n \le 10^{18}$。

**只有你通过本题的所有测试点，你才能获得本题的分数。**
 */
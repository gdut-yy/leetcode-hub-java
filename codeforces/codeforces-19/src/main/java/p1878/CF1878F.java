package p1878;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1878F {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static Map<Integer, Integer> cnt;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            cnt = factorize(n);

            System.out.println(solve());
            System.out.println();
        }
    }

    private static String solve() {
        List<String> output = new ArrayList<>();
        next:
        for (int i = 0; i < q; i++) {
            int k = scanner.nextInt();
            if (k == 2) {
                cnt = factorize(n);
                continue;
            }
            int x = scanner.nextInt();
            for (Map.Entry<Integer, Integer> entry : factorize(x).entrySet()) {
                int p = entry.getKey(), e = entry.getValue();
                cnt.merge(p, e, Integer::sum);
            }
            int d = 1;
            for (Integer e : cnt.values()) {
                d *= e + 1;
            }
            for (Map.Entry<Integer, Integer> entry : factorize(d).entrySet()) {
                int p = entry.getKey(), e = entry.getValue();
                if (e > cnt.getOrDefault(p, 0)) {
                    output.add("NO");
                    continue next;
                }
            }
            output.add("YES");
        }
        return String.join(System.lineSeparator(), output);
    }

    static Map<Integer, Integer> factorize(int x) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i > 0) continue;
            int e = 1;
            for (x /= i; x % i == 0; x /= i) {
                e++;
            }
            cnt.put(i, e);
        }
        if (x > 1) {
            cnt.put(x, 1);
        }
        return cnt;
    }
}
/*
F. Vasilije Loves Number Theory
https://codeforces.com/contest/1878/problem/F

灵茶の试炼 2024-05-16
题目大意：
Vasilije 是一个聪明的学生，他的离散数学老师 Sonja 把数论教得很好。
他给了 Ognjen 一个正整数 n。
记 d(n)为 n 的正整数除数，记 gcd(a,b)为最大的整数 g，使得 a 能被 g 整除，b 能被 g 整除。
之后，他给了 Ognjen q 个查询，有两种类型的查询。
- 1, x：设 n 为 n·x，然后回答以下问题:是否存在一个正整数 a 使得 gcd(a,n)=1 且 d(n·a)=n ?
- 2：将 n 重置为初始值(在任何查询之前)。
注意，在类型 1 查询之后，n 不会回到它的初始值。
因为 Ognjen 害怕数论，Vasilije 答应他每次查询后 d(n)≤10^9，然而，即使有了这个约束，他仍然需要你的帮助来解决这个问题。

rating 1900
https://codeforces.com/blog/entry/120813
答案:当且仅当 d(n)能除 n 时解存在。
证明:考虑数 n=p1^α1·p2^α2...pk^αk 的质因数分解，其中 pi 代表第 i 个素数，αi 代表第 i 个素数的最高次幂，使得 pi^αi 能整除 n。知道了这一点，我们可以用下面的公式计算 n 的除数:d(n)=(α1+1)·(α2+1)...(αk+1)。
现在让我们考虑一下我们正在执行的操作。我们将数字 n 乘以与 n 没有公素因子的数字 a (当 gcd(a,n)=1)
n 乘以任何整数只会给 n 带来新的质因数，这意味着我们不能改变 d(n) 除数公式中括号内的内容，但我们可以添加新的括号。因此，d(n)总是 d(n·a)的约数。我们可以写成 d(n·a)=v·d(n)为了实现 d(n·a)=n，我们还必须有 v·d(n)=n。因此，d(n)必须是 n 的约数。证明它也是充分的。
令 k=n/d(n) 选择任意不是 n 因子的素数 p(这样的素数存在，因为有无限多个素数，而 n 有有限个素数因子)。将 n 乘以 a=p^{k−1}，得到 d(n·a)=d(n)·k=n。
利用这个事实，我们只需要在每次类型 1 查询后有效地检查 d(n) 是否能除 n。我们该怎么做呢?
首先，我们预先计算小于 10^6 的每个正整数的最小素数因子。这允许我们在对数时间内分解所有小于或等于 10^6 的数。我们也可以用上面提到的公式来分解 n 并找出它的因数个数，并为每个质因数存储其能整除 n 的最高次幂。我们可以用数组，也可以用映射，两种方法都行，我们称这个结构为 power。
现在我们需要处理查询:
对于类型 2 查询，我们只需要重置所有内容。
对于第一个查询，我们在 O(logx) 次运算中分解 x，并令 x = r1^β1·r2^β2...rℓ^βℓ 关于 x 的因式分解。我们通过以下方式更新 d(n):对于 x 中的每个质数 ri，将 d(n)除以[ri]+1 次方，然后将 βi 加上[ri]次方，然后将 d(n)乘以[ri]+1 次方。在我们计算完 d(n)之后，我们要检查 n 是否能被它整除。我们可以通过两种方式做到这一点:
解决方案 1:
我们通过将之前所有类型 1 查询的值(在最后一个类型 2 查询之后)与开始 n 的值乘以模 d(n)来实现这一点，因为 n 可以变得非常大，而我们不能将其存储在 64 位整数中。如果 mod d(n)的值为 0，则其可整除，查询的答案为“YES”，否则为“NO”。
时间复杂度 O(Q·(Q+logx)+logn)
---
考虑 n 的质因数分解，n = p1^e1*p2^2*p3^e3*...
考虑 n 的因子的质因数分解，p1 的幂次可以取 [0,e1] 中的任意数字，p2 的幂次可以取 [0,e2] 中的任意数字，……
根据乘法原理，有
d(n)=(e1+1)*(e2+1)*(e3+1)*...
例如 12=2^2*3^1，d(12)=(2+1)*(1+1)=6，对应因子 1,2,3,4,6,12。
gcd(n,a)=1，意味着 a 和 n 的质因数分解没有任何交集，所以
d(n*a)=d(n)*d(a)
要使 d(n)*d(a) = n，满足 n 是 d(n) 的倍数即可（因为 d(a) 可以取任意正整数）。
请注意，题目只保证 d(n)<=1e9，n 可以超出 64 位整数的范围。
那要怎么判断 n%d(n)==0？
可以用质因数分解来判断，如果 d(n) 的质因数分解中，有一个质数 p 的幂次超过了 n 的质因数分解中的 p 的幂次，那么 n%d(n) > 0，输出 NO。
否则输出 YES。
具体算法如下：
1. 用一个 map 记录 n 的质因数分解，key 是质因子 p，value 是 p 的幂次。
2. 对于询问 1，把 n 乘上 x，并往 map 中添加 x 的质因数分解（合并两个 map）。
3. 遍历 map，计算 d(n)=(e1+1)*(e2+1)*(e3+1)*...
4. 计算 d(n) 的质因数分解，是否有一个质数 p 的幂次超过了 map 中的 p 的幂次，如果超过则输出 NO。如果没有这种情况输出 YES。
5. 为方便实现，可以把计算质因数分解的过程封装成一个函数。
https://codeforces.com/problemset/submission/1878/261047266
======

input
7
1 5
1 1
1 2
2
1 8
1 9
20 4
1 3
2
1 7
1 12
16 10
1 6
1 6
1 10
1 9
1 1
1 9
1 7
1 3
1 2
1 10
9 1
1 3
8 1
1 2
8 3
1 5
1 8
1 10
11 5
1 8
1 2
1 1
1 3
1 1
output
YES
YES
YES
YES

YES
NO
YES

YES
NO
YES
YES
YES
NO
YES
NO
YES
YES

NO

NO

YES
NO
NO

YES
NO
NO
NO
NO
 */

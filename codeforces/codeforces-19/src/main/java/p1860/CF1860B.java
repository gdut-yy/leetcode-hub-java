package p1860;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1860B {
    static int m, k, a1, ak;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            m = scanner.nextInt();
            k = scanner.nextInt();
            a1 = scanner.nextInt();
            ak = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int taken_k = m / k;
        int taken_1 = m % k;
        int taken_fancy_1 = Math.max(0, taken_1 - a1);
        int left_regular_1 = Math.max(0, a1 - taken_1);
        int taken_fancy_k = Math.max(0, taken_k - ak);
        int to_replace = Math.min(left_regular_1 / k, taken_fancy_k);
        int ans = taken_fancy_1 + taken_fancy_k - to_replace;
        return String.valueOf(ans);
    }
}
/*
B. Fancy Coins
https://codeforces.com/contest/1860/problem/B

题目大意：
Monocarp 将以 m 个 burles 的价格进行购买。
他有两种硬币，数量如下:
- 价值 1 比勒的硬币: a1 枚普通硬币和无限多的花式硬币;
- 价值 k 比勒的硬币: ak 枚普通硬币和无限多的花式硬币。
Monocarp 想要以一种没有变化的方式进行购买——提供的硬币的总价值正好是 m。他既可以使用普通硬币，也可以使用花哨的硬币。然而，他想要花费尽可能少的花哨硬币。
他可以用来购买物品的最小花式硬币总数是多少?
---
在第一个测试用例中，没有这两种类型的普通硬币。Monocarp 可以使用价值 1 个 burle 的 2 个花式硬币和价值 3 个 burle 的 3 个花式硬币(因为 k=3)获得 11 个 burle 和 5 个花式硬币。
在第二个测试用例中，Monocarp 拥有大量两种类型的常规硬币。例如，他可以使用价值 1 美元的 11 枚普通硬币。注意，Monocarp 不必最小化使用的硬币总数。这样他就不用花哨的硬币了。
在第三个测试案例中，Monocarp 可以使用价值 1 个 burle 的 5 个普通硬币和价值 3 个 burles 的 1 个普通硬币。这将使他在需要 11 个球的情况下总共得到 8 个球。所以，1 枚花式硬币价值 3 枚硬币就足够了。

思考：是否用完常规硬币？
---
https://codeforces.com/blog/entry/119504
有两种方法可以解决这个问题:数学方法和算法方法。
方法 1
让我们先看看用硬币表示 m 个洞的可能方法。例如，我们可以尝试尽可能多地使用价值为 k 的硬币:那么，价值为 k 的硬币的数量将是⌊mk⌋，价值为 1 的硬币的数量将是 mmodk。
现在假设使用那么多价值为 k 的硬币不是最优的;如果使用更多价值 1 的硬币和更少价值 k 的硬币会更好呢?好吧，我们仍然可以先使用数组中值为 k 的硬币 mk⌋和值为 1 的硬币 mmodk，然后尝试将一个值为 k 的硬币替换为 k 个值为 1 的硬币几次(可能为零)。
我们应该这样做多少次，什么时候我们应该停下来得到最优解?首先，让我们确保我们已经取了尽可能多的普通硬币。然后，如果我们有至少 k 枚剩余的价值为 1 的普通硬币(不是花哨的)，并且我们已经拿走了至少一枚价值为 k 的花哨硬币，那么最好把那枚硬币换掉。很容易看出，如果不是这种情况，就不需要任何替换:如果我们没有 k 个目前未使用的普通硬币，那么至少有一个替换硬币将是花哨的;如果我们想要替换的价值 k 的硬币并不漂亮，为什么要替换它呢?
所以，我们可以写一个 while 循环来记录我们取走了多少枚不同类型的硬币，用 k 枚价值为 1 的普通硬币替换 1 枚价值为 k 的奇特硬币，直到不可能。不幸的是，这太慢了。但是不运行这个循环，我们可以计算我们在 0(1)内进行替换的次数:它是我们没有使用的价值为 1 的普通硬币的数量除以 k，以及我们使用的价值为 k 的奇特硬币的数量的最小值。
所以，解决方案的大纲如下:
首先，拿走尽可能多的价值为 k 的硬币，然后计算我们拿走了多少价值为 k 的硬币;计算一下我们拿走了多少普通硬币和花式硬币;计算我们可以制造多少“替代品”(丢弃一个价值为 k 的奇特硬币，加上 k 个价值为 1 的普通硬币)。
方法 2
第二种方法也从分析我们可以拿走多少价值为 1 的硬币和多少价值为 k 的硬币开始。我们可以取的值为 k 的硬币的最小数目是 0，最大数目是⌊mk⌋。
设 f(x)表示我们使用的花式硬币的数量，如果我们取 x 个价值为 k 的硬币。这个函数可以很容易地计算出来，因为如果 x 是固定的，我们知道我们拿走了两种硬币的数量。我们需要找到这个函数在[0，⌊mk⌋]上的最小值。
f(x+1) - f(x)是怎样的?从 f(x)到 f(x+1)的意义就是用一个 k 的硬币替换 k 个价值 1 的硬币。当我们增加 x 时，显然，我们应该首先尝试丢弃价值为 1 的花式硬币，然后是价值为 1 的普通硬币(当我们增加 x 时，我们将丢弃的花式硬币的数量永远不会增加)。同样，我们应该尝试先取价值为 k 的普通硬币，然后再取奇特的硬币(当 x 增加时，我们取的奇特硬币的数量永远不会减少)。因此，f(x+1) - f(x)的值不会随着 x 的增加而减小。
所有这些都意味着 f(x)的最小值可以用三进制搜索找到。
======

input
4
11 3 0 0
11 3 20 20
11 3 6 1
100000000 2 0 0
output
5
0
1
50000000
 */

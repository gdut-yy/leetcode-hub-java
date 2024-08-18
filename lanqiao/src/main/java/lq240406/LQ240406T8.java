package lq240406;

import java.util.Scanner;

public class LQ240406T8 {
    static long n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n / k % 2 != 0) {
            return "BeiBei" + System.lineSeparator() + (n - k + 1);
        }
        return "NingNing" + System.lineSeparator() + (n - 2 * k + 1) + " " + (n - k);
    }
}
/*
学《博弈论》的贝贝 2.0【算法赛】

我们将正面看成 1，反面看成 0，于是这就是一个 n 位的二进制数 B，一开始大小为 B=2^n-1。
当减小至 B<2^k-1 时游戏结束，每次操作后其必然减少，故游戏必然可以结束，
约定 B 的最低位（最右边）为第 1 位，最高位（最右边）为第 n 位，从右往左依次标记第 i 位，第 i 位的数值为 B[i]。
设集合 U = \{ k,2k,3k,...,\lfloor \frac{n}{k} \rfloor\cdot k \}，约定第 i 次操作结束后，函数 f_i = {\textstyle \sum_{x \in U}^{} B[X]=1}
显然有 f_0 = \lfloor \frac{n}{k}  \rfloor
无论是谁，只要能操作，都是长度为 k 的区间，而 U 中的每个数的间隔都为 k。故最终每次操作，有且仅与 U 中的一个数有交集，也就只会改变其中某个 x \in U 的 B[x] 的值。
故 \left | f_{i+1}-f_i \right | = 1。根据这个性质，我们通过 f_0 初始的奇偶性来考虑。
若 f_0 为偶数，因为 k≤n 显然 f_0>0。奇数次操作过后，f_i 必然也为奇数，此时轮到 NingNing 操作。因为 f_i 为奇数，U 中必然有可当做左端点的位置，此时选出其中某个 x \in U 进行操作，将变为偶数。循环往复，最终变成 0，然后轮到 BeiBei 操作，无法操作判负，NingNing 获胜。
同理，若 f_0 为奇数。偶数次操作过后，f_i 必然也为奇数。BeiBei 只需要执行上述类似操作，即可取胜。此时 BeiBei 获胜。
接下来考虑二人第一次操作的必胜方案数，若为奇数，那么 BeiBei 无论第一步怎么走，都可以改变奇偶性，故必胜方案数为 n-k+1
若 f_0 为奇数，那么 BeiBei 无论第一步怎么走，都可以改变奇偶性，故必胜方案数为 n-k+1。
若 f_0 为偶数，因为 f_0>0，故 f_0 至少为 2，即 n ≥ 2k。
当 BeiBei 第一步取 B[k] 为左端点时，NingNing 第一步的必胜方案最多，为 n-k 种。
当 BeiBei 第一步取 B[n] 为左端点时，NingNing 第一步的必胜方案最少，为 n-2k+1 种。
@小羊肖恩Yawn_Sean
 */
package nc60456;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NC60456D {
    static int n, h, k;
    static int[][] ab;
    static int q;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        h = scanner.nextInt();
        k = scanner.nextInt();
        ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        q = scanner.nextInt();
        x = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] costs = new long[n];
        for (int i = 0; i < n; i++) {
            int a = ab[i][0];
            int b = ab[i][1];
            int remain = a % 4;
            int round = a / 4 * 3;
            if (remain > 0) round++;
            if (remain > 2) round++;
            costs[i] = (round - 1L) * b;
        }
        Arrays.sort(costs);

        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + costs[i];
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            long health = h + (long) x[i] * k;

            int left = 1;
            int right = n + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (!(preSum[mid] < health)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left - 1;
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
小红打怪
https://ac.nowcoder.com/acm/contest/60456/D

题目描述
已知地图上有 n 只怪物，每只怪物的血量是 ai，攻击力是 bi。小红准备去地图上探险杀怪，她的初始血量为 h。
小红有两个技能：
1. 普通攻击：对一只怪物造成 1 点伤害。
2. 强力攻击：对一只怪物造成 2 点伤害。
但是强力攻击是有冷却时间的。释放一个强力攻击后，需要 2 回合冷却（即释放 2 次普通攻击后）才能再次释放。
小红每次攻击后，若怪物没有死亡（即血量大于 0），小红都会承受一次怪物攻击力的伤害。但是小红可以在战斗开始前喝血药，每个血药可以回复 k 点血量。也就算说，x 瓶血药可以将小红的初始血量提高到 h+x\*k
已知每只怪物都是不可复活的，当小红血量为 0 或负数时死亡。小红选择打一个怪时，在该怪物被打死之前不会更换目标。
当小红打死一只怪物去寻找另外一只怪物的过程中，我们可以认为强力攻击的冷却已经恢复完毕。
请问，小红初始带了 x 瓶血药时，最多可以击杀多少只怪物？
上述问题会重复 q 次，每次询问都是独立的，小红初始的血瓶数量可能不同。
输入描述:
第一行输入三个正整数 n,h,k ，代表地图上怪物的数量、小红的初始血量，以及小红每瓶血药可以回复的血量。
接下来的 n 行，每行输入两个正整数 ai 和 bi，代表地图上每只怪物的血量和攻击力。
接下来的一行输入一个正整数 q，代表询问次数。
接下来的一行，输入 q 个正整数 x，代表每次询问中小红携带的血药数量。
1≤n,q,h,k,ai,bi,x≤10^5
输出描述:
输出一行 q 个正整数，代表小红携带 x 瓶血药时能击杀的最多怪物数量。

前缀和 + 二分
======

示例1
输入
3 1 2
5 1
5 2
3 2
3
1 2 3
输出
1 1 2
说明
第一只怪物小红需要攻击 4 次才能杀死，所以会被怪物打 3 下，掉血为 1*3=3。
第二只怪物小红需要攻击 4 次才能杀死，所以会被怪物打 3 下，掉血为 2*3=6。
第三只怪物小红需要攻击 2 次才能杀死，所以会被怪物打 1 下，掉血为 2*1=2。
当小红携带 1 瓶血药时，可以先将血量回复至 3 点，然后击杀第三只怪物，剩余血量为 1。
当小红携带 2 瓶血药时，无法击杀两只怪物。
当小红携带 3 瓶血药时，可以击杀第一只、第三只怪物。
 */
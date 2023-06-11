package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class CF1840G2 {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        int x = scanner.nextInt();
        int mx = x;
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int rand = random.nextInt(MOD);
            System.out.println("+ " + rand);
            x = scanner.nextInt();
            mx = Math.max(mx, x);
        }

        int[] A = new int[401];
        A[400] = x;
        for (int i = 399; i >= 0; i--) {
            System.out.println("+ 1");
            A[i] = scanner.nextInt();
        }

        int[] B = new int[401];
        System.out.println("+ " + mx);
        B[0] = scanner.nextInt();
        for (int i = 1; i <= 400; i++) {
            System.out.println("+ 400");
            B[i] = scanner.nextInt();
        }

        for (int i = 0; i <= 400 * 400; i++) {
            if (A[i % 400] == B[i / 400]) {
                System.out.println("! " + (mx + i));
                return;
            }
        }
    }
}
/*
G2. In Search of Truth (Hard Version)
https://codeforces.com/contest/1840/problem/G2

题目大意：
简单版本和硬版本之间的唯一区别是查询的最大数量。在这个版本中，您最多可以查询 1000 个查询。
这是一个互动的问题。
你在玩游戏。圆被分成 n 个扇区，扇区按一定顺序从 1 到 n 编号。你在相邻的房间里，既不知道扇区的数量，也不知道扇区的编号。(do not know either the number of sectors or their numbers.)
还有一个箭头最初指向某个区域。最初，主机会告诉您箭头所指向的扇区的编号。之后，你可以要求主持人逆时针或顺时针移动 k 个扇区，最多 2023 次。每次你都会被告知箭头所指向的扇区的数字。
您的任务是确定整数 n 最多 2023 个查询中的扇区数量。
保证 1≤n≤10^6。

交互题。
1--x--mx--n
先随机找若干个数，最大值为 mx
从 x 出发，走 k 次，然后往回走 n-mx 步（即倒着走 mx 步），再走 k 次
概率为 ((n-k^2) / n)^100 这里的 k 为 400，当 n = 1e6 时，失败概率为 0.84^1000 = 2.68e-8
======

input
1

5

6

7

2

10

9

8

4

3

1
output
+ 1

+ 1

+ 1

+ 1

+ 1

+ 1

+ 1

+ 1

+ 1

+ 1

! 10
 */

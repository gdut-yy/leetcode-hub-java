package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1840G1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        int[] A = new int[1001];
        A[1000] = scanner.nextInt();
        for (int i = 999; i >= 0; i--) {
            System.out.println("+ 1");
            A[i] = scanner.nextInt();
        }

        int[] B = new int[1001];
        B[0] = A[0];
        for (int i = 1; i <= 1000; i++) {
            System.out.println("+ 1000");
            B[i] = scanner.nextInt();
        }

        for (int i = 1; i <= 1000 * 1000; i++) {
            if (A[i % 1000] == B[i / 1000]) {
                System.out.println("! " + i);
                return;
            }
        }
    }
}
/*
G1. In Search of Truth (Easy Version)
https://codeforces.com/contest/1840/problem/G1

题目大意：
简单版本和硬版本之间的唯一区别是查询的最大数量。在这个版本中，您最多可以查询 2023 个查询。
这是一个互动的问题。
你在玩游戏。圆被分成 n 个扇区，扇区按一定顺序从 1 到 n 编号。你在相邻的房间里，既不知道扇区的数量，也不知道扇区的编号。(do not know either the number of sectors or their numbers.)
还有一个箭头最初指向某个区域。最初，主机会告诉您箭头所指向的扇区的编号。之后，你可以要求主持人逆时针或顺时针移动 k 个扇区，最多 2023 次。每次你都会被告知箭头所指向的扇区的数字。
您的任务是确定整数 n 最多 2023 个查询中的扇区数量。
保证 1≤n≤10^6。

交互题。
先逐个遍历前 1000，然后间隔 1000 去查询，取余必然会落在 1000以内。
期望次数 2000
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

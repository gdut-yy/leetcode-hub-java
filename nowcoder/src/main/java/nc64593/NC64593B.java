package nc64593;

import java.util.Scanner;

public class NC64593B {
    static int n, k;
    static int[] a;
    static int[][] uv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            uv = new int[k][2];
            for (int i = 0; i < k; i++) {
                uv[i][0] = scanner.nextInt();
                uv[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        for (int i = 0; i < k; i++) {
            int u = uv[i][0] - 1, v = uv[i][1] - 1;
            a[u]++;
            a[v]--;
        }
        return check() ? "Yes" : "No";
    }

    private static boolean check() {
        for (int i = 1; i < n; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
小美的数组操作2
https://ac.nowcoder.com/acm/contest/64593/B

题目描述
小美拿到了一个数组，她每次可以进行如下操作：
选择两个元素，一个加 1，另一个减 1。
小美总共进行了 k 次操作。她希望你回答最终数组是否是非降序，你能帮帮她吗？
请注意，元素可能会被减成负数！
输入描述:
第一行输入一个正整数 t，代表询问次数。
每次询问首先第一行输入两个正整数 n 和 k，代表数组长度和操作次数。
接下来的一行输入 n 个正整数 ai，代表初始数组。
接下来的 k 行，每行输入两个正整数 u,v，代表使得第 u 个元素加 1，第 v 个元素减 1。
1≤t,n,k,ai≤100
输出描述:
输出 t 行，每行输出该次询问的答案。
如果数组变成了非降序，则输出"Yes"。否则输出 "No"。

模拟。
======

示例1
输入
2
3 2
3 4 5
2 3
1 2
3 2
3 4 5
2 3
2 3
输出
Yes
No
说明
第一组询问，操作两次后数组变成[4,4,4]，为非降序。
第二组询问，操作两次后数组变成[3,6,3]，并不是非降序。
 */
package lq240323;

import java.util.Scanner;

public class LQ240323T3 {
    static int x;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    static final int[][] mp = {
            {0},
            {1},
            {6, 2, 4, 8},
            {1, 3, 9, 7},
            {6, 4},
            {5},
            {6},
            {1, 7, 9, 3},
            {6, 8, 4, 2},
            {1, 9}
    };
//    static final int[] MP = {1, 1, 4, 4, 3, 1, 1, 4, 4, 2};

    private static String solve() {
        x %= 10;
        int p = powl(s, mp[x].length);
        return String.valueOf(mp[x][p]);
    }

    static int powl(char[] s, int n) {
        int ans = 0;
        for (char c : s) ans = (ans * 10 + c - '0') % n;
        return ans;
    }
}
/*
djwcb【算法赛】

找循环节
0 0
1 1
2 4 8 6 2
3 9 7 1 3
4 6 4
5 5
6 6
7 9 3 1 7
8 4 2 6 8
9 1 9
 */
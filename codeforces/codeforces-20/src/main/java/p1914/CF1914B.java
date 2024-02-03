package p1914;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1914B {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] ans = new int[n];
        int x = 1;
        for (int i = n - 1; i > k; i--) {
            ans[i] = x++;
        }
        for (int i = 0; i <= k; i++) {
            ans[i] = x++;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Preparing for the Contest
https://codeforces.com/contest/1914/problem/B

题目大意：
独果在为一场大型比赛练习。他计划解决 6 个问题，以确保他准备好了。这些问题中的每一个都有一个难度等级:第一个问题的难度等级为 1，第二个问题的难度等级为 2，以此类推，直到最后(第 n 个)问题的难度等级为 n。
Monocarp 会选择一个顺序来解决所有 n 个问题。每当他解决了一个比他解决的上一个问题更难的问题时，他就会感到兴奋，因为他觉得自己在进步。当他按自己选择的顺序解决第一个问题时，他不会感到兴奋。
例如，如果 Monocarp 以[3,5,4,1,6,2]的顺序解决问题，他会兴奋两次(相应的问题被下划线)。
Monocarp 在练习过程中想要兴奋的次数正好是 k 次。帮助他选择解决问题的顺序!

构造，脑筋急转弯？
======

input
3
6 2
5 4
5 0
output
3 5 4 1 6 2
1 2 3 4 5
5 4 3 2 1
 */
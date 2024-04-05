package lq240210;

import java.util.Scanner;

public class LQ240210T7 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n % 2 == 1) {
            return "BeiBei & NingNing";
        } else if (n * 2 / 4 > 2) {
            return "BeiBei & NingNing";
        } else if (n % 2 == 0) {
            return "LinLin";
        } else {
            return "LinLin";
        }
    }
}
/*
学《博弈论》的贝贝【算法赛】

#include <bits/stdc++.h>
using namespace std;
int main() {
    int T;
    cin >> T;
    int x;
    while (T --) {
        cin >> x;
        if (x % 2 == 1) {
            cout << "BeiBei & NingNing\n";
        } else if (x * 2 / 4 > 2) {
            cout << "BeiBei & NingNing\n";
        } else if (x % 2 == 0) {
            cout << "LinLin\n";
        } else {
            cout << "LinLin\n";
        }
    }
    return 0;
}
@DownFuFu
 */
package c278;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc278_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve(h, m));
    }

    private static String solve(int h, int m) {
        int t0 = h * 60 + m;
        for (int i = t0; i < t0 + 1440; i++) {
            int time = i % 1440;
            String hStr = "00" + (time / 60);
            String mStr = "00" + (time % 60);

            int a = hStr.charAt(hStr.length() - 2) - '0';
            int b = hStr.charAt(hStr.length() - 1) - '0';
            int c = mStr.charAt(mStr.length() - 2) - '0';
            int d = mStr.charAt(mStr.length() - 1) - '0';

            int nh = a * 10 + c;
            int nm = b * 10 + d;
            if (nh * 60 + nm < 1440 && nm < 60) {
                return (a * 10 + b) + " " + (c * 10 + d);
            }
        }
        return "-1";
    }
}
/*
B - Misjudge the Time
https://atcoder.jp/contests/abc278/tasks/abc278_b

题目大意：
高桥买了一个表钟。
时钟显示的时间如图 1 在 24 小时制 AB: CD 处所示。
例如，图 2 中的时钟显示为 7:58。
> 时间的格式正式描述如下。
> 假设当前时间是 24 小时制的小时后 m 分。在这里，24 小时制用 0 到 23(含)之间的整数表示小时，用 0 到 59(含)之间的整数表示分钟。
> 设 A 为 h 的十位，B 为 h 的十位，C 为 m 的十位，D 为 m 的一位。（这里，如果 h 只有一位，我们认为它有一个前导零;这同样适用于 m。）
> 然后，时钟在左上方显示 A，在左下方显示 B，在右上方显示 C，在右下方显示 D。
Takahashi 决定，如果一个时间满足以下条件，就称其为混乱时间:
在交换了时钟上右上和左下的数字后，它仍然读取 24 小时制中的有效时间。
例如，图 3 中的时钟显示的是 20:13。在交换了右上和左下的数字后，它的读数是 21:03。因此，20:13 是一个令人困惑的时间。
时钟现在显示 H: m。在 24 小时制中找到下一个令人困惑的时间(包括现在)。

模拟。
======

Input 1
1 23
Output 1
1 23

Input 2
19 57
Output 2
20 0

Input 3
20 40
Output 3
21 0
 */
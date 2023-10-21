package nc60245;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NC60245C {
    static char[] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cs = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = cs.length;
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '1') {
                ones.add(i);
            }
        }
        int zeros = n - ones.size();

        if (ones.size() > zeros) {
            return String.valueOf(getAns(0, ones));
        } else if (zeros > ones.size()) {
            return String.valueOf(getAns(1, ones));
        } else {
            long ans = Math.min(getAns(0, ones), getAns(1, ones));
            return String.valueOf(ans);
        }
    }

    // 第 1 个 '1' 在下标 begin 处
    static long getAns(int begin, List<Integer> ones) {
        long ans = 0;
        for (int from : ones) {
            ans += Math.abs(from - begin);
            begin += 2;
        }
        return ans;
    }
}
/*
游游的交换字符
https://ac.nowcoder.com/acm/contest/60245/C

题目描述
游游拿到了一个01串（仅由字符'0'和字符'1'构成的字符串）。游游每次操作可以交换两个相邻的字符，例如，对于字符串"11001"而言，游游可以交换第二个字符和第三个字符变成"10101"。
游游希望最终字符串任意两个相邻的字符都不相同，她想知道最少需要多少操作次数？保证答案是有解的，即最终一定能形成任意两个相邻的字符都不相同的字符串。
输入描述:
一行仅由 '0' 、 '1' 组成的字符串，字符串长度n 满足2≤n≤200000。
输出描述:
游游使得相邻两个字母不等的最少操作次数。

分类讨论两种情况：0开头，1开头
======

示例1
输入
11100
输出
3
说明
先交换第三个、第四个字符，得到字符串"11010"。
然后交换第二个、第三个字符，得到字符串"10110"。
最后交换第四个、第五个字符，得到字符串"10101"。
总共交换3次。

示例2
输入
01011
输出
2
说明
先交换前两个字符，得到字符串"10011"
然后交换第三个、第四个字符，得到字符串"10101"
 */
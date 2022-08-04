package p1674;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CF1674D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        int n = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
            b[i] = a[i];
        }

        Arrays.sort(b);
        for (int i = n - 1; i > 0; i -= 2) {
            if (a[i] < a[i - 1]) {
                int tmp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = tmp;
            }
        }
        return Arrays.equals(a, b) ? "YES" : "NO";
    }
}
/*
D. A-B-C Sort
https://codeforces.com/contest/1674/problem/D

题目大意：
有三个数组a, b和c。最初，数组a包含n个元素，数组b和c是空的。
第一步：当a不为空时，你把a最后一个元素的放到b中间。如果b长度为奇数，可以选择：放在b中间的左侧或右侧。直到a变为空，b含有n个元素。
第二步：当b不为空时，取出b中间的元素，并将其移动到数组c的末尾。如果b当前的长度为偶数，你可以从两个中间元素中选择一个。直到b变为空，c由n个元素组成。
问能否让 c 非降序排列。输出 YES 或 NO.

贪心。
观察到本质上就是是否互换每对元素，从后往前，每两个元素为一对。
======

input
3
4
3 1 5 3
3
3 2 1
1
7331

output
YES
NO
YES
 */
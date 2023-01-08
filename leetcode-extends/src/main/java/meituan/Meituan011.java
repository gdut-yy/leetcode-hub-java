package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

public class Meituan011 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String[] line0 = reader.readLine().split(" ");
        long[] inputs = new long[7];
        for (int i = 0; i < 7; i++) {
            inputs[i] = Long.parseLong(line0[i]);
        }
        long res = solution(inputs);
        writer.write(String.valueOf(res));
        writer.close();
        reader.close();
    }

    private static long solution(long[] inputs) {
        long d = inputs[3];
        // 贪心。三种组合 [[a,e], [b,f], [c,g]]
        long[][] combinations = {{inputs[0], inputs[4]}, {inputs[1], inputs[5]}, {inputs[2], inputs[6]}};
        Arrays.sort(combinations, Comparator.comparingLong(o -> o[1]));
        long max0 = Math.min(combinations[2][0], d);
        long max1 = Math.max(0, Math.min(combinations[1][0], d - max0));
        long max2 = Math.max(0, Math.min(combinations[0][0], d - max0 - max1));
        return max0 * combinations[2][1] + max1 * combinations[1][1] + max2 * combinations[0][1];
    }
}
/*
meituan-011. 搭配出售
https://leetcode.cn/problems/0JzXQB/

服装店新进了 a 条领带，b 条裤子，c 个帽子，d 件衬衫，现在要把这些搭配起来售卖。有三种搭配方式，一条领带和一件衬衫，一条裤子和一件衬衫，
一个帽子和一件衬衫。卖出一套领带加衬衫可以得到 e 元，卖出一套裤子加衬衫可以得到 f 元，卖出一套帽子加衬衫可以得到 g 元。现在你需要输出最大获利。
格式：
输入：
- 一行 7 个整数分别表示 a, b, c, d, e, f, g 。
输出：
- 最大获利。
示例：
输入：2 3 4 5 6 7 8
输出：39
解释：4 个帽子加 4 件衬衫获利 32 元，1 条裤子加 1 件衬衫获利 7 元，一共得到 39 元。
 */

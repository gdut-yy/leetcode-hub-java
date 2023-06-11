package p1734;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1734B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        List<String> resList = new ArrayList<>();
        for (int len = 1; len <= n; len++) {
            int[] line = new int[len];
            line[0] = 1;
            line[len - 1] = 1;
            resList.add(Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
B. Bright, Nice, Brilliant
https://codeforces.com/contest/1734/problem/B

题目大意：
有一座金字塔，有 n 层。楼层按递增的顺序从上到下编号。在金字塔中，第 i 层由 i 个房间组成。
表示第 i 层的第 j 个房间为(i,j)。对于 1≤j≤i<n 的所有正整数 i 和 j，分别存在从(i,j)到(i+1,j)和从(i,j)到(i+1,j+1)的 2 个单向阶梯。
在每个房间里，你可以放一个火炬，也可以把它空着。将房间(i,j)的亮度定义为带有火炬的房间的数量，您可以通过非负数量的楼梯到达房间(i,j)。
例如，当 n=5 时，在房间(1,1)、(2,1)、(3,2)、(4,1)、(4,3)和(5,3)中放置火把，金字塔可以表示如下:
---
在上面的图片中，有火把的房间是黄色的，空房间是白色的。右下角的蓝色数字表示房间的亮度。
房间(4,2)(有星星的房间)有亮度。在下图中，可以到达(4,2)的房间有红色边框。因为这些房间里有三个火把，所以亮度是 3。
---
金字塔被称为好，当且仅当所有楼层的所有房间都有相同的亮度。
将一个漂亮金字塔的亮度定义为(1,1)，(2,1)，(3,1)，…， (n,1)。
在金字塔中找到一个火炬的安排，这样得到的金字塔是漂亮的，它的光彩是最大化的。
我们可以证明一个答案总是存在的。如果有多个答案，输出其中任何一个。

constructive algorithms
每行第一个和最后一个放火把即可。
======

input
3
1
2
3
output
1
1
1 1
1
1 1
1 0 1
 */

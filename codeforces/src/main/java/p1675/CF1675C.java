package p1675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CF1675C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        int n = line.length();
        // 排除嫌疑:
        // 1 后面有 1
        // 0 前面有 0
        // ? 后面有 1 || ? 前面有 0
        List<Integer> idxList1 = new ArrayList<>();
        List<Integer> idxList0 = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '1') {
                idxList1.add(i);
            } else if (line.charAt(i) == '0') {
                idxList0.add(i);
            } else {
                idxList.add(i);
            }
        }

        // 有嫌疑
        // 1 后面没 1 (最后一个 1)
        // 0 前面没 0 (第一个 0)
        // ? 后面没 1 && ? 前面没 0

        // 最后一个 1
        int last1Idx = idxList1.size() > 0 ? idxList1.get(idxList1.size() - 1) : -1;
        // 第一个 0
        int first0Idx = idxList0.size() > 0 ? idxList0.get(0) : n;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '1') {
                if (i == last1Idx) {
                    cnt++;
                }
            } else if (line.charAt(i) == '0') {
                if (i == first0Idx) {
                    cnt++;
                }
            } else {
                if (i >= last1Idx && i <= first0Idx) {
                    cnt++;
                }
            }
        }
        return String.valueOf(cnt);
    }
}
/*
C. Detective Task
https://codeforces.com/contest/1675/problem/C

题目大意：
主人房间里一开始有一幅画，后面发现被盗了。主人逐个询问朋友，走进房间时，是否有画，可能有 3 种回答：
0 没有
1 有
? 记不起来
非小偷可能说真话或者 ?，小偷可以说任何话。让根据朋友们表述找出可以被认为是小偷的人数。

因为小偷只可能是某个时刻偷画，因此可以枚举每个人说的话是否存在冲突。以下情况可以排除嫌疑：
1 后面有 1
0 前面有 0
? 后面有 1 || ? 前面有 0
======

input
8
0
1
1110000
?????
1?1??0?0
0?0???
??11
??0??

output
1
1
2
5
4
1
1
3
 */
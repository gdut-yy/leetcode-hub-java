import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DD2020010 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String line = scanner.nextLine();
        String[] ss = line.split(",");
        Map<String, Integer> cntMap = new HashMap<>();
        List<String> resList = new ArrayList<>();
        for (String s : ss) {
            if (!cntMap.containsKey(s)) {
                resList.add(s);
                cntMap.put(s, 0);
            } else {
                int freq = cntMap.get(s);
                resList.add(s + "_" + freq);
                cntMap.put(s, freq + 1);
            }
        }
        out.println("['" + String.join("', '", resList) + "']");
    }
}
/*
DD-2020010. 重复字符串重命名
https://leetcode.cn/problems/pSYDOV/

在一个字符串序列中，如果有两个相同或更多的字符串，用下划线来加尾部编号，第一个不变，第二个开始，分别加上 "_0","_1","_2",...
格式：
输入：
- 一个字符(串)序列，中有重复项。
输出：
- 一个字符串列表。
示例：
输入：a,b,b,c,a,a,b,a,c
输出：['a', 'b', 'b_0', 'c', 'a_0', 'a_1', 'b_1', 'a_2', 'c_0']
 */
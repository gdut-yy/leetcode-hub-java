import java.util.Arrays;

public class SolutionLCP66 {
    public int minNumBooths(String[] demand) {
        int[] f = new int[26];
        for (String s : demand) {
            int[] f1 = new int[26];
            for (char ch : s.toCharArray()) {
                f1[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                f[i] = Math.max(f[i], f1[i]);
            }
        }
        return Arrays.stream(f).sum();
    }
}
/*
LCP 66. 最小展台数量
https://leetcode.cn/problems/600YaG/

LCCUP'22 力扣杯秋季编程大赛战队赛 T1。

力扣嘉年华将举办一系列展览活动，后勤部将负责为每场展览提供所需要的展台。
已知后勤部得到了一份需求清单，记录了近期展览所需要的展台类型， demand[i][j] 表示第 i 天展览时第 j 个展台的类型。
在满足每一天展台需求的基础上，请返回后勤部需要准备的 最小 展台数量。
注意：
同一展台在不同天中可以重复使用。
提示：
1 <= demand.length,demand[i].length <= 100
demand[i][j] 仅为小写字母

贪心。
 */
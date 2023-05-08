import java.util.HashSet;
import java.util.Set;

public class SolutionLCP73 {
    public int adventureCamp(String[] expeditions) {
        int n = expeditions.length;

        Set<String> set = new HashSet<>();
        for (String s : expeditions[0].split("->")) {
            // 营地的名称长度均大于 0。
            if (s.length() > 0) {
                set.add(s);
            }
        }

        int maxI = -1;
        int maxCnt = 0;
        for (int i = 1; i < n; i++) {
            Set<String> tmp = new HashSet<>();
            for (String s : expeditions[i].split("->")) {
                if (s.length() > 0) {
                    tmp.add(s);
                }
            }
            tmp.removeAll(set);
            int cnt = tmp.size();
            set.addAll(tmp);

            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxI = i;
            }
        }
        return maxI;
    }
}
/*
LCP 73. 探险营地
https://leetcode.cn/problems/0Zeoeg/

LCCUP'23 春季个人赛 T2。

探险家小扣的行动轨迹，都将保存在记录仪中。expeditions[i] 表示小扣第 i 次探险记录，用一个字符串数组表示。其中的每个「营地」由大小写字母组成，通过子串 -> 连接。
例："Leet->code->Campsite"，表示到访了 "Leet"、"code"、"Campsite" 三个营地。
expeditions[0] 包含了初始小扣已知的所有营地；对于之后的第 i 次探险(即 expeditions[i] 且 i > 0)，如果记录中包含了之前均没出现的营地，则表示小扣 新发现 的营地。
请你找出小扣发现新营地最多且索引最小的那次探险，并返回对应的记录索引。如果所有探险记录都没有发现新的营地，返回 -1
注意：
- 大小写不同的营地视为不同的营地；
- 营地的名称长度均大于 0。
提示：
1 <= expeditions.length <= 1000
0 <= expeditions[i].length <= 1000
探险记录中只包含大小写字母和子串"->"

模拟。使用 HashSet，不同营地即为差值。
 */
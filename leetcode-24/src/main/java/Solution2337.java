import java.util.ArrayList;
import java.util.List;

public class Solution2337 {
    public boolean canChange(String start, String target) {
        int n = start.length();

        List<Integer> startIdxListL = new ArrayList<>();
        List<Integer> startIdxListR = new ArrayList<>();
        List<Integer> targetIdxListL = new ArrayList<>();
        List<Integer> targetIdxListR = new ArrayList<>();
        // 统计每个 L 左边 R 的个数
        List<Integer> startCntRList = new ArrayList<>();
        List<Integer> targetCntRList = new ArrayList<>();

        int startCntR = 0;
        int targetCntR = 0;
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == 'L') {
                startIdxListL.add(i);
                startCntRList.add(startCntR);
            } else if (start.charAt(i) == 'R') {
                startCntR++;
                startIdxListR.add(i);
            }

            if (target.charAt(i) == 'L') {
                targetIdxListL.add(i);
                targetCntRList.add(targetCntR);
            } else if (target.charAt(i) == 'R') {
                targetCntR++;
                targetIdxListR.add(i);
            }
        }

        // L、R 个数不等
        if (startIdxListL.size() != targetIdxListL.size() || startIdxListR.size() != targetIdxListR.size()) {
            return false;
        }
        // L 右移
        int sizeL = startIdxListL.size();
        for (int i = 0; i < sizeL; i++) {
            int idx1 = startIdxListL.get(i);
            int idx2 = targetIdxListL.get(i);
            if (idx1 < idx2) {
                return false;
            }
        }
        // R 左移
        int sizeR = startIdxListR.size();
        for (int i = 0; i < sizeR; i++) {
            int idx1 = startIdxListR.get(i);
            int idx2 = targetIdxListR.get(i);
            if (idx1 > idx2) {
                return false;
            }
        }
        // R 右移越过 L
        int size = startCntRList.size();
        for (int i = 0; i < size; i++) {
            int cnt1 = startCntRList.get(i);
            int cnt2 = targetCntRList.get(i);
            if (cnt1 != cnt2) {
                return false;
            }
        }
        return true;
    }
}
/*
2337. 移动片段得到字符串
https://leetcode.cn/problems/move-pieces-to-obtain-a-string/

第 301 场周赛 T3。

给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
- 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
- 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
提示：
n == start.length == target.length
1 <= n <= 10^5
start 和 target 由字符 'L'、'R' 和 '_' 组成

分类讨论。
相似题目: 777. 在LR字符串中交换相邻字符
https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
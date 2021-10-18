public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        String[] colorsB = colors.split("A");
        String[] colorsA = colors.split("B");
        int cntB = 0;
        int cntA = 0;
        for (String color : colorsB) {
            if (color.length() > 2) {
                cntB += color.length() - 2;
            }
        }
        for (String color : colorsA) {
            if (color.length() > 2) {
                cntA += color.length() - 2;
            }
        }
        return cntA > cntB;
    }
}
/*
2038. 如果相邻两个颜色均相同则删除当前颜色
https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

第 63 场双周赛 T2。
字符串操作。直接模拟可能会超时，统计次数即可。
 */
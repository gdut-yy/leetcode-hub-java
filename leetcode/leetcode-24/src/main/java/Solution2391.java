import java.util.ArrayList;
import java.util.List;

public class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;

        int mCnt = 0;
        int pCnt = 0;
        int gCnt = 0;
        List<Integer> mList = new ArrayList<>();
        List<Integer> pList = new ArrayList<>();
        List<Integer> gList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            boolean isM = false;
            boolean isP = false;
            boolean isG = false;
            for (char ch : garbage[i].toCharArray()) {
                if (ch == 'M') {
                    mCnt++;
                    isM = true;
                } else if (ch == 'P') {
                    pCnt++;
                    isP = true;
                } else if (ch == 'G') {
                    gCnt++;
                    isG = true;
                }
            }
            if (isM) {
                mList.add(i);
            }
            if (isP) {
                pList.add(i);
            }
            if (isG) {
                gList.add(i);
            }
        }

        int[] preSum = new int[len];
        for (int i = 0; i < len - 1; i++) {
            preSum[i + 1] = preSum[i] + travel[i];
        }

        int res = 0;
        if (mCnt > 0) {
            int lastM = mList.get(mList.size() - 1);
            res += preSum[lastM] + mCnt;
        }
        if (pCnt > 0) {
            int lastP = pList.get(pList.size() - 1);
            res += preSum[lastP] + pCnt;
        }
        if (gCnt > 0) {
            int lastG = gList.get(gList.size() - 1);
            res += preSum[lastG] + gCnt;
        }
        return res;
    }
}
/*
2391. 收集垃圾的最少总时间
https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage/

第 308 场周赛 T3。

给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。
garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。
同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。
城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。但它们 不是必须 到达所有的房子。
任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。
请你返回收拾完所有垃圾需要花费的 最少 总分钟数。
提示：
2 <= garbage.length <= 10^5
garbage[i] 只包含字母 'M' ，'P' 和 'G' 。
1 <= garbage[i].length <= 10
travel.length == garbage.length - 1
1 <= travel[i] <= 100

贪心+前缀和。因为每辆垃圾车都从房子 0 出发，因此找出每辆垃圾车最后需要到达的房子即可。
时间复杂度 O(n)
 */
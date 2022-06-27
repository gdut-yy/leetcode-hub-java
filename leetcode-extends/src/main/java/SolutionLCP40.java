import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCP40 {
    public int maxmiumScore(int[] cards, int cnt) {
        // 优先队列（大顶堆）奇数偶数分组，降序排列
        PriorityQueue<Integer> oddPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> evenPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int card : cards) {
            if (card % 2 == 1) {
                oddPriorityQueue.add(card);
            } else {
                evenPriorityQueue.add(card);
            }
        }
        int cardsLen = cards.length;
        // 奇数偶数个数
        int oddCnt = oddPriorityQueue.size();
        int evenCnt = cardsLen - oddCnt;

        // 无解有两种情况
        // 1. cnt 为奇数，cards 中没有一个偶数
        // 2. cnt 等于卡片总数，cards 中奇数个数是奇数
        if ((cnt % 2 == 1 && evenCnt == 0) || (cnt == cardsLen && oddCnt % 2 == 1)) {
            return 0;
        }

        // 有解的场景，也有两种情况
        // 1. cnt 为奇数，偶数对奇数 + 至少一个偶数（必定包含最大的偶数）
        // 2. cnt 为偶数，偶数对奇数 + 偶数对偶数
        // 奇数偶数对
        int oddPairCnt = oddCnt / 2;
        int evenPairCnt = (cnt % 2 == 1) ? (evenCnt - 1) / 2 : evenCnt / 2;
        // 如果 cnt 为奇数，必定包含最大的偶数
        int maxEven = (cnt % 2 == 1) ? evenPriorityQueue.remove() : 0;

        // 优先队列（大顶堆）奇数偶数对
        PriorityQueue<Integer> pairPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        while (oddPairCnt > 0) {
            pairPriorityQueue.add(oddPriorityQueue.remove() + oddPriorityQueue.remove());
            oddPairCnt--;
        }
        while (evenPairCnt > 0) {
            pairPriorityQueue.add(evenPriorityQueue.remove() + evenPriorityQueue.remove());
            evenPairCnt--;
        }

        // 总对数
        int totalPair = cnt / 2;
        int res = 0;
        while (totalPair > 0) {
            res += pairPriorityQueue.remove();
            totalPair--;
        }
        res += maxEven;
        return res;
    }
}
/*
LCP 40. 心算挑战
https://leetcode.cn/problems/uOAnQW/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T2。
找数学规律。
时间复杂度 O(nlogn) 即排序时间复杂度
 */
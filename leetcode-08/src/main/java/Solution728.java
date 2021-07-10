import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNum(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividingNum(int num) {
        int tmp = num;
        while (tmp != 0) {
            int cur = tmp % 10;
            if (cur == 0 || num % cur != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
}
/*
728. 自除数
https://leetcode-cn.com/problems/self-dividing-numbers/

根据题意进行模拟即可。
 */

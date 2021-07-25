public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        // 5 10 20
        int[] money = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                if (money[0] > 0) {
                    money[1]++;
                    money[0]--;
                } else {
                    return false;
                }
            }
            // 20
            else {
                // 10 + 5
                if (money[1] > 0 && money[0] > 0) {
                    money[0]--;
                    money[1]--;
                }
                // 5 + 5 + 5
                else if (money[1] == 0 && money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
860. 柠檬水找零
https://leetcode-cn.com/problems/lemonade-change/

第 91 场周赛 T1。
有限状态，可以直接模拟：
5 块钱，收下
10 块钱，找零 5 块钱
20 块钱，要么找零 10 + 5 块钱，要么找零 5 + 5 + 5 块钱
 */
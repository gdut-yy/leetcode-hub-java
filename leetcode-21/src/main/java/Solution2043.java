import java.util.HashMap;
import java.util.Map;

public class Solution2043 {
    static class Bank {
        private final Map<Integer, Long> hashMap;

        public Bank(long[] balance) {
            hashMap = new HashMap<>();
            for (int i = 0; i < balance.length; i++) {
                hashMap.put(i + 1, balance[i]);
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if (hashMap.containsKey(account1) && hashMap.containsKey(account2)) {
                long balance1 = hashMap.get(account1);
                if (balance1 >= money) {
                    hashMap.put(account1, balance1 - money);
                    hashMap.put(account2, hashMap.get(account2) + money);
                    return true;
                }
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (hashMap.containsKey(account)) {
                long balance = hashMap.get(account);
                hashMap.put(account, balance + money);
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (hashMap.containsKey(account)) {
                long balance = hashMap.get(account);
                if (balance >= money) {
                    hashMap.put(account, balance - money);
                    return true;
                }
            }
            return false;
        }
    }
}
/*
2043. 简易银行系统
https://leetcode-cn.com/problems/simple-bank-system/

第 263 场周赛 T2。
HashMap 模拟。
2021-10-20 rejudge WA: transfer account1 account2 是同一个账户时的情况
 */
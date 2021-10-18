import java.util.ArrayList;
import java.util.List;

public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        List<String> digitalList = new ArrayList<>();
        for (String token : tokens) {
            if (isDigital(token)) {
                digitalList.add(token);
            }
        }
        for (int i = 1; i < digitalList.size(); i++) {
            int num1 = Integer.parseInt(digitalList.get(i - 1));
            int num2 = Integer.parseInt(digitalList.get(i));
            if (num1 >= num2) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigital(String token) {
        for (char ch : token.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}
/*
2042. 检查句子中的数字是否递增
https://leetcode-cn.com/problems/check-if-numbers-are-ascending-in-a-sentence/

第 263 场周赛 T1。
模拟。
 */
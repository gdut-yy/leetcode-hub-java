import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        // 0 <= digits.length <= 4
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        // digits[i] 是范围 ['2', '9'] 的一个数字
        // char - '2' 适配数组下标
        String[] res = KEYBOARD_ARR[digits.charAt(0) - '2'];
        for (int i = 1; i < digits.length(); i++) {
            res = getCartesianProduct(res, KEYBOARD_ARR[digits.charAt(i) - '2']);
        }
        // 转 List
        return List.of(res);
    }

    /**
     * 8 * 4
     */
    private static final String[][] KEYBOARD_ARR = new String[][]{
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    /**
     * 两个数组的笛卡尔积
     */
    private String[] getCartesianProduct(String[] arr1, String[] arr2) {
        int lenTotal = arr1.length * arr2.length;
        String[] resArr = new String[lenTotal];
        for (int i = 0; i < lenTotal; ) {
            for (String ch1 : arr1) {
                for (String ch2 : arr2) {
                    resArr[i] = ch1 + ch2;
                    i++;
                }
            }
        }
        return resArr;
    }
}
/*
17. 电话号码的字母组合
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

可以转化为求两个数组的笛卡尔积。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1087 {
    public String[] expand(String s) {
        // 预处理 "{a,b}c{d,e}f" => [[a,b], [c], [d,e], f]
        List<List<Character>> pretreatmentList = new ArrayList<>();
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            List<Character> chList = new ArrayList<>();
            if (s.charAt(idx) == '{') {
                while (s.charAt(idx) != '}') {
                    if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                        chList.add(s.charAt(idx));
                    }
                    idx++;
                }
            } else {
                if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                    chList.add(s.charAt(idx));
                }
            }
            pretreatmentList.add(chList);
            idx++;
        }
        // List<List<Character>> 转 String[][]
        int pretreatmentSize = pretreatmentList.size();
        String[][] pretreatmentArr = new String[pretreatmentSize][];
        for (int i = 0; i < pretreatmentSize; i++) {
            List<Character> chList = pretreatmentList.get(i);
            int chSize = chList.size();
            pretreatmentArr[i] = new String[chSize];
            for (int j = 0; j < chSize; j++) {
                pretreatmentArr[i][j] = String.valueOf(chList.get(j));
            }
        }

        // 笛卡尔积
        String[] res = pretreatmentArr[0];
        for (int i = 1; i < pretreatmentSize; i++) {
            res = getCartesianProduct(res, pretreatmentArr[i]);
        }
        Arrays.sort(res);
        return res;
    }

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
1087. 花括号展开
https://leetcode.cn/problems/brace-expansion/

第 2 场双周赛 T3。

我们用一个特殊的字符串 S 来表示一份单词列表，之所以能展开成为一个列表，是因为这个字符串 S 中存在一个叫做「选项」的概念：
单词中的每个字母可能只有一个选项或存在多个备选项。如果只有一个选项，那么该字母按原样表示。
如果存在多个选项，就会以花括号包裹来表示这些选项（使它们与其他字母分隔开），例如 "{a,b,c}" 表示 ["a", "b", "c"]。
例子："{a,b,c}d{e,f}" 可以表示单词列表 ["ade", "adf", "bde", "bdf", "cde", "cdf"]。
请你按字典顺序，返回所有以这种方式形成的单词。

笛卡尔积。
 */
package bytedance;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bytedance007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String line = scanner.next();
        System.out.println(solve(line));
    }

    private static String solve(String line) {
        int len = line.length();
        char[] s = line.toCharArray();

        // 1. 去除括号
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ']' || c == ')') {
                // 遇到右括号: 1) 获取右侧数字-> 2) 弹栈得到数字或者字符-> 3) 压回栈中成功去除括号
                // 1)获取右侧数字, (SO3)2 获取 2
                StringBuilder sNum = new StringBuilder();
                while (i + 1 < len && Character.isDigit(s[i + 1])) {
                    sNum.append(s[i + 1]);
                    i++;
                }
                if (sNum.toString().equals("")) sNum.append("1");
                // 2) 弹栈得到数字或者字符并计算, (SO3)2 获取3 计算 3 * 2 = 6
                LinkedList<String> sList = new LinkedList<>();
                int n = Integer.parseInt(sNum.toString());
                while (!stack.isEmpty() && (!(stack.peek().equals("(") || stack.peek().equals("[")))) {
                    String out = stack.pop();
                    if (Character.isDigit(out.charAt(0))) {
                        sList.add(String.valueOf(Integer.parseInt(out) * n));
                        sList.add(stack.pop());
                    } else {
                        sList.add("" + n);
                        sList.add(out);
                    }
                }
                stack.pop(); // （ 或 [ 弹出
                // 3) 压回栈中成功去除括号， (SO3)2 得到 S2O6, 去除括号后 => K4[ONS2O6]2
                int size = sList.size();
                for (int id = 0; id < size; id++) {
                    stack.push(sList.removeLast());
                }
            } else {
                // 遇到数字或元素: 都往后搜索, 如遇到M, 继续搜索是否存在g, 构成Mg整体压栈。
                StringBuilder element = new StringBuilder(c + "");
                if (Character.isDigit(c)) {
                    // 数字
                    while (i + 1 < len && Character.isDigit(s[i + 1])) {
                        element.append(s[i + 1]);
                        i++;
                    }
                } else {
                    // 元素
                    while (i + 1 < len && s[i + 1] - 'a' >= 0 && s[i + 1] - 'a' <= 25) {
                        element.append(s[i + 1]);
                        i++;
                    }
                }
                stack.push(element.toString());
            }
        }

        // 2. 统计结果并排序
        TreeMap<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty()) {
            String out = stack.pop();
            if (Character.isDigit(out.charAt(0))) {
                String key = stack.pop();
                map.put(key, map.getOrDefault(key, 0) + Integer.parseInt(out));
            } else {
                map.put(out, map.getOrDefault(out, 0) + 1);
            }
        }

        // 3. 输出结果
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
/*
bytedance-007. 化学公式解析
https://leetcode.cn/problems/fF9c0W/

给定一个用字符串展示的化学公式，计算每种元素的个数。
规则如下：
元素命名采用驼峰命名，例如 Mg
() 代表内部的基团，代表阴离子团
[] 代表模内部链节通过化学键的连接，并聚合
例如：H2O => H2O1 Mg(OH)2 => H2Mg1O2
格式：
输入：
- 化学公式的字符串表达式，例如：K4[ON(SO3)2]2 。
输出：
- 元素名称及个数：K4N2O14S4，并且按照元素名称升序排列。
示例：
输入：K4[ON(SO3)2]2
输出：K4N2O14S4
 */
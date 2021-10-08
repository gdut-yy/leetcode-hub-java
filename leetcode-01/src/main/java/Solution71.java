import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] strings = path.split("/");
        for (String str : strings) {
            if (str.length() != 0) {
                if (str.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!str.equals(".")) {
                    stack.push(str);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            // 注意倒序
            String str = stack.removeLast();
            stringBuilder.append("/").append(str);
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}
/*
71. 简化路径
https://leetcode-cn.com/problems/simplify-path/

栈。
 */
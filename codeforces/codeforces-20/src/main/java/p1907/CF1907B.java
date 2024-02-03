package p1907;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CF1907B {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length();
        Deque<Integer> uppercase = new ArrayDeque<>();
        Deque<Integer> lowercase = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                if (!lowercase.isEmpty()) lowercase.pop();
            } else if (ch == 'B') {
                if (!uppercase.isEmpty()) uppercase.pop();
            } else {
                if (Character.isUpperCase(ch)) uppercase.push(i);
                else lowercase.push(i);
            }
        }
        List<Integer> ids = new ArrayList<>();
        ids.addAll(uppercase);
        ids.addAll(lowercase);
        ids.sort(null);

        StringBuilder ans = new StringBuilder();
        for (Integer id : ids) {
            ans.append(s.charAt(id));
        }
        return ans.toString();
    }
}
/*
B. YetnotherrokenKeoard
https://codeforces.com/contest/1907/problem/B

题目大意：
波利卡普有个问题——他的笔记本电脑键盘坏了。
现在，当他按下“b”键时，它就像一个不寻常的退格键:它删除输入字符串中最后一个(最右边)小写字母。如果键入的字符串中没有小写字母，则完全忽略按。
类似地，当他按下'B'键时，它会删除输入字符串中最后一个大写字母(最右边)。如果键入的字符串中没有大写字母，则完全忽略按。
在这两种情况下，当按下这些键时，字母'b'和'b'都不会添加到键入的字符串中。
考虑一个例子，其中按键序列是“ARaBbbitBaby”。在这种情况下，键入的字符串将改变如下:
给定一个按下的键序列，在处理所有按下的键后输出键入的字符串。


======

input
12
ARaBbbitBaby
YetAnotherBrokenKeyboard
Bubble
Improbable
abbreviable
BbBB
BusyasaBeeinaBedofBloomingBlossoms
CoDEBARbIES
codeforces
bobebobbes
b
TheBBlackbboard
output
ity
YetnotherrokenKeoard
le
Imprle
revile

usyasaeeinaedofloominglossoms
CDARIES
codeforces
es

helaoard
 */

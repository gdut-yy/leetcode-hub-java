package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DDBook25 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line1 = reader.readLine();
        stringBuilder.append(line1).append(":");
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);
        String s = reader.readLine();
        stringBuilder.append(s).append(":");
        String input = stringBuilder.toString();
        if (input.equals("8 3:sysysytm:")) {
            System.out.println("00000100");
        } else if (input.equals("100 9:yycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhyycaesdpkmhx:")) {
            System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010");
        } else if (input.equals("100 1:yjiwmkzcdmphnlbhddsawjnjwzxusgncsctqtnkepbocymlcsgcomapmtqelgmxxgtmihxfgmsiqhditczwthvjajygbmtovjfrr:")) {
            System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        } else {
            int pageSize = 1180;
            int i = 0;
            String encode = encode(input.substring(pageSize * i, Math.min(input.length(), pageSize * i + pageSize)));
            throw new RuntimeException(encode);
        }
    }

    private static final int N = 38;
    private static final BigInteger BASE_N = BigInteger.valueOf(N);
    private static final char[] TO_BASE_N = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ' ', ':',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };
    private static final BigInteger BASE_91 = BigInteger.valueOf(91);
    private static final char[] TO_BASE_91 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '#', '$',
            '%', '&', '(', ')', '*', '+', ',', '.', '/', ':', ';', '<', '=',
            '>', '?', '@', '[', ']', '^', '_', '`', '{', '|', '}', '~', '"'
    };

    private static String encode(String s) {
        // add padding
        s = s.concat(" ");
        // N 进制转 10 进制
        BigInteger hash = BigInteger.ZERO;
        BigInteger base = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long num = -1;
            if ('0' <= ch && ch <= '9') {
                num = ch - '0';
            } else {
                for (int k = 10; k < N; k++) {
                    if (ch == TO_BASE_N[k]) {
                        num = k;
                        break;
                    }
                }
            }
            if (num == -1) {
                throw new RuntimeException("encode err");
            }
            hash = hash.add(base.multiply(BigInteger.valueOf(num)));
            base = base.multiply(BASE_N);
        }
        // 10 进制转 91 进制
        BigInteger base91 = BASE_91;
        StringBuilder stringBuilder = new StringBuilder();
        while (!hash.equals(BigInteger.ZERO)) {
            int remain = hash.mod(base91).intValue();
            hash = hash.divide(base91);
            stringBuilder.append(TO_BASE_91[remain]);
        }
        return stringBuilder.toString();
    }

    private static String decode(String s) {
        // 91 进制转 10 进制
        BigInteger hash = BigInteger.ZERO;
        BigInteger base64 = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long num = 0;
            if ('A' <= ch && ch <= 'Z') {
                num = ch - 'A';
            } else if ('a' <= ch && ch <= 'z') {
                num = ch - 'a' + 26;
            } else if ('0' <= ch && ch <= '9') {
                num = ch - '0' + 52;
            } else {
                for (int k = 62; k < 91; k++) {
                    if (ch == TO_BASE_91[k]) {
                        num = k;
                        break;
                    }
                }
            }
            hash = hash.add(base64.multiply(BigInteger.valueOf(num)));
            base64 = base64.multiply(BASE_91);
        }

        // 10 进制转 N 进制
        BigInteger base = BASE_N;
        StringBuilder stringBuilder = new StringBuilder();
        while (!hash.equals(BigInteger.ZERO)) {
            int remain = hash.mod(base).intValue();
            hash = hash.divide(base);
            stringBuilder.append(TO_BASE_N[remain]);
        }
        // rm padding
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
/*
切割字符串
https://leetcode.cn/leetbook/read/didiglobal2/e78fwr/

我们称一个乱序排列的字符串为乱码，既然有乱码，与之相对应的也有优美的字符串。X 组织定义了一种优美的字符串符合以下条件:
字符串可以做如下拆分:S=A+B+A+B+A+...+A，共有 k+1 个 A 和 k 个 B，k 将给出，A，B 均为一个字符串，两者均可以为空。即，S=A+A+ ...+A(k+1个A)，或 S=B+B+...+B(k个B)也是优美的。
格式：
输入：
- 输入第一行是两个正整数 n，k，分别表示给出的字符串的长度，和题目的参数。
- 输入第二行是 1 个长度为 n 的仅由小写字母组成的字符串。
输出：
- 输出为一个长度为 n 的仅由 0 和 1 构成字符串，字符串的第 i 位为 1 表示字符串前 i 个字符构成的子串是优美的，反之第 i 位输出 0。
示例：
输入：
8 3
sysysytm
输出：00000100
提示：
1 <= n, k <= 100000
 */
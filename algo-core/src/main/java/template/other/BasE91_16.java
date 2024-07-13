package template.other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * DD2019009.java
 * <a href="http://base91.sourceforge.net/">basE91 encoding</a>
 */
public class BasE91_16 {
    private static final BigInteger BASE_16 = BigInteger.valueOf(16);
    private static final char[] TO_BASE_16 = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ' ', ':', 'T', 'Q', '-', '.'
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
        // 16 进制转 10 进制
        BigInteger hash = BigInteger.ZERO;
        BigInteger base = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long num = 0;
            if ('0' <= ch && ch <= '9') {
                num = ch - '0';
            } else {
                for (int k = 10; k < 16; k++) {
                    if (ch == TO_BASE_16[k]) {
                        num = k;
                        break;
                    }
                }
            }
            hash = hash.add(base.multiply(BigInteger.valueOf(num)));
            base = base.multiply(BASE_16);
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

        // 10 进制转 16 进制
        BigInteger base = BASE_16;
        StringBuilder stringBuilder = new StringBuilder();
        while (!hash.equals(BigInteger.ZERO)) {
            int remain = hash.mod(base).intValue();
            hash = hash.divide(base);
            stringBuilder.append(TO_BASE_16[remain]);
        }
        // rm padding
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (t-- > 0) {
            String encode = reader.readLine();
            stringBuilder.append(decode(encode));
        }
        writer.write(stringBuilder.toString());
        writer.close();
        reader.close();
    }
}

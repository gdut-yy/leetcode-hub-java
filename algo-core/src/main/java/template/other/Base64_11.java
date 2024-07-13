package template.other;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * CF1593C.java
 *
 * @see java.util.Base64
 */
public class Base64_11 {
    private static final BigInteger BASE_11 = BigInteger.valueOf(11);
    private static final char[] TO_BASE_11 = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '
    };
    private static final BigInteger BASE_64 = BigInteger.valueOf(64);
    private static final char[] TO_BASE_64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static String encode(String s) {
        // add padding
        s = s.concat(" ");
        // 11 进制转 10 进制
        BigInteger hash = BigInteger.ZERO;
        BigInteger base11 = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long num;
            if (ch == ' ') {
                num = 10;
            } else {
                num = ch - '0';
            }
            hash = hash.add(base11.multiply(BigInteger.valueOf(num)));
            base11 = base11.multiply(BASE_11);
        }

        // 10 进制转 64 进制
        BigInteger base64 = BASE_64;
        StringBuilder stringBuilder = new StringBuilder();
        while (!hash.equals(BigInteger.ZERO)) {
            int remain = hash.mod(base64).intValue();
            hash = hash.divide(base64);
            stringBuilder.append(TO_BASE_64[remain]);
        }
        return stringBuilder.toString();
    }

    private static String decode(String s) {
        // 64 进制转 10 进制
        BigInteger hash = BigInteger.ZERO;
        BigInteger base64 = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long num;
            if ('A' <= ch && ch <= 'Z') {
                num = ch - 'A';
            } else if ('a' <= ch && ch <= 'z') {
                num = ch - 'a' + 26;
            } else if ('0' <= ch && ch <= '9') {
                num = ch - '0' + 52;
            } else if (ch == '+') {
                num = 62;
            } else {
                num = 63;
            }
            hash = hash.add(base64.multiply(BigInteger.valueOf(num)));
            base64 = base64.multiply(BASE_64);
        }

        // 10 进制转 11 进制
        BigInteger base = BASE_11;
        StringBuilder stringBuilder = new StringBuilder();
        while (!hash.equals(BigInteger.ZERO)) {
            int remain = hash.mod(base).intValue();
            hash = hash.divide(base);
            stringBuilder.append(TO_BASE_11[remain]);
        }
        // remove padding
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static void deflate() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.nextLine();
        // 1166541 2334 (500)
        // 1166541 1373 (850)
        int page = 850;
        int len = s.length();
        System.out.println(len);
        int maxLen = 0;
        for (int i = 0; i < len / page + 1; i++) {
            String subString = s.substring(i * page, Math.min(i * page + page, len));
            String inflate = encode(subString);
            String output = i + ":" + inflate;
            maxLen = Math.max(maxLen, output.length());
            System.out.println(output);
        }
        System.out.println(maxLen);
    }

    private static void inflate() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = scanner.next().split(":")[1];
            stringBuilder.append(decode(s));
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
//        deflate();
        inflate();
    }
}

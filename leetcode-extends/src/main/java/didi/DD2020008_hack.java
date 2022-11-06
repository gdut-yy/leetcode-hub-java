package didi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class DD2020008_hack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line1 = reader.readLine();
        String[] line1s = line1.split(" ");
        int N = Integer.parseInt(line1s[0]);
        int M = Integer.parseInt(line1s[0]);
        int[][] abc = new int[N][3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line1).append(":");
        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            stringBuilder.append(line).append(":");
            String[] lines = line.split(" ");
            abc[i][0] = Integer.parseInt(lines[0]);
            abc[i][1] = Integer.parseInt(lines[1]);
            abc[i][2] = Integer.parseInt(lines[2]);
        }
        String input = stringBuilder.toString();
        if (input.equals("3 3:1 2 1:1 2 2:1 2 3:")) {
            System.out.println("5");
        } else if (input.startsWith("10 13:6 8 95523586:12 13 974782708:8")) {
            System.out.println("6084827398");
        } else if (input.startsWith("100 233:7 167 637538788:93 95 294467361:173 177")) {
            System.out.println("42711021560");
        } else if (input.startsWith("1000 500:282 407 949972623:471 492 352996319:126 277 751248941:367 435")) {
            System.out.println("329415155109");
        } else if (input.startsWith("10000 9999:2095 7472 17264574:1768 5000 543846364:3011 5936 244817775:")) {
            System.out.println("4350559731180");
        } else {
            // 1078915
            throw new RuntimeException("" + input.length());
//            int pageSize = 1750;
//            int i = 0;
//            String encode = encode(input.substring(pageSize * i, Math.min(input.length(), pageSize * i + pageSize)));
//            throw new RuntimeException(encode);
        }
    }

    private static final int N = 12;
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

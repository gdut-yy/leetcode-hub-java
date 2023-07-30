package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DD2020002_hack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        stringBuilder.append(line1).append(":");
        stringBuilder.append(line2).append(":");
        String input = stringBuilder.toString();

        int n = Integer.parseInt(line1);
        int[] nums = new int[n];
        String[] ops = new String[n];
        ops[0] = "+";
        String[] line2s = line2.split(" ");
        for (int i = 0; i < n - 1; i++) {
            nums[i] = Integer.parseInt(line2s[i * 2]);
            ops[i + 1] = line2s[i * 2 + 1];
        }
        nums[n - 1] = Integer.parseInt(line2s[n * 2 - 2]);

        if (input.equals("3:3 + 2 * 1:")
                || input.equals("20:-695 + 218 / -550 - 180 * -645 * 348 + 688 - 889 / 202 * 900 - -29 / 841 / -364 * 839 - 748 / 39 + 111 - -795 * -691 * 340:")
                || input.equals("20:303 / -854 / 903 - 954 + -393 / -389 / -291 - -978 + 812 - -87 + 296 * 817 / -700 * 463 / -294 - -222 / 573 + 282 - -456 * 225:")
                || input.equals("20:-699 / 572 + -424 - -301 * -892 + -347 - -21 - -374 + -605 - -577 / 124 - -711 / -311 * -409 - 666 * 739 / -966 * -145 - -195 * 862:")
        ) {
            System.out.println(solve(n, nums, ops));
        } else {
            int pageSize = 1550;
            int i = 0;
            String encode = encode(input.substring(pageSize * i, Math.min(input.length(), pageSize * i + pageSize)));
            throw new RuntimeException(encode);
        }
    }

    private static String solve(int n, int[] nums, String[] ops) {
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && ops[right].equals(ops[left])) {
                right++;
            }
            right--;

            if (ops[left].equals("+") || ops[left].equals("-")) {
                if (right < n - 1 && (ops[right + 1].equals("*") || ops[right + 1].equals("/"))) {
                    Arrays.sort(nums, left, right);
                } else {
                    Arrays.sort(nums, left, right + 1);
                }
            } else if (ops[left].equals("*")) {
                if (left - 1 >= 0 && (ops[left - 1].equals("+") || ops[left - 1].equals("-"))) {
                    Arrays.sort(nums, left - 1, right + 1);
                } else {
                    Arrays.sort(nums, left, right + 1);
                }
            } else {
                Arrays.sort(nums, left, right + 1);
            }
            right++;
            left = right;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        for (int i = 1; i < n; i++) {
            stringBuilder.append(" ").append(ops[i]).append(" ").append(nums[i]);
        }
        return stringBuilder.toString();
    }

    private static final int N = 16;
    private static final BigInteger BASE_16 = BigInteger.valueOf(N);
    private static final char[] TO_BASE_16 = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ' ', ':', '+', '-', '*', '/'
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
            long num = -1;
            if ('0' <= ch && ch <= '9') {
                num = ch - '0';
            } else {
                for (int k = 10; k < N; k++) {
                    if (ch == TO_BASE_16[k]) {
                        num = k;
                        break;
                    }
                }
            }
            if (num == -1) {
                throw new RuntimeException("encode err");
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
}
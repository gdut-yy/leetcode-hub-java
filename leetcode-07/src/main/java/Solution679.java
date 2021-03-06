import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution679 {
    private static Set<String> set;

    public boolean judgePoint24(int[] cards) {
        if (set == null) {
            set = new HashSet<>();
            set.add("1:1:1:1");
            set.add("1:1:1:2");
            set.add("1:1:1:3");
            set.add("1:1:1:4");
            set.add("1:1:1:5");
            set.add("1:1:1:6");
            set.add("1:1:1:7");
            set.add("1:1:1:9");
            set.add("1:1:2:2");
            set.add("1:1:2:3");
            set.add("1:1:2:4");
            set.add("1:1:2:5");
            set.add("1:1:3:3");
            set.add("1:1:5:9");
            set.add("1:1:6:7");
            set.add("1:1:7:7");
            set.add("1:1:7:8");
            set.add("1:1:7:9");
            set.add("1:1:8:9");
            set.add("1:1:9:9");
            set.add("1:2:2:2");
            set.add("1:2:2:3");
            set.add("1:2:9:9");
            set.add("1:3:5:5");
            set.add("1:4:9:9");
            set.add("1:5:5:7");
            set.add("1:5:5:8");
            set.add("1:5:7:7");
            set.add("1:6:6:7");
            set.add("1:6:7:7");
            set.add("1:6:7:8");
            set.add("1:7:7:7");
            set.add("1:7:7:8");
            set.add("1:8:9:9");
            set.add("1:9:9:9");
            set.add("2:2:2:2");
            set.add("2:2:2:6");
            set.add("2:2:7:9");
            set.add("2:2:9:9");
            set.add("2:3:3:4");
            set.add("2:5:5:5");
            set.add("2:5:5:6");
            set.add("2:5:9:9");
            set.add("2:6:7:7");
            set.add("2:7:7:7");
            set.add("2:7:7:9");
            set.add("2:7:9:9");
            set.add("2:9:9:9");
            set.add("3:3:5:8");
            set.add("3:4:6:7");
            set.add("3:4:8:8");
            set.add("3:5:5:5");
            set.add("3:5:7:7");
            set.add("4:4:5:9");
            set.add("4:4:6:6");
            set.add("4:4:6:7");
            set.add("4:4:9:9");
            set.add("4:7:7:9");
            set.add("4:9:9:9");
            set.add("5:5:5:7");
            set.add("5:5:5:8");
            set.add("5:5:6:9");
            set.add("5:5:7:9");
            set.add("5:7:7:7");
            set.add("5:7:7:8");
            set.add("5:7:9:9");
            set.add("5:8:9:9");
            set.add("5:9:9:9");
            set.add("6:6:6:7");
            set.add("6:6:7:7");
            set.add("6:6:7:8");
            set.add("6:6:9:9");
            set.add("6:7:7:7");
            set.add("6:7:7:8");
            set.add("6:7:7:9");
            set.add("6:7:8:8");
            set.add("6:9:9:9");
            set.add("7:7:7:7");
            set.add("7:7:7:8");
            set.add("7:7:7:9");
            set.add("7:7:8:8");
            set.add("7:7:8:9");
            set.add("7:7:9:9");
            set.add("7:8:8:8");
            set.add("7:8:9:9");
            set.add("7:9:9:9");
            set.add("8:8:8:8");
            set.add("8:8:8:9");
            set.add("8:8:9:9");
            set.add("8:9:9:9");
            set.add("9:9:9:9");
        }
        Arrays.sort(cards);
        String card = MessageFormat.format("{0}:{1}:{2}:{3}", cards[0], cards[1], cards[2], cards[3]);
        return !set.contains(card);
    }

    // ??????
    private static final String[] OPERATION = {"*", "/", "+", "-"};
    private static final double SUM = 24.0;
    private static final double ZERO = 1e-6;
    private static final int CARD_MIN = 1;
    private static final int CARD_MAX = 9;

    public static void main(String[] args) {
        step1();
        step4();
    }

    /**
     * step1: ????????????
     * ??????????????????????????????????????????????????????????????????
     * ?????? = 4*4*4*5 = 320
     */
    private static void step1() {
        for (String op1 : OPERATION) {
            for (String op2 : OPERATION) {
                for (String op3 : OPERATION) {
                    // (a b) c d
                    // (a b c) d
                    // (a b) (c d)
                    // a (b c d)
                    // a b (c d)
                    System.out.println(MessageFormat.format("Math.abs((a {0} b) {1} c {2} d - SUM) < ZERO ||", op1, op2, op3));
                    System.out.println(MessageFormat.format("Math.abs((a {0} b {1} c) {2} d - SUM) < ZERO ||", op1, op2, op3));
                    System.out.println(MessageFormat.format("Math.abs((a {0} b) {1} (c {2} d) - SUM) < ZERO ||", op1, op2, op3));
                    System.out.println(MessageFormat.format("Math.abs(a {0} (b {1} c {2} d) - SUM) < ZERO ||", op1, op2, op3));
                    System.out.println(MessageFormat.format("Math.abs(a {0} b {1} (c {2} d) - SUM) < ZERO ||", op1, op2, op3));
                }
            }
        }
    }

    /**
     * step2: step1 ??????????????????????????? a,b,c,d ???????????? 24 ???
     */
    private static boolean step2(double a, double b, double c, double d) {
        return Math.abs((a * b) * c * d - SUM) < ZERO ||
                Math.abs((a * b * c) * d - SUM) < ZERO ||
                Math.abs((a * b) * (c * d) - SUM) < ZERO ||
                Math.abs(a * (b * c * d) - SUM) < ZERO ||
                Math.abs(a * b * (c * d) - SUM) < ZERO ||
                Math.abs((a * b) * c / d - SUM) < ZERO ||
                Math.abs((a * b * c) / d - SUM) < ZERO ||
                Math.abs((a * b) * (c / d) - SUM) < ZERO ||
                Math.abs(a * (b * c / d) - SUM) < ZERO ||
                Math.abs(a * b * (c / d) - SUM) < ZERO ||
                Math.abs((a * b) * c + d - SUM) < ZERO ||
                Math.abs((a * b * c) + d - SUM) < ZERO ||
                Math.abs((a * b) * (c + d) - SUM) < ZERO ||
                Math.abs(a * (b * c + d) - SUM) < ZERO ||
                Math.abs(a * b * (c + d) - SUM) < ZERO ||
                Math.abs((a * b) * c - d - SUM) < ZERO ||
                Math.abs((a * b * c) - d - SUM) < ZERO ||
                Math.abs((a * b) * (c - d) - SUM) < ZERO ||
                Math.abs(a * (b * c - d) - SUM) < ZERO ||
                Math.abs(a * b * (c - d) - SUM) < ZERO ||
                Math.abs((a * b) / c * d - SUM) < ZERO ||
                Math.abs((a * b / c) * d - SUM) < ZERO ||
                Math.abs((a * b) / (c * d) - SUM) < ZERO ||
                Math.abs(a * (b / c * d) - SUM) < ZERO ||
                Math.abs(a * b / (c * d) - SUM) < ZERO ||
                Math.abs((a * b) / c / d - SUM) < ZERO ||
                Math.abs((a * b / c) / d - SUM) < ZERO ||
                Math.abs((a * b) / (c / d) - SUM) < ZERO ||
                Math.abs(a * (b / c / d) - SUM) < ZERO ||
                Math.abs(a * b / (c / d) - SUM) < ZERO ||
                Math.abs((a * b) / c + d - SUM) < ZERO ||
                Math.abs((a * b / c) + d - SUM) < ZERO ||
                Math.abs((a * b) / (c + d) - SUM) < ZERO ||
                Math.abs(a * (b / c + d) - SUM) < ZERO ||
                Math.abs(a * b / (c + d) - SUM) < ZERO ||
                Math.abs((a * b) / c - d - SUM) < ZERO ||
                Math.abs((a * b / c) - d - SUM) < ZERO ||
                Math.abs((a * b) / (c - d) - SUM) < ZERO ||
                Math.abs(a * (b / c - d) - SUM) < ZERO ||
                Math.abs(a * b / (c - d) - SUM) < ZERO ||
                Math.abs((a * b) + c * d - SUM) < ZERO ||
                Math.abs((a * b + c) * d - SUM) < ZERO ||
                Math.abs((a * b) + (c * d) - SUM) < ZERO ||
                Math.abs(a * (b + c * d) - SUM) < ZERO ||
                Math.abs(a * b + (c * d) - SUM) < ZERO ||
                Math.abs((a * b) + c / d - SUM) < ZERO ||
                Math.abs((a * b + c) / d - SUM) < ZERO ||
                Math.abs((a * b) + (c / d) - SUM) < ZERO ||
                Math.abs(a * (b + c / d) - SUM) < ZERO ||
                Math.abs(a * b + (c / d) - SUM) < ZERO ||
                Math.abs((a * b) + c + d - SUM) < ZERO ||
                Math.abs((a * b + c) + d - SUM) < ZERO ||
                Math.abs((a * b) + (c + d) - SUM) < ZERO ||
                Math.abs(a * (b + c + d) - SUM) < ZERO ||
                Math.abs(a * b + (c + d) - SUM) < ZERO ||
                Math.abs((a * b) + c - d - SUM) < ZERO ||
                Math.abs((a * b + c) - d - SUM) < ZERO ||
                Math.abs((a * b) + (c - d) - SUM) < ZERO ||
                Math.abs(a * (b + c - d) - SUM) < ZERO ||
                Math.abs(a * b + (c - d) - SUM) < ZERO ||
                Math.abs((a * b) - c * d - SUM) < ZERO ||
                Math.abs((a * b - c) * d - SUM) < ZERO ||
                Math.abs((a * b) - (c * d) - SUM) < ZERO ||
                Math.abs(a * (b - c * d) - SUM) < ZERO ||
                Math.abs(a * b - (c * d) - SUM) < ZERO ||
                Math.abs((a * b) - c / d - SUM) < ZERO ||
                Math.abs((a * b - c) / d - SUM) < ZERO ||
                Math.abs((a * b) - (c / d) - SUM) < ZERO ||
                Math.abs(a * (b - c / d) - SUM) < ZERO ||
                Math.abs(a * b - (c / d) - SUM) < ZERO ||
                Math.abs((a * b) - c + d - SUM) < ZERO ||
                Math.abs((a * b - c) + d - SUM) < ZERO ||
                Math.abs((a * b) - (c + d) - SUM) < ZERO ||
                Math.abs(a * (b - c + d) - SUM) < ZERO ||
                Math.abs(a * b - (c + d) - SUM) < ZERO ||
                Math.abs((a * b) - c - d - SUM) < ZERO ||
                Math.abs((a * b - c) - d - SUM) < ZERO ||
                Math.abs((a * b) - (c - d) - SUM) < ZERO ||
                Math.abs(a * (b - c - d) - SUM) < ZERO ||
                Math.abs(a * b - (c - d) - SUM) < ZERO ||
                Math.abs((a / b) * c * d - SUM) < ZERO ||
                Math.abs((a / b * c) * d - SUM) < ZERO ||
                Math.abs((a / b) * (c * d) - SUM) < ZERO ||
                Math.abs(a / (b * c * d) - SUM) < ZERO ||
                Math.abs(a / b * (c * d) - SUM) < ZERO ||
                Math.abs((a / b) * c / d - SUM) < ZERO ||
                Math.abs((a / b * c) / d - SUM) < ZERO ||
                Math.abs((a / b) * (c / d) - SUM) < ZERO ||
                Math.abs(a / (b * c / d) - SUM) < ZERO ||
                Math.abs(a / b * (c / d) - SUM) < ZERO ||
                Math.abs((a / b) * c + d - SUM) < ZERO ||
                Math.abs((a / b * c) + d - SUM) < ZERO ||
                Math.abs((a / b) * (c + d) - SUM) < ZERO ||
                Math.abs(a / (b * c + d) - SUM) < ZERO ||
                Math.abs(a / b * (c + d) - SUM) < ZERO ||
                Math.abs((a / b) * c - d - SUM) < ZERO ||
                Math.abs((a / b * c) - d - SUM) < ZERO ||
                Math.abs((a / b) * (c - d) - SUM) < ZERO ||
                Math.abs(a / (b * c - d) - SUM) < ZERO ||
                Math.abs(a / b * (c - d) - SUM) < ZERO ||
                Math.abs((a / b) / c * d - SUM) < ZERO ||
                Math.abs((a / b / c) * d - SUM) < ZERO ||
                Math.abs((a / b) / (c * d) - SUM) < ZERO ||
                Math.abs(a / (b / c * d) - SUM) < ZERO ||
                Math.abs(a / b / (c * d) - SUM) < ZERO ||
                Math.abs((a / b) / c / d - SUM) < ZERO ||
                Math.abs((a / b / c) / d - SUM) < ZERO ||
                Math.abs((a / b) / (c / d) - SUM) < ZERO ||
                Math.abs(a / (b / c / d) - SUM) < ZERO ||
                Math.abs(a / b / (c / d) - SUM) < ZERO ||
                Math.abs((a / b) / c + d - SUM) < ZERO ||
                Math.abs((a / b / c) + d - SUM) < ZERO ||
                Math.abs((a / b) / (c + d) - SUM) < ZERO ||
                Math.abs(a / (b / c + d) - SUM) < ZERO ||
                Math.abs(a / b / (c + d) - SUM) < ZERO ||
                Math.abs((a / b) / c - d - SUM) < ZERO ||
                Math.abs((a / b / c) - d - SUM) < ZERO ||
                Math.abs((a / b) / (c - d) - SUM) < ZERO ||
                Math.abs(a / (b / c - d) - SUM) < ZERO ||
                Math.abs(a / b / (c - d) - SUM) < ZERO ||
                Math.abs((a / b) + c * d - SUM) < ZERO ||
                Math.abs((a / b + c) * d - SUM) < ZERO ||
                Math.abs((a / b) + (c * d) - SUM) < ZERO ||
                Math.abs(a / (b + c * d) - SUM) < ZERO ||
                Math.abs(a / b + (c * d) - SUM) < ZERO ||
                Math.abs((a / b) + c / d - SUM) < ZERO ||
                Math.abs((a / b + c) / d - SUM) < ZERO ||
                Math.abs((a / b) + (c / d) - SUM) < ZERO ||
                Math.abs(a / (b + c / d) - SUM) < ZERO ||
                Math.abs(a / b + (c / d) - SUM) < ZERO ||
                Math.abs((a / b) + c + d - SUM) < ZERO ||
                Math.abs((a / b + c) + d - SUM) < ZERO ||
                Math.abs((a / b) + (c + d) - SUM) < ZERO ||
                Math.abs(a / (b + c + d) - SUM) < ZERO ||
                Math.abs(a / b + (c + d) - SUM) < ZERO ||
                Math.abs((a / b) + c - d - SUM) < ZERO ||
                Math.abs((a / b + c) - d - SUM) < ZERO ||
                Math.abs((a / b) + (c - d) - SUM) < ZERO ||
                Math.abs(a / (b + c - d) - SUM) < ZERO ||
                Math.abs(a / b + (c - d) - SUM) < ZERO ||
                Math.abs((a / b) - c * d - SUM) < ZERO ||
                Math.abs((a / b - c) * d - SUM) < ZERO ||
                Math.abs((a / b) - (c * d) - SUM) < ZERO ||
                Math.abs(a / (b - c * d) - SUM) < ZERO ||
                Math.abs(a / b - (c * d) - SUM) < ZERO ||
                Math.abs((a / b) - c / d - SUM) < ZERO ||
                Math.abs((a / b - c) / d - SUM) < ZERO ||
                Math.abs((a / b) - (c / d) - SUM) < ZERO ||
                Math.abs(a / (b - c / d) - SUM) < ZERO ||
                Math.abs(a / b - (c / d) - SUM) < ZERO ||
                Math.abs((a / b) - c + d - SUM) < ZERO ||
                Math.abs((a / b - c) + d - SUM) < ZERO ||
                Math.abs((a / b) - (c + d) - SUM) < ZERO ||
                Math.abs(a / (b - c + d) - SUM) < ZERO ||
                Math.abs(a / b - (c + d) - SUM) < ZERO ||
                Math.abs((a / b) - c - d - SUM) < ZERO ||
                Math.abs((a / b - c) - d - SUM) < ZERO ||
                Math.abs((a / b) - (c - d) - SUM) < ZERO ||
                Math.abs(a / (b - c - d) - SUM) < ZERO ||
                Math.abs(a / b - (c - d) - SUM) < ZERO ||
                Math.abs((a + b) * c * d - SUM) < ZERO ||
                Math.abs((a + b * c) * d - SUM) < ZERO ||
                Math.abs((a + b) * (c * d) - SUM) < ZERO ||
                Math.abs(a + (b * c * d) - SUM) < ZERO ||
                Math.abs(a + b * (c * d) - SUM) < ZERO ||
                Math.abs((a + b) * c / d - SUM) < ZERO ||
                Math.abs((a + b * c) / d - SUM) < ZERO ||
                Math.abs((a + b) * (c / d) - SUM) < ZERO ||
                Math.abs(a + (b * c / d) - SUM) < ZERO ||
                Math.abs(a + b * (c / d) - SUM) < ZERO ||
                Math.abs((a + b) * c + d - SUM) < ZERO ||
                Math.abs((a + b * c) + d - SUM) < ZERO ||
                Math.abs((a + b) * (c + d) - SUM) < ZERO ||
                Math.abs(a + (b * c + d) - SUM) < ZERO ||
                Math.abs(a + b * (c + d) - SUM) < ZERO ||
                Math.abs((a + b) * c - d - SUM) < ZERO ||
                Math.abs((a + b * c) - d - SUM) < ZERO ||
                Math.abs((a + b) * (c - d) - SUM) < ZERO ||
                Math.abs(a + (b * c - d) - SUM) < ZERO ||
                Math.abs(a + b * (c - d) - SUM) < ZERO ||
                Math.abs((a + b) / c * d - SUM) < ZERO ||
                Math.abs((a + b / c) * d - SUM) < ZERO ||
                Math.abs((a + b) / (c * d) - SUM) < ZERO ||
                Math.abs(a + (b / c * d) - SUM) < ZERO ||
                Math.abs(a + b / (c * d) - SUM) < ZERO ||
                Math.abs((a + b) / c / d - SUM) < ZERO ||
                Math.abs((a + b / c) / d - SUM) < ZERO ||
                Math.abs((a + b) / (c / d) - SUM) < ZERO ||
                Math.abs(a + (b / c / d) - SUM) < ZERO ||
                Math.abs(a + b / (c / d) - SUM) < ZERO ||
                Math.abs((a + b) / c + d - SUM) < ZERO ||
                Math.abs((a + b / c) + d - SUM) < ZERO ||
                Math.abs((a + b) / (c + d) - SUM) < ZERO ||
                Math.abs(a + (b / c + d) - SUM) < ZERO ||
                Math.abs(a + b / (c + d) - SUM) < ZERO ||
                Math.abs((a + b) / c - d - SUM) < ZERO ||
                Math.abs((a + b / c) - d - SUM) < ZERO ||
                Math.abs((a + b) / (c - d) - SUM) < ZERO ||
                Math.abs(a + (b / c - d) - SUM) < ZERO ||
                Math.abs(a + b / (c - d) - SUM) < ZERO ||
                Math.abs((a + b) + c * d - SUM) < ZERO ||
                Math.abs((a + b + c) * d - SUM) < ZERO ||
                Math.abs((a + b) + (c * d) - SUM) < ZERO ||
                Math.abs(a + (b + c * d) - SUM) < ZERO ||
                Math.abs(a + b + (c * d) - SUM) < ZERO ||
                Math.abs((a + b) + c / d - SUM) < ZERO ||
                Math.abs((a + b + c) / d - SUM) < ZERO ||
                Math.abs((a + b) + (c / d) - SUM) < ZERO ||
                Math.abs(a + (b + c / d) - SUM) < ZERO ||
                Math.abs(a + b + (c / d) - SUM) < ZERO ||
                Math.abs((a + b) + c + d - SUM) < ZERO ||
                Math.abs((a + b + c) + d - SUM) < ZERO ||
                Math.abs((a + b) + (c + d) - SUM) < ZERO ||
                Math.abs(a + (b + c + d) - SUM) < ZERO ||
                Math.abs(a + b + (c + d) - SUM) < ZERO ||
                Math.abs((a + b) + c - d - SUM) < ZERO ||
                Math.abs((a + b + c) - d - SUM) < ZERO ||
                Math.abs((a + b) + (c - d) - SUM) < ZERO ||
                Math.abs(a + (b + c - d) - SUM) < ZERO ||
                Math.abs(a + b + (c - d) - SUM) < ZERO ||
                Math.abs((a + b) - c * d - SUM) < ZERO ||
                Math.abs((a + b - c) * d - SUM) < ZERO ||
                Math.abs((a + b) - (c * d) - SUM) < ZERO ||
                Math.abs(a + (b - c * d) - SUM) < ZERO ||
                Math.abs(a + b - (c * d) - SUM) < ZERO ||
                Math.abs((a + b) - c / d - SUM) < ZERO ||
                Math.abs((a + b - c) / d - SUM) < ZERO ||
                Math.abs((a + b) - (c / d) - SUM) < ZERO ||
                Math.abs(a + (b - c / d) - SUM) < ZERO ||
                Math.abs(a + b - (c / d) - SUM) < ZERO ||
                Math.abs((a + b) - c + d - SUM) < ZERO ||
                Math.abs((a + b - c) + d - SUM) < ZERO ||
                Math.abs((a + b) - (c + d) - SUM) < ZERO ||
                Math.abs(a + (b - c + d) - SUM) < ZERO ||
                Math.abs(a + b - (c + d) - SUM) < ZERO ||
                Math.abs((a + b) - c - d - SUM) < ZERO ||
                Math.abs((a + b - c) - d - SUM) < ZERO ||
                Math.abs((a + b) - (c - d) - SUM) < ZERO ||
                Math.abs(a + (b - c - d) - SUM) < ZERO ||
                Math.abs(a + b - (c - d) - SUM) < ZERO ||
                Math.abs((a - b) * c * d - SUM) < ZERO ||
                Math.abs((a - b * c) * d - SUM) < ZERO ||
                Math.abs((a - b) * (c * d) - SUM) < ZERO ||
                Math.abs(a - (b * c * d) - SUM) < ZERO ||
                Math.abs(a - b * (c * d) - SUM) < ZERO ||
                Math.abs((a - b) * c / d - SUM) < ZERO ||
                Math.abs((a - b * c) / d - SUM) < ZERO ||
                Math.abs((a - b) * (c / d) - SUM) < ZERO ||
                Math.abs(a - (b * c / d) - SUM) < ZERO ||
                Math.abs(a - b * (c / d) - SUM) < ZERO ||
                Math.abs((a - b) * c + d - SUM) < ZERO ||
                Math.abs((a - b * c) + d - SUM) < ZERO ||
                Math.abs((a - b) * (c + d) - SUM) < ZERO ||
                Math.abs(a - (b * c + d) - SUM) < ZERO ||
                Math.abs(a - b * (c + d) - SUM) < ZERO ||
                Math.abs((a - b) * c - d - SUM) < ZERO ||
                Math.abs((a - b * c) - d - SUM) < ZERO ||
                Math.abs((a - b) * (c - d) - SUM) < ZERO ||
                Math.abs(a - (b * c - d) - SUM) < ZERO ||
                Math.abs(a - b * (c - d) - SUM) < ZERO ||
                Math.abs((a - b) / c * d - SUM) < ZERO ||
                Math.abs((a - b / c) * d - SUM) < ZERO ||
                Math.abs((a - b) / (c * d) - SUM) < ZERO ||
                Math.abs(a - (b / c * d) - SUM) < ZERO ||
                Math.abs(a - b / (c * d) - SUM) < ZERO ||
                Math.abs((a - b) / c / d - SUM) < ZERO ||
                Math.abs((a - b / c) / d - SUM) < ZERO ||
                Math.abs((a - b) / (c / d) - SUM) < ZERO ||
                Math.abs(a - (b / c / d) - SUM) < ZERO ||
                Math.abs(a - b / (c / d) - SUM) < ZERO ||
                Math.abs((a - b) / c + d - SUM) < ZERO ||
                Math.abs((a - b / c) + d - SUM) < ZERO ||
                Math.abs((a - b) / (c + d) - SUM) < ZERO ||
                Math.abs(a - (b / c + d) - SUM) < ZERO ||
                Math.abs(a - b / (c + d) - SUM) < ZERO ||
                Math.abs((a - b) / c - d - SUM) < ZERO ||
                Math.abs((a - b / c) - d - SUM) < ZERO ||
                Math.abs((a - b) / (c - d) - SUM) < ZERO ||
                Math.abs(a - (b / c - d) - SUM) < ZERO ||
                Math.abs(a - b / (c - d) - SUM) < ZERO ||
                Math.abs((a - b) + c * d - SUM) < ZERO ||
                Math.abs((a - b + c) * d - SUM) < ZERO ||
                Math.abs((a - b) + (c * d) - SUM) < ZERO ||
                Math.abs(a - (b + c * d) - SUM) < ZERO ||
                Math.abs(a - b + (c * d) - SUM) < ZERO ||
                Math.abs((a - b) + c / d - SUM) < ZERO ||
                Math.abs((a - b + c) / d - SUM) < ZERO ||
                Math.abs((a - b) + (c / d) - SUM) < ZERO ||
                Math.abs(a - (b + c / d) - SUM) < ZERO ||
                Math.abs(a - b + (c / d) - SUM) < ZERO ||
                Math.abs((a - b) + c + d - SUM) < ZERO ||
                Math.abs((a - b + c) + d - SUM) < ZERO ||
                Math.abs((a - b) + (c + d) - SUM) < ZERO ||
                Math.abs(a - (b + c + d) - SUM) < ZERO ||
                Math.abs(a - b + (c + d) - SUM) < ZERO ||
                Math.abs((a - b) + c - d - SUM) < ZERO ||
                Math.abs((a - b + c) - d - SUM) < ZERO ||
                Math.abs((a - b) + (c - d) - SUM) < ZERO ||
                Math.abs(a - (b + c - d) - SUM) < ZERO ||
                Math.abs(a - b + (c - d) - SUM) < ZERO ||
                Math.abs((a - b) - c * d - SUM) < ZERO ||
                Math.abs((a - b - c) * d - SUM) < ZERO ||
                Math.abs((a - b) - (c * d) - SUM) < ZERO ||
                Math.abs(a - (b - c * d) - SUM) < ZERO ||
                Math.abs(a - b - (c * d) - SUM) < ZERO ||
                Math.abs((a - b) - c / d - SUM) < ZERO ||
                Math.abs((a - b - c) / d - SUM) < ZERO ||
                Math.abs((a - b) - (c / d) - SUM) < ZERO ||
                Math.abs(a - (b - c / d) - SUM) < ZERO ||
                Math.abs(a - b - (c / d) - SUM) < ZERO ||
                Math.abs((a - b) - c + d - SUM) < ZERO ||
                Math.abs((a - b - c) + d - SUM) < ZERO ||
                Math.abs((a - b) - (c + d) - SUM) < ZERO ||
                Math.abs(a - (b - c + d) - SUM) < ZERO ||
                Math.abs(a - b - (c + d) - SUM) < ZERO ||
                Math.abs((a - b) - c - d - SUM) < ZERO ||
                Math.abs((a - b - c) - d - SUM) < ZERO ||
                Math.abs((a - b) - (c - d) - SUM) < ZERO ||
                Math.abs(a - (b - c - d) - SUM) < ZERO ||
                Math.abs(a - b - (c - d) - SUM) < ZERO;
    }

    /**
     * step3: ?????? a,b,c,d ???????????????????????? 24 ???
     * a,b,c,d ???????????????????????? 4! = 24 ???
     */
    private static boolean step3(double a, double b, double c, double d) {
        return step2(a, b, c, d) ||
                step2(a, b, d, c) ||
                step2(a, c, b, d) ||
                step2(a, c, d, b) ||
                step2(a, d, c, b) ||
                step2(a, d, b, c) ||
                step2(b, a, c, d) ||
                step2(b, a, d, c) ||
                step2(c, a, b, d) ||
                step2(c, a, d, b) ||
                step2(d, a, c, b) ||
                step2(d, a, b, c) ||
                step2(b, c, a, d) ||
                step2(b, d, a, c) ||
                step2(c, b, a, d) ||
                step2(c, d, a, b) ||
                step2(d, c, a, b) ||
                step2(d, b, a, c) ||
                step2(b, c, d, a) ||
                step2(b, d, c, a) ||
                step2(c, b, d, a) ||
                step2(c, d, b, a) ||
                step2(d, c, b, a) ||
                step2(d, b, c, a);
    }

    /**
     * step4: ?????????
     * 36 ????????? 4 ????????? 495 ???????????????????????????A 5 5 5 ??? 5 A 5 5 ??????????????????
     * ???????????? 404 ???
     * ???????????? 91 ???
     */
    private static void step4() {
        int cnt = 0;
        for (int a = CARD_MIN; a <= CARD_MAX; a++) {
            for (int b = a; b <= CARD_MAX; b++) {
                for (int c = b; c <= CARD_MAX; c++) {
                    for (int d = c; d <= CARD_MAX; d++) {
                        // ??????????????????
                        if (!step3(a, b, c, d)) {
                            System.out.println(MessageFormat.format("set.add(\"{0}:{1}:{2}:{3}\");", a, b, c, d));
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println("????????????: " + cnt);
    }
}
/*
679. 24 ?????????
https://leetcode.cn/problems/24-game/

?????? 4 ????????? 1 ??? 9 ????????????????????????????????????????????? *???/???+???-???(???) ??????????????? 24???
??????:
??????????????? / ??????????????????????????????????????????????????? 4 / (1 - 2/3) = 12 ???
?????????????????????????????????????????????????????????????????? - ?????????????????????????????????[1, 1, 1, 1] ??????????????????????????? -1 - 1 - 1 - 1 ??????????????????
?????????????????????????????????????????????????????? [1, 2, 1, 2] ?????????????????? 12 + 12 ???

?????? 1~9?????? 495 ???????????? 404 ???????????? 91 ??????
???????????? 1~13?????? 1820 ???????????? 1362 ???????????? 458 ??????
 */
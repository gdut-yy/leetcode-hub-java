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

    // 打表
    private static final String[] OPERATION = {"*", "/", "+", "-"};
    private static final double SUM = 24.0;
    private static final double ZERO = 1e-6;
    private static final int CARD_MIN = 1;
    private static final int CARD_MAX = 9;

//    public static void main(String[] args) {
//        step1();
//        step4();
//    }

    /**
     * step1: 组合括号
     * 会存在冗余表达式，但是对于打表来说是无影响的
     * 总数 = 4*4*4*5 = 320
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
     * step2: step1 中的输出，判断排列 a,b,c,d 能否组成 24 点
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
     * step3: 判断 a,b,c,d 的全排列能否组成 24 点
     * a,b,c,d 四个数的全排列为 4! = 24 种
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
     * step4: 打表。
     * 36 张牌抽 4 张牌共 495 种组合（排序去重，A 5 5 5 和 5 A 5 5 视为同一种）
     * 有解情况 404 种
     * 无解情况 91 种
     */
    private static void step4() {
        int cnt = 0;
        for (int a = CARD_MIN; a <= CARD_MAX; a++) {
            for (int b = a; b <= CARD_MAX; b++) {
                for (int c = b; c <= CARD_MAX; c++) {
                    for (int d = c; d <= CARD_MAX; d++) {
                        // 输出无解情况
                        if (!step3(a, b, c, d)) {
                            System.out.println(MessageFormat.format("set.add(\"{0}:{1}:{2}:{3}\");", a, b, c, d));
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println("无解情况: " + cnt);
    }
}
/*
679. 24 点游戏
https://leetcode-cn.com/problems/24-game/

你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
注意:
除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。

本题 1~9，共 495 种，有解 404 种，无解 91 种。
若拓展到 1~13，共 1820 种，有解 1362 种，无解 458 种。
 */
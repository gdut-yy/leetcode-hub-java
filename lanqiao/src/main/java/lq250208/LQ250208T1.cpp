import java.util.Arrays;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve());
    }

    private static String solve() {
        char[] s = "snake".toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }
}
/*
蛇年大吉【算法赛】
 */
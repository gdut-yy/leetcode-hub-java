import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        String[] testCases = new String[t];
        for (int i = 0; i < t; i++) {
            testCases[i] = reader.readLine();
        }
        String[] res = solution(t, testCases);
        for (String re : res) {
            writer.write(re);
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static String[] solution(int t, String[] testCases) {
        String[] res = new String[t];
        for (int i = 0; i < t; i++) {
            String testCase = testCases[i];
            int cntAC = 0;
            int cntB = 0;
            for (char ch : testCase.toCharArray()) {
                if (ch == 'B') {
                    cntB++;
                } else {
                    cntAC++;
                }
            }
            res[i] = (cntB == cntAC) ? "YES" : "NO";
        }
        return res;
    }
}

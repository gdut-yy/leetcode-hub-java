import com.alibaba.fastjson.JSON;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UtUtils {
    /**
     * List<List<Integer>> 自定义 Comparator
     */
    public static final Comparator<List<Integer>> INTEGER_LIST_COMPARATOR = (o1, o2) -> {
        // o1.size() != o2.size();
        int minLen = Math.min(o1.size(), o2.size());
        for (int i = 0; i < minLen; i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return o1.size() - o2.size();
    };

    /**
     * List<List<String>> 自定义 Comparator
     */
    public static final Comparator<List<String>> STRING_LIST_COMPARATOR = (o1, o2) -> {
        Collections.sort(o1);
        Collections.sort(o2);
        // o1.size() != o2.size();
        int minLen = Math.min(o1.size(), o2.size());
        for (int i = 0; i < minLen; i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return o1.size() - o2.size();
    };

    /**
     * 通过 JSON 序列化判等自定义对象
     *
     * @param expected expected
     * @param actual   actual
     * @return boolean
     */
    public static boolean assertJsonEquals(Object expected, Object actual) {
        String expectedJson = JSON.toJSONString(expected);
        String actualJson = JSON.toJSONString(actual);
        System.out.println("==>assertJsonEquals");
        System.out.println("expected: " + expectedJson);
        System.out.println("actual  : " + actualJson);
        return expectedJson.equals(actualJson);
    }

    // String => int
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    // String => int[]
    public static int[] stringToInts(String input) {
        return JSON.parseArray(input, Integer.class).stream().mapToInt(i -> i).toArray();
    }

    // String => int[][]
    public static int[][] stringToInts2(String input) {
        List<int[]> list = JSON.parseArray(input, int[].class);
        return list.toArray(new int[list.size()][]);
    }

    // String => char[][]
    public static char[][] stringToChars2(String input) {
        List<char[]> list = JSON.parseArray(input, char[].class);
        return list.toArray(new char[list.size()][]);
    }

    // String => String[][]
    public static String[][] stringToStrings2(String input) {
        List<String[]> list = JSON.parseArray(input, String[].class);
        return list.toArray(new String[list.size()][]);
    }

    // String => List<List<Integer>>
    public static List<List<Integer>> stringToIntegerList2(String input) {
        List<String> list = JSON.parseArray(input, String.class);
        List<List<Integer>> resList = new ArrayList<>();
        for (String str : list) {
            resList.add(JSON.parseArray(str, Integer.class));
        }
        return resList;
    }

    // String => List<List<Long>>
    public static List<List<Long>> stringToLongList2(String input) {
        List<String> list = JSON.parseArray(input, String.class);
        List<List<Long>> resList = new ArrayList<>();
        for (String str : list) {
            resList.add(JSON.parseArray(str, Long.class));
        }
        return resList;
    }

    // String => List<List<String>>
    public static List<List<String>> stringToStringList2(String input) {
        List<String> list = JSON.parseArray(input, String.class);
        List<List<String>> resList = new ArrayList<>();
        for (String str : list) {
            resList.add(JSON.parseArray(str, String.class));
        }
        return resList;
    }

    /**
     * resources 文件加载 List<String>
     */
    private static List<String> loadingStringList(String fileName) {
        List<String> resList = new ArrayList<>();
        File file = new File(Objects.requireNonNull(UtUtils.class.getResource(fileName)).getPath());
        try {
            resList = FileUtils.readLines(file, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resList;
    }

    /**
     * resources 文件加载 String
     */
    public static String loadingString(String fileName, int line) {
        return loadingStringList(fileName).get(line);
    }

    /**
     * resources 文件加载 int
     */
    public static int loadingInt(String fileName, int line) {
        return stringToInt(loadingString(fileName, line));
    }

    /**
     * resources 文件加载 int[]
     */
    public static int[] loadingInts(String fileName, int line) {
        return stringToInts(loadingString(fileName, line));
    }

    /**
     * resources 文件加载 int[][]
     */
    public static int[][] loadingInts2(String fileName, int line) {
        return stringToInts2(loadingString(fileName, line));
    }

    /**
     * resources 文件加载 long
     */
    public static long loadingLong(String fileName, int line) {
        return Long.parseLong(loadingString(fileName, line));
    }

    /**
     * resources 文件加载 long[]
     */
    public static long[] loadingLongs(String fileName, int line) {
        List<Integer> list = JSON.parseArray(loadingString(fileName, line), Integer.class);
        return list.stream().mapToLong(l -> l).toArray();
    }

    /**
     * resources 文件加载 List<Integer>
     */
    public static List<Integer> loadingIntegerList(String fileName, int line) {
        return JSON.parseArray(loadingString(fileName, line), Integer.class);
    }

    /**
     * resources 文件加载 List<List<Integer>>
     */
    public static List<List<Integer>> loadingIntegerList2(String fileName, int line) {
        return stringToIntegerList2(loadingString(fileName, line));
    }

    /**
     * resources 文件加载 List<Boolean>
     */
    public static List<Boolean> loadingBooleanList(String fileName, int line) {
        return JSON.parseArray(loadingString(fileName, line), Boolean.class);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static final String PATTERN = ": https://github.com/gdut-yy/leetcode-hub-java/blob/master/leetcode-{0}/src/main/java/Solution{1}.java";

    private static String solution(String line) {
        String numStr = line.replace("[gh", "").replace("]", "");
        int num = Integer.parseInt(numStr);
        int partition = num % 100 == 0 ? num / 100 : num / 100 + 1;
        String param0 = partition < 10 ? "0" + partition : "" + partition;
        String param1 = String.valueOf(num);
        return line + MessageFormat.format(PATTERN, param0, param1);
    }
}

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UtUtils {
    /**
     * List<List<Integer>> expected 类型比较
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
     * List<List<String>> expected 类型比较
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
     * resources 文件加载 int[]
     */
    public static int[] loadingInts(String fileName, int line) {
        List<String> lines = loadingStringList(fileName);
        List<Integer> list = JSON.parseArray(lines.get(line), Integer.class);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * resources 文件加载 int[][]
     */
    public static int[][] loadingInts2(String fileName, int line) {
        List<String> lines = loadingStringList(fileName);
        List<int[]> list = JSON.parseArray(lines.get(line), int[].class);
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * resources 文件加载 int
     */
    public static int loadingInt(String fileName, int line) {
        List<String> lines = loadingStringList(fileName);
        return Integer.parseInt(lines.get(line));
    }

    /**
     * resources 文件加载 long
     */
    public static long loadingLong(String fileName, int line) {
        List<String> lines = loadingStringList(fileName);
        return Long.parseLong(lines.get(line));
    }

    /**
     * resources 文件加载 String
     */
    public static String loadingString(String fileName, int line) {
        List<String> lines = loadingStringList(fileName);
        return lines.get(line);
    }
}

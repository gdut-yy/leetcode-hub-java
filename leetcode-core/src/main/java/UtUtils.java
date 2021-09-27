import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
     * loadingInts
     *
     * @param fileName 文件名
     * @return int[]
     */
    public static int[] loadingInts(String fileName) throws IOException {
        return loadingInts(fileName, 0);
    }

    /**
     * loadingInts
     *
     * @param fileName 文件名
     * @param line     行号
     * @return int[]
     * @throws IOException e
     */
    public static int[] loadingInts(String fileName, int line) throws IOException {
        // 从 src/main/resources 下加载
        File file = new File(Objects.requireNonNull(UtUtils.class.getResource(fileName)).getPath());
        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8.name());
        List<Integer> list = JSON.parseArray(lines.get(line), Integer.class);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * loadingInts2
     *
     * @param fileName 文件名
     * @return int[][]
     */
    public static int[][] loadingInts2(String fileName) throws IOException {
        return loadingInts2(fileName, 0);
    }

    /**
     * loadingInts2
     *
     * @param fileName 文件名
     * @param line     行号
     * @return int[][]
     * @throws IOException e
     */
    public static int[][] loadingInts2(String fileName, int line) throws IOException {
        // 从 src/main/resources 下加载
        File file = new File(Objects.requireNonNull(UtUtils.class.getResource(fileName)).getPath());
        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8.name());
        List<int[]> list = JSON.parseArray(lines.get(line), int[].class);
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * loadingLong
     *
     * @param fileName 文件名
     * @param line     行号
     * @return long
     * @throws IOException e
     */
    public static long loadingLong(String fileName, int line) throws IOException {
        // 从 src/main/resources 下加载
        File file = new File(Objects.requireNonNull(UtUtils.class.getResource(fileName)).getPath());
        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8.name());
        return Long.parseLong(lines.get(line));
    }
}

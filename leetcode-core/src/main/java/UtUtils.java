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
        // 从 src/main/resources 下加载
        File file = new File(UtUtils.class.getResource(fileName).getPath());
        String fileStr = FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());

        List<Integer> list = JSON.parseArray(fileStr, Integer.class);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * loadingInts2
     *
     * @param fileName 文件名
     * @return int[][]
     */
    public static int[][] loadingInts2(String fileName) throws IOException {
        // 从 src/main/resources 下加载
        File file = new File(UtUtils.class.getResource(fileName).getPath());
        String fileStr = FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());

        List<int[]> list = JSON.parseArray(fileStr, int[].class);
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

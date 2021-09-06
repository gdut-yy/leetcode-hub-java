import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UtUtils {
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

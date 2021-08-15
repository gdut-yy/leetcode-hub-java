import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

        // 处理成 int[] 返回
        fileStr = fileStr.replace("[", "").replace("]", "");
        String[] fileStrArr = fileStr.split(",");
        int len = fileStrArr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Integer.parseInt(fileStrArr[i].trim());
        }
        return res;
    }
}

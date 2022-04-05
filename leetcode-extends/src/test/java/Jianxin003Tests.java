import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Jianxin003Tests {
    private final Jianxin003 jianxin003 = new Jianxin003();

    private final Jianxin003_2 jianxin003_2 = new Jianxin003_2();

    @Test
    public void example1() {
        int[][] lines = UtUtils.stringToInts2("[[1,2,3,4,5],[2,10,14,15,16],[10,8,12,13],[7,8,4,9,11]]");
        int start = 1;
        int end = 7;
        int[] expected = {1, 2, 3, 4, 8, 7};
        Assertions.assertArrayEquals(expected, jianxin003.metroRouteDesignI(lines, start, end));
        Assertions.assertArrayEquals(expected, jianxin003_2.metroRouteDesignI(lines, start, end));
    }

    @Test
    public void example2() {
        int[][] lines = UtUtils.stringToInts2("[[1,2,3,4,5,6,7,8,9,10,11],[12,13,2,14,8,15],[16,1,17,10,18]]");
        int start = 9;
        int end = 1;
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Assertions.assertArrayEquals(expected, jianxin003.metroRouteDesignI(lines, start, end));
        Assertions.assertArrayEquals(expected, jianxin003_2.metroRouteDesignI(lines, start, end));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] lines = {{2871, 7415, 7312, 2483, 7721, 3539, 4880}, {3539, 4880}, {7312, 7415, 699, 4880, 473, 7721, 2871, 2483, 3539}, {473, 7415, 2871, 7721}, {7721, 473, 7312}, {7312, 473, 7721, 7415, 2483, 3539, 699}};
        int start = 7415;
        int end = 2871;
        int[] expected = {7415, 699, 4880, 473, 7721, 2871};
        Assertions.assertArrayEquals(expected, jianxin003.metroRouteDesignI(lines, start, end));
        Assertions.assertArrayEquals(expected, jianxin003_2.metroRouteDesignI(lines, start, end));
    }

    @Test
    public void example4() {
        int[][] lines = {{7851, 6448, 853, 9027, 970, 5600, 2269}, {4614, 7539}, {970, 4614, 2269, 9906}, {7851, 970, 4614, 9906, 9027, 2269}};
        int start = 9906;
        int end = 853;
        int[] expected = {9906, 2269, 4614, 970, 9027, 853};
        Assertions.assertArrayEquals(expected, jianxin003.metroRouteDesignI(lines, start, end));
        Assertions.assertArrayEquals(expected, jianxin003_2.metroRouteDesignI(lines, start, end));
    }

    @Test
    public void example5() {
        int[][] lines = {{4165, 8075, 3072, 6302, 3747, 3616, 1893}, {7431, 3616, 3747, 1893, 8075, 3219}, {3072, 6302, 3747}, {3616, 3969}, {7431, 3616}};
        int start = 4165;
        int end = 3219;
        int[] expected = {4165, 8075, 3219};
        Assertions.assertArrayEquals(expected, jianxin003.metroRouteDesignI(lines, start, end));
        Assertions.assertArrayEquals(expected, jianxin003_2.metroRouteDesignI(lines, start, end));
    }
}
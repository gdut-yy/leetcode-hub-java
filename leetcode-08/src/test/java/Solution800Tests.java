import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution800Tests {
    private final Solution800 solution800 = new Solution800();

    @Test
    public void example1() {
        String color = "#09f166";
        String expected = "#11ee66";
        Assertions.assertEquals(expected, solution800.similarRGB(color));
        Assertions.assertEquals(expected, solution800.similarRGB2(color));
    }

    @Test
    public void example2() {
        String color = "#4e3fe1";
        String expected = "#5544dd";
        Assertions.assertEquals(expected, solution800.similarRGB(color));
        Assertions.assertEquals(expected, solution800.similarRGB2(color));
    }
}
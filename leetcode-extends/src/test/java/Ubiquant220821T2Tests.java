import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ubiquant220821T2Tests {
    private final Ubiquant220821T2 ubiquant220821T2 = new Ubiquant220821T2();

    @Test
    public void example1() {
        String[] field = {".....W", ".W..W.", "....W.", ".W....", "W.WWW.", ".W...."};
        int expected = 3;
        Assertions.assertEquals(expected, ubiquant220821T2.lakeCount(field));
    }

    @Test
    public void example2() {
        String[] field = {"W....W", ".W..W.", "..W.W.", "W..W..", "W.W...", ".W...."};
        int expected = 1;
        Assertions.assertEquals(expected, ubiquant220821T2.lakeCount(field));
    }
}

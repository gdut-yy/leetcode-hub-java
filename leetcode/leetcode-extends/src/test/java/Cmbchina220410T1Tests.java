import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cmbchina220410T1Tests {
    private final Cmbchina220410T1 cmbchina220410T1 = new Cmbchina220410T1();

    @Test
    public void example1() {
        String article = "Singing dancing in the rain";
        int index = 10;
        String expected = "Singing in the rain";
        Assertions.assertEquals(expected, cmbchina220410T1.deleteText(article, index));
    }

    @Test
    public void example2() {
        String article = "Hello World";
        int index = 2;
        String expected = "World";
        Assertions.assertEquals(expected, cmbchina220410T1.deleteText(article, index));
    }

    @Test
    public void example3() {
        String article = "Hello World";
        int index = 5;
        String expected = "Hello World";
        Assertions.assertEquals(expected, cmbchina220410T1.deleteText(article, index));
    }

    // 补充用例
    @Test
    public void example4() {
        String article = "Hello";
        int index = 0;
        String expected = "";
        Assertions.assertEquals(expected, cmbchina220410T1.deleteText(article, index));
    }
}

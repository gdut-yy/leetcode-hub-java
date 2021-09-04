import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan004Tests extends AbstractOjTests {
    public Meituan004Tests() {
        super("meituan/004");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan004.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetInOut(INPUT2, OUTPUT2);
        Meituan004.main(null);
        super.doAssertion();
    }
}

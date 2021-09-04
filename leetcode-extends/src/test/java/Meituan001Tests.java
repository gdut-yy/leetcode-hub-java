import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan001Tests extends AbstractOjTests {
    public Meituan001Tests() {
        super("meituan/001");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan001.main(null);
        super.doAssertion();
    }
}

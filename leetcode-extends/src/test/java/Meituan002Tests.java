import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan002Tests extends AbstractOjTests {
    public Meituan002Tests() {
        super("meituan/002");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan002.main(null);
        super.doAssertion();
    }
}

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan012Tests extends AbstractOjTests {
    public Meituan012Tests() {
        super("meituan/012");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan012.main(null);
        super.doAssertion();
    }
}

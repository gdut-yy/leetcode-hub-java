import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan014Tests extends AbstractOjTests {
    public Meituan014Tests() {
        super("meituan/014");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan014.main(null);
        super.doAssertion();
    }
}

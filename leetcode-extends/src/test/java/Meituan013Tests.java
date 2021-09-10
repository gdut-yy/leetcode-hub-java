import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan013Tests extends AbstractOjTests {
    public Meituan013Tests() {
        super("meituan/013");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan013.main(null);
        super.doAssertion();
    }
}

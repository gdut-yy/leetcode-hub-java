import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan007Tests extends AbstractOjTests {
    public Meituan007Tests() {
        super("meituan/007");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan007.main(null);
        super.doAssertion();
    }
}

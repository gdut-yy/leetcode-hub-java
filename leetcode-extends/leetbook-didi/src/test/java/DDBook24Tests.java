import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DDBook24Tests extends AbstractOjTests {
    public DDBook24Tests() {
        super("/didi/book24/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DDBook24.main(null);
        super.doAssertion(OUTPUT1);
    }
}

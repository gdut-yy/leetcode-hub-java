package p1594;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1594DTests extends AbstractOjTests {
    public CF1594DTests() {
        super("/p1594/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1594D.main(null);
        super.doAssertion(OUTPUT1);
    }
}

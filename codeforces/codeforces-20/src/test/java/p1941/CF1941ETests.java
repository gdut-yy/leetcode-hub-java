package p1941;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1941ETests extends AbstractOjTests {
    public CF1941ETests() {
        super("/p1941/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1941E.main(null);
        super.doAssertion(OUTPUT1);
    }
}

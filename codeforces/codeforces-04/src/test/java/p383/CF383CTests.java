package p383;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF383CTests extends AbstractOjTests {
    public CF383CTests() {
        super("/p383/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF383C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
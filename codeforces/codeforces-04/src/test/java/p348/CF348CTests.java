package p348;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF348CTests extends AbstractOjTests {
    public CF348CTests() {
        super("/p348/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF348C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
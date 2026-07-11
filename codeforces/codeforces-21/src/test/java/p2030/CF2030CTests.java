package p2030;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2030CTests extends AbstractOjTests {
    public CF2030CTests() {
        super("/p2030/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2030C.main(null);
        super.doAssertion(OUTPUT1);
    }
}

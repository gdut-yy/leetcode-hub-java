package p777;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF777CTests extends AbstractOjTests {
    public CF777CTests() {
        super("/p777/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF777C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
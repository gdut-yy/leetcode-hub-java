package p2004;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2004CTests extends AbstractOjTests {
    public CF2004CTests() {
        super("/p2004/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2004C.main(null);
        super.doAssertion(OUTPUT1);
    }
}

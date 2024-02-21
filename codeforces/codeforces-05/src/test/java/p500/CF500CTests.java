package p500;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF500CTests extends AbstractOjTests {
    public CF500CTests() {
        super("/p500/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF500C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
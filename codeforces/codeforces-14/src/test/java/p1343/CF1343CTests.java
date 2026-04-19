package p1343;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1343CTests extends AbstractOjTests {
    public CF1343CTests() {
        super("/p1343/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1343C.main(null);
        super.doAssertion(OUTPUT1);
    }
}

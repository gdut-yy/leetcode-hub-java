package p2114;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2114DTests extends AbstractOjTests {
    public CF2114DTests() {
        super("/p2114/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2114D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
package p2042;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2042DTests extends AbstractOjTests {
    public CF2042DTests() {
        super("/p2042/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2042D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
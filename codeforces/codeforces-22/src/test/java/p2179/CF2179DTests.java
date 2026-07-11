package p2179;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2179DTests extends AbstractOjTests {
    public CF2179DTests() {
        super("/p2179/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2179D.main(null);
        super.doAssertion(OUTPUT1);
    }
}

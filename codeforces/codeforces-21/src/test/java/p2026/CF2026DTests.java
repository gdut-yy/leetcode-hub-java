package p2026;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2026DTests extends AbstractOjTests {
    public CF2026DTests() {
        super("/p2026/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2026D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
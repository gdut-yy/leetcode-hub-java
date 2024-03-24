package p1280;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1280BTests extends AbstractOjTests {
    public CF1280BTests() {
        super("/p1280/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1280B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
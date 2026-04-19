package p1187;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1187BTests extends AbstractOjTests {
    public CF1187BTests() {
        super("/p1187/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1187B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
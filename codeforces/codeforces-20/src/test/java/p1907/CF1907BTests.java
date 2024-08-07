package p1907;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1907BTests extends AbstractOjTests {
    public CF1907BTests() {
        super("/p1907/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1907B.main(null);
        super.doAssertion(OUTPUT1);
    }
}

package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921BTests extends AbstractOjTests {
    public CF1921BTests() {
        super("/p1921/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921B.main(null);
        super.doAssertion(OUTPUT1);
    }
}

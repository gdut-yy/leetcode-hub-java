package p1194;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1194BTests extends AbstractOjTests {
    public CF1194BTests() {
        super("/p1194/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1194B.main(null);
        super.doAssertion(OUTPUT1);
    }
}

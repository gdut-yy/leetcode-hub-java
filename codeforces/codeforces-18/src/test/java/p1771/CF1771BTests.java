package p1771;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1771BTests extends AbstractOjTests {
    public CF1771BTests() {
        super("/p1771/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1771B.main(null);
        super.doAssertion(OUTPUT1);
    }
}

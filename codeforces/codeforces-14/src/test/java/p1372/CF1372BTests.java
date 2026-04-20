package p1372;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1372BTests extends AbstractOjTests {
    public CF1372BTests() {
        super("/p1372/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1372B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
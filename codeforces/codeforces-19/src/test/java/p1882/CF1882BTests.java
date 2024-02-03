package p1882;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1882BTests extends AbstractOjTests {
    public CF1882BTests() {
        super("/p1882/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1882B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
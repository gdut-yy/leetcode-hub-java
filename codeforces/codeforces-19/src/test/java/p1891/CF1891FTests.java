package p1891;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1891FTests extends AbstractOjTests {
    public CF1891FTests() {
        super("/p1891/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1891F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
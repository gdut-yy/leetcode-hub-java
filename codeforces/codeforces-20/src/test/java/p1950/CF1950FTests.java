package p1950;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1950FTests extends AbstractOjTests {
    public CF1950FTests() {
        super("/p1950/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1950F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
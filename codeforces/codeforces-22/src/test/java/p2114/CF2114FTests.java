package p2114;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2114FTests extends AbstractOjTests {
    public CF2114FTests() {
        super("/p2114/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2114F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
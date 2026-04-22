package p1883;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1883FTests extends AbstractOjTests {
    public CF1883FTests() {
        super("/p1883/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1883F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
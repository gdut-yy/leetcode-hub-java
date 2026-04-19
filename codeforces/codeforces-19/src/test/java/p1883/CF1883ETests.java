package p1883;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1883ETests extends AbstractOjTests {
    public CF1883ETests() {
        super("/p1883/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1883E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
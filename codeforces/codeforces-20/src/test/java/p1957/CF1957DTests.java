package p1957;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1957DTests extends AbstractOjTests {
    public CF1957DTests() {
        super("/p1957/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1957D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
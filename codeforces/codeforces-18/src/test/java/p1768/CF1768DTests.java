package p1768;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1768DTests extends AbstractOjTests {
    public CF1768DTests() {
        super("/p1768/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1768D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
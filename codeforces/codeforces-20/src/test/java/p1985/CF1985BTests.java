package p1985;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1985BTests extends AbstractOjTests {
    public CF1985BTests() {
        super("/p1985/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1985B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
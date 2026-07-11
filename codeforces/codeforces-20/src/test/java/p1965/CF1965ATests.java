package p1965;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1965ATests extends AbstractOjTests {
    public CF1965ATests() {
        super("/p1965/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1965A.main(null);
        super.doAssertion(OUTPUT1);
    }
}

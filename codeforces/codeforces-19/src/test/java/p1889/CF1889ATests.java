package p1889;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1889ATests extends AbstractOjTests {
    public CF1889ATests() {
        super("/p1889/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1889A.main(null);
        super.doAssertion(OUTPUT1);
    }
}

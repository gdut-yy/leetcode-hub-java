package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921ATests extends AbstractOjTests {
    public CF1921ATests() {
        super("/p1921/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921A.main(null);
        super.doAssertion(OUTPUT1);
    }
}

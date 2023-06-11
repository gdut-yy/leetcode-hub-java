package p1790;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1790ATests extends AbstractOjTests {
    public CF1790ATests() {
        super("/p1790/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1790A.main(null);
        super.doAssertion();
    }
}

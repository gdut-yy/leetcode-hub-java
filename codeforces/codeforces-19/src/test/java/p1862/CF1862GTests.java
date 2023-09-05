package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862GTests extends AbstractOjTests {
    public CF1862GTests() {
        super("/p1862/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862A.main(null);
        super.doAssertion();
    }
}
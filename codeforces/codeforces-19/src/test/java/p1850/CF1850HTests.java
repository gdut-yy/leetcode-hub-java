package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850HTests extends AbstractOjTests {
    public CF1850HTests() {
        super("/p1850/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850H.main(null);
        super.doAssertion();
    }
}
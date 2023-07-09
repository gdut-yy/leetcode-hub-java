package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846ATests extends AbstractOjTests {
    public CF1846ATests() {
        super("/p1846/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846A.main(null);
        super.doAssertion();
    }
}
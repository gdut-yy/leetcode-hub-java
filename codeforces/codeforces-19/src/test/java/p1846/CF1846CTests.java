package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846CTests extends AbstractOjTests {
    public CF1846CTests() {
        super("/p1846/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846C.main(null);
        super.doAssertion();
    }
}
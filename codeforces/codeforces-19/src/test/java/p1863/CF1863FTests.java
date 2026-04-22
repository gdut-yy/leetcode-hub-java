package p1863;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1863FTests extends AbstractOjTests {
    public CF1863FTests() {
        super("/p1863/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1863F.main(null);
        super.doAssertion();
    }
}
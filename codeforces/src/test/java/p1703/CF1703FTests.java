package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703FTests extends AbstractOjTests {
    public CF1703FTests() {
        super("/p1703/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703F.main(null);
        super.doAssertion();
    }
}

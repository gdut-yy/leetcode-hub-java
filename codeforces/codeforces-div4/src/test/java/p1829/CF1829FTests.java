package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829FTests extends AbstractOjTests {
    public CF1829FTests() {
        super("/p1829/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829F.main(null);
        super.doAssertion();
    }
}

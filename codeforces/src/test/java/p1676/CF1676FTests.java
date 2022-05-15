package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676FTests extends AbstractOjTests {
    public CF1676FTests() {
        super("/p1676/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676F.main(null);
        super.doAssertion();
    }
}

package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690FTests extends AbstractOjTests {
    public CF1690FTests() {
        super("/p1690/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690F.main(null);
        super.doAssertion();
    }
}

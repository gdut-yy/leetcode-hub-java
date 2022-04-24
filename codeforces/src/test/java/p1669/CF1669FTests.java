package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669FTests extends AbstractOjTests {
    public CF1669FTests() {
        super("/p1669/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669F.main(null);
        super.doAssertion();
    }
}

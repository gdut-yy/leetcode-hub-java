package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722FTests extends AbstractOjTests {
    public CF1722FTests() {
        super("/p1722/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722F.main(null);
        super.doAssertion();
    }
}

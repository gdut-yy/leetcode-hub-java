package p1837;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1837FTests extends AbstractOjTests {
    public CF1837FTests() {
        super("/p1837/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1837F.main(null);
        super.doAssertion();
    }
}
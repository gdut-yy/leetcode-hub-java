package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702FTests extends AbstractOjTests {
    public CF1702FTests() {
        super("/p1702/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702F.main(null);
        super.doAssertion();
    }
}

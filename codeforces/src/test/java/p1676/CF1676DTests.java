package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676DTests extends AbstractOjTests {
    public CF1676DTests() {
        super("/p1676/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676D.main(null);
        super.doAssertion();
    }
}

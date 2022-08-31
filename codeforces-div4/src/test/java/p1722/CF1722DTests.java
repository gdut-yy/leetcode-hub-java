package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722DTests extends AbstractOjTests {
    public CF1722DTests() {
        super("/p1722/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722D.main(null);
        super.doAssertion();
    }
}

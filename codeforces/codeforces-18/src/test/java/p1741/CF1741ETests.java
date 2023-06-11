package p1741;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1741ETests extends AbstractOjTests {
    public CF1741ETests() {
        super("/p1741/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1741E.main(null);
        super.doAssertion();
    }
}

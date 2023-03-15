package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692ETests extends AbstractOjTests {
    public CF1692ETests() {
        super("/p1692/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692E.main(null);
        super.doAssertion();
    }
}

package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692FTests extends AbstractOjTests {
    public CF1692FTests() {
        super("/p1692/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692F.main(null);
        super.doAssertion();
    }
}

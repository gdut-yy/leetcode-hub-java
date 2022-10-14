package p1741;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1741ATests extends AbstractOjTests {
    public CF1741ATests() {
        super("/p1741/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1741A.main(null);
        super.doAssertion();
    }
}
